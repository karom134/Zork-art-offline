package ooc.hw2;

import java.util.Scanner;

public class Parser {
    private Scanner reader;
//Get command into the game.
    public Parser() {
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

        return word1+"/"+word2;

    }
}

