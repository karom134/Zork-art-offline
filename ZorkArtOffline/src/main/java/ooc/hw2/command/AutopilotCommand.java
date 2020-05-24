package ooc.hw2.command;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AutopilotCommand implements Command{
    private CommandFactory commandFactory;

    public AutopilotCommand(CommandFactory commandFactory){
        this.commandFactory=commandFactory;
    }
    @Override
    public String getDescription() {
        return "use this command to auto play the game need script argument(Script1,Script2)";
    }

    @Override
    public void execute(String word2) throws IOException {
        List<String> keep=new ArrayList<>();
        keep.add("Script1");
        keep.add("Script2");
        keep.add("Script3");
        if(!keep.contains(word2)){
            System.out.println("Invalid script name");
        }
        else{
            String path="../ZorkArtOffline/src/main/resources/"+word2;
            FileReader fileReader = new FileReader(new File(path));
            BufferedReader reader=new BufferedReader(fileReader);
            String line=null;
            while((line = reader.readLine()) != null) {
                String[] stringArray=line.split(" ");
                if(commandFactory.checkAvailability(stringArray[0])){
                    commandFactory.accessCommand(stringArray[0]).execute(stringArray[1]);
                }

            }
        }
    }
}
