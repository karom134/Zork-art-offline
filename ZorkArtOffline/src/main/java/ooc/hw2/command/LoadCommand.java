package ooc.hw2.command;

import ooc.hw2.Game;
import ooc.hw2.JsonReader;

public class LoadCommand implements Command {
    Game game;

    public LoadCommand(Game game){
        this.game=game;
    }

    @Override
    public String getDescription() {
        return "use this to load your save state.";
    }

    @Override
    public void execute(String word2) {
        JsonReader jsonReader=new JsonReader(game);
        jsonReader.loader(word2);
    }
}
