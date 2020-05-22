package ooc.hw2;

import ooc.hw2.command.CommandFactory;
import ooc.hw2.command.CommandProcessor;

public class Game extends GameEditor implements CommandProcessor {
    public Game(CommandFactory commandFactory){
        hero=new Hero();
        this.commandFactory=commandFactory;
        this.mapExist=false;
        this.gameClear=false;
        this.quit=false;
        parser=new Parser();
    }

    public void play(){
        while(!(quit||gameClear)){
            processCommand(parser,commandFactory);
            while(mapExist){
                System.out.println("The game is playable");
            }
        }
    }

}
