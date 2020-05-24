package ooc.hw2.command;

import ooc.hw2.game.Game;
import ooc.hw2.helper.JsonWriter;

public class SaveCommand implements Command{
    private Game game;
    public SaveCommand(Game game){
        this.game=game;
    }

    @Override
    public String getDescription() {
        return "use this to save the game need state's argument";
    }

    @Override
    public void execute(String word2) {
        if(game.getMapExist()) {
            JsonWriter jsonWriter = new JsonWriter(game);
            jsonWriter.writer(word2);
        } else{
            System.out.println("can't use this command now");
        }

    }
}
