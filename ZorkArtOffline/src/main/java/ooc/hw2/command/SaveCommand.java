package ooc.hw2.command;

import ooc.hw2.Game;
import ooc.hw2.JsonWriter;

public class SaveCommand implements Command{
    private Game game;
    public SaveCommand(Game game){
        this.game=game;
    }

    @Override
    public String getDescription() {
        return "use this to save the game";
    }

    @Override
    public void execute(String word2) {
        JsonWriter jsonWriter=new JsonWriter(game);
        jsonWriter.writer(word2);

    }
}
