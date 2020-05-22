package ooc.hw2.command;

import ooc.hw2.Game;

public class ExitCommand implements Command{
    private Game game;

    public ExitCommand(Game game){
        this.game=game;
    }
    @Override
    public String getDescription() {
        return "Use this command to exit from this map";
    }

    @Override
    public void execute(String word2) {
        game.exitGame();
        System.out.println("You exit from the map");
        System.out.println("If you want to continue playing, use play to create new map");
    }
}
