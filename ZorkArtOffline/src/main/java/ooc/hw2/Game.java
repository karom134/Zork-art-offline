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
        commandFactory.addCommand("Info",new InfoCommand(hero));
        commandFactory.addCommand("upgrade",new UpgradeCommand(hero));
    }
    public void play(){
        while(!(quit||gameClear)){
            processCommand(parser,commandFactory);
            generateGamePlayCommand();
            while(mapExist){
                System.out.println("The game is playable");
                processCommand(parser,commandFactory);
                mapBuilder.moveMonster();
            }
        }
    }

}
