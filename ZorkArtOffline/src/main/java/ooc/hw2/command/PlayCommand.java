package ooc.hw2.command;

import ooc.hw2.Game;

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
            game.createMap(word2);
        }
    }
}
