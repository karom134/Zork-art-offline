package ooc.hw2.command;

import ooc.hw2.game.Game;
import ooc.hw2.game.Hero;

public class PlayCommand implements Command{
    private Game game;

    public PlayCommand(Game game){
        this.game=game;
    }
    @Override
    public String getDescription() {
        return "Use this command to start the game";
    }

    @Override
    public void execute(String word2) {
        if(game.getMapExist()){
            System.out.println("Command won't work as you already in the game");
        }
        else{
            if(!word2.equals("Sample")){
                System.out.println("please enter the name of existing map");
                System.out.println("Existing map name: Sample");
            }else{
                game.createMap(word2);
                game.setHero(new Hero());
            }

        }
    }
}
