package ooc.hw2.command;

import java.io.IOException;

public interface Command {
    String getDescription();

    void execute(String word2) throws IOException;

}
