package ooc.hw2.command;

import ooc.hw2.Game;

public class QuitCommand implements Command{
    private Game game;

    public QuitCommand(Game game){
        this.game=game;
    }
    @Override
    public String getDescription() {
        return "Use this command to exit from this game";
    }

    @Override
    public void execute(String word2) {
        game.quitGame();
        game.exitGame();
        System.out.println("Thank you for playing");
    }
}
