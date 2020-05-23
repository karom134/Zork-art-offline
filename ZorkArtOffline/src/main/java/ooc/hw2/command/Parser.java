package ooc.hw2.command;

import java.util.Scanner;

public class Parser {
    private Scanner reader;
//Get command into the game.
    public Parser() {
        reader = new Scanner(System.in);
    }

    public String getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        inputLine = reader.nextLine();


        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return word1+"/"+word2;

    }
}

