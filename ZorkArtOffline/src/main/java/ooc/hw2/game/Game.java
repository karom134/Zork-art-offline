package ooc.hw2.game;

import ooc.hw2.command.*;
import ooc.hw2.hostileunit.Enemy;

import java.io.IOException;
import java.util.ArrayList;

public class Game extends GameEditor implements CommandProcessor {
    public Game(CommandFactory commandFactory){
        this.commandFactory=commandFactory;
        this.mapExist=false;
        this.gameClear=false;
        this.quit=false;
        parser=new Parser();
        this.defeatedBoss=new ArrayList<>();
        loaded=false;
    }
    public Boolean getLoaded(){
        return this.loaded;
    }
    public void setLoaded(){
        loaded=true;
    }
    public void generateGamePlayCommand(){
        commandFactory.addCommand("map", new MapCommand(mapBuilder));
        commandFactory.addCommand("battle",new BattleCommand(hero,commandFactory));
        commandFactory.addCommand("drink",new DrinkCommand(hero));
        commandFactory.addCommand("take",new TakeCommand(hero));
        commandFactory.addCommand("drop",new DropCommand(hero));
        commandFactory.addCommand("info",new InfoCommand(hero));
        commandFactory.addCommand("upgrade",new UpgradeCommand(hero));
        commandFactory.addCommand("go",new GoCommand(hero,map));
        commandFactory.addCommand("autopilot",new AutopilotCommand(commandFactory));
    }

    public void afterBattleCalculation(){
        if(hero.getLocation().getHostility()) {
            Enemy monster = hero.getLocation().getEnemy();
            if (monster.getHp() <= 0) {
                if (monster.getStatus().equals("roaming")) {
                    hero.updateExperience(20 + monster.getLifeCycle() * 3);
                    hero.checkWeapons().upgrade();
                    mapBuilder.getMonsterLocation().remove(hero.getLocation().getId());
                    //System.out.println(mapBuilder.getMonsterLocation().toString());
                    mapBuilder.upgradeAllMonster();
                    mapBuilder.spawnMonster(1);
                    //System.out.println(mapBuilder.getMonsterLocation().toString());
                } else if (monster.getStatus().equals("terrain boss")) {
                    hero.updateExperience(1500);
                    hero.unlockSkill();
                    defeatedBoss.add(hero.getLocation().getId());
                } else if (monster.getStatus().equals("calamity boss")) {
                    gameClear = true;
                }
                hero.getLocation().removeMonster();
            }
        }
        if(hero.getHp()<=0){
            System.out.println("You have been defeated");
            mapExist=false;
        }
    }

    public void printLocationDetail(){
        System.out.println(hero.getLocation().getTerrain()+"  "+hero.getLocation().getId().toString());
        if(hero.getLocation().getHostility()) {
            System.out.println("There is a "+hero.getLocation().getEnemy().getStatus()+" in here.");
        }
        else{
            System.out.println("There is no enemy here.");
        }
        if(hero.getLocation().getItemExist()){
            System.out.println("There is "+hero.getLocation().getItem()+" drop here.");
        }else{
            System.out.println("There is no item in here.");
        }
    }

    public void removeGamePlayCommand(){
        commandFactory.removeCommand("map");
        commandFactory.removeCommand("battle");
        commandFactory.removeCommand("drink");
        commandFactory.removeCommand("take");
        commandFactory.removeCommand("drop");
        commandFactory.removeCommand("info");
        commandFactory.removeCommand("upgrade");
        commandFactory.removeCommand("go");
        commandFactory.removeCommand("autopilot");
    }
    public void setHero(Hero hero){
        this.hero=hero;
    }
    public void play(){
        while(!quit){
            try {
                processCommand(parser,commandFactory);
            } catch (IOException e) {
                e.printStackTrace();
            }
            generateGamePlayCommand();
            if(mapExist&&!loaded) {
                Integer spawn = mapBuilder.getSpawn();
                hero.setLocation(map[spawn / mapBuilder.getSize()][spawn % mapBuilder.getSize()]);
                mapBuilder.spawnMonster(20);
            }
            while(mapExist && !gameClear){
                //System.out.println(getMapBuilder().getMonsterLocation().toString());
                printLocationDetail();
                try {
                    processCommand(parser,commandFactory);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                afterBattleCalculation();
                mapBuilder.moveMonster();
                //System.out.println(mapBuilder.getMonsterLocation().toString());
                mapBuilder.spawnItem(1);

                if(hero.getLocation().getTerrain().equals("Mountain")){
                    hero.updateHpMp(1,-2);
                }
                else if(hero.getLocation().getTerrain().equals("Dessert")){
                    hero.updateHpMp(-2,1);
                }
                else{
                    hero.updateHpMp(1,1);
                }
            }
            removeGamePlayCommand();
        }
    }

}
