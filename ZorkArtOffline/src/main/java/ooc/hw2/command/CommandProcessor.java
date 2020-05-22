package ooc.hw2.command;

import ooc.hw2.Parser;
import ooc.hw2.command.CommandFactory;

public interface CommandProcessor {
    default void processCommand(Parser parser, CommandFactory commandFactory){
        String input = parser.getCommand();
        String word1 = input.split("/")[0];
        String word2 = input.split("/")[1];
        if (commandFactory.checkAvailability(word1)) {
            commandFactory.accessCommand(word1).execute(word2);
        } else {
            System.out.println("We don't know that command or that command can't be used right now.");
        }
    }
}
