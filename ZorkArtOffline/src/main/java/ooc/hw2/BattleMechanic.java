package ooc.hw2;

import ooc.hw2.command.AttackCommand;
import ooc.hw2.command.CommandFactory;
import ooc.hw2.command.CommandProcessor;
import ooc.hw2.hostileunit.Enemy;

import java.util.HashSet;
import java.util.Set;

public class BattleMechanic implements CommandProcessor {
    private Hero hero;
    private Enemy monster;
    private CommandFactory commandFactory;
    private Parser parser;
    public BattleMechanic(Hero hero, Enemy monster, CommandFactory commandFactory){
        this.hero=hero;
        this.monster=monster;
        this.commandFactory=commandFactory;
        parser=new Parser();
    }

    public Boolean isEnd(){
        return hero.getHp()<=0 || monster.getHp()<=0;
    }
    public void retaliate(){
        Integer rawDamage=monster.attack();
        int damageReduction;
        if(!hero.getLocation().getTerrain().equals("Forest")) {
            damageReduction=Math.toIntExact(Math.round(Math.pow(hero.getDefence(), ((double) 1) / 2) * 2));
        }else{
            damageReduction=Math.toIntExact(Math.round(Math.pow(hero.getDefence(), ((double) 1) / 2) * 2*0.9));
        }
        int netDamage=Math.toIntExact(Math.round(rawDamage*(1-((double) damageReduction)/100)));
        if(Math.random()<((double)hero.getEvasion())/100){
            System.out.println("You evade the attack");
        }
        else{
            hero.updateHpMp(-netDamage,0);
        }
    }
    public void battle() {
        Boolean end = false;
        commandFactory.addCommand("attack", new AttackCommand(hero, monster, "Use this command to attack your enemy"));
        Set<String> set = new HashSet<>();
        set.add("attack");
        set.add("info");
        set.add("drink");
        set.add("help");
        commandFactory.setAvailableCommands(set);
        while (!end) {
            processCommand(parser,commandFactory);
            retaliate();
            if(hero.getLocation().getTerrain().equals("Dessert")) {
                hero.updateHpMp(-2, 1);
            }
            else if(hero.getLocation().getTerrain().equals("Mountain")){
                hero.updateHpMp(1, -2);
            }
            else{
                hero.updateHpMp(1,1);
            }
            System.out.println("Monster:" + monster.getHp() + " Hero:"
                    + hero.getHp().toString() + "/" + hero.getMaxHp());
            end = isEnd();
        }
        commandFactory.resetAvailableCommand();
        commandFactory.removeCommand("attack");
    }
}
