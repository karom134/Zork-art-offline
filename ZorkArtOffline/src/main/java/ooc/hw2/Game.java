package ooc.hw2;

import ooc.hw2.command.*;

public class Game extends GameEditor implements CommandProcessor {
    public Game(CommandFactory commandFactory){
        hero=new Hero();
        this.commandFactory=commandFactory;
        this.mapExist=false;
        this.gameClear=false;
        this.quit=false;
        parser=new Parser();
    }
    public void generateGamePlayCommand(){
        commandFactory.addCommand("map", new MapCommand(mapBuilder));
        commandFactory.addCommand("battle",new BattleCommand(hero,commandFactory));
        commandFactory.addCommand("drink",new DrinkCommand(hero));
        commandFactory.addCommand("take",new TakeCommand(hero));
        commandFactory.addCommand("drop",new DropCommand(hero));
        commandFactory.addCommand("info",new InfoCommand(hero));
        commandFactory.addCommand("upgrade",new UpgradeCommand(hero));
    }

    public void removeGamePlayCommand(){
        commandFactory.removeCommand("map");
        commandFactory.removeCommand("battle");
        commandFactory.removeCommand("drink");
        commandFactory.removeCommand("take");
        commandFactory.removeCommand("drop");
        commandFactory.removeCommand("info");
        commandFactory.removeCommand("upgrade");
    }
    public void play(){
        while(!(quit||gameClear)){
            processCommand(parser,commandFactory);
            generateGamePlayCommand();
            Integer spawn=mapBuilder.getSpawn();
            hero.setLocation(map[spawn/mapBuilder.getSize()][spawn%mapBuilder.getSize()]);
            while(mapExist){
                System.out.println("The game is playable");
                processCommand(parser,commandFactory);
                mapBuilder.moveMonster();
            }
            removeGamePlayCommand();
        }
    }

}
