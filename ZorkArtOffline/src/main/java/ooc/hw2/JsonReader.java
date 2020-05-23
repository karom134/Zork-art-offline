package ooc.hw2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    private Game game;
    private JSONArray jsonArray;
    public JsonReader(Game game){
        this.game=game;
    }

    public void reader(String name){
        String defaultPath="../ZorkArtOffline/src/main/resources/";
        String path=defaultPath+name+".json";
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(path)){
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            jsonArray = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void loader(String name){
        reader(name);
        JSONObject mapObject=(JSONObject) jsonArray.get(0);
        game.getMapBuilder().constructFinalMap("../ZorkArtOffline/src/main/resources/"+mapObject.get("map"));
    }

    public static void main(String[] args) {
    }
}
