package ooc.hw2.command;

import java.util.*;

public class CommandFactory {
    private Map<String, Command> commands;
    private Set<String> availableCommands;
//Check all possible command also work with adding or removing extra command.
    public CommandFactory() {
        commands= new HashMap<>();
        availableCommands=new HashSet<>();
    }
    public void setAvailableCommands(Set<String> set){
        availableCommands=set;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }

    public void resetAvailableCommand(){
        availableCommands.clear();
    }
    //If availableCommands empty==no limitation on using command.
    public Boolean checkAvailability(String key){
        return (availableCommands.isEmpty()||availableCommands.contains(key))&& commands.containsKey(key);
    }
    public Command accessCommand(String key){
        return commands.get(key);
    }
    public void addCommand(String key,Command command){
        commands.put(key,command);
    }
    public void removeCommand(String key){commands.remove(key);}
}

