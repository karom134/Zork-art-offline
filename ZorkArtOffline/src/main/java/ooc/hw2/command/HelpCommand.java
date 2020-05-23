package ooc.hw2.command;

public class HelpCommand implements Command{
    private CommandFactory commandFactory;

    public HelpCommand(CommandFactory commandFactory){
        this.commandFactory=commandFactory;
    }
    @Override
    public String getDescription() {
        return "Get help";
    }

    @Override
    public void execute(String word2) {
        for (String key: commandFactory.getCommands().keySet()
             ) {
            System.out.println(key+" : "+commandFactory.accessCommand(key).getDescription());
        }
    }
}
