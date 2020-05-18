package ooc.hw2;

import java.lang.reflect.Array;
import java.util.*;

public class CommandWords {
    private List<String> commandLists;
//Check all possible command also work aith adding or removing extra command.
    public CommandWords() {
        String[] strArr={"info","take","drop","attack", "go", "map","autopilot", "help", "quit", "play"
        ,"load", "save", "exit"};
        commandLists = new ArrayList<String>(Arrays.asList(strArr));
    }
    public void addCommand(String command) {
        commandLists.add(command);
    }

    public boolean isCommand(String command){
        return commandLists.contains(command);
    }
}

