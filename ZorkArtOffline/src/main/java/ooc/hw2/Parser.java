package ooc.hw2;

import java.util.Scanner;

public class Parser {
    private CommandWords commands;
    private Scanner reader;
//Get command into the game.
    public Parser(String[] args) {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public String getCommand() {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }
        if(commands.isCommand(word1)){
            return word1+word2;
        }
        else{
            System.out.println("I don't understand what you want.....try again please.");
            return null;
        }
    }
}

