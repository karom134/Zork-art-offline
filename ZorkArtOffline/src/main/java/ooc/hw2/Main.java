package ooc.hw2;

import ooc.hw2.command.*;
import ooc.hw2.game.Game;

public class Main {
    public static void main(String[] args) {
        CommandFactory commandFactory=new CommandFactory();
        Game game=new Game(commandFactory);
        commandFactory.addCommand("play",new PlayCommand(game));
        commandFactory.addCommand("exit",new ExitCommand(game));
        commandFactory.addCommand("quit",new QuitCommand(game));
        commandFactory.addCommand("save",new SaveCommand(game));
        commandFactory.addCommand("load",new LoadCommand(game));
        commandFactory.addCommand("help",new HelpCommand(commandFactory));
        game.play();
    }
}
