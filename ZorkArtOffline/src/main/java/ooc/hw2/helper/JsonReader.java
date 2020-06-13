package ooc.hw2.helper;

import ooc.hw2.game.Hero;
import ooc.hw2.game.Game;
import ooc.hw2.hostileunit.Monster;
import ooc.hw2.item.HyperPotion;
import ooc.hw2.item.MaxPotion;
import ooc.hw2.item.Potion;
import ooc.hw2.item.SuperPotion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        game.createMap((String) mapObject.get("map"));
        JSONObject heroObj=(JSONObject) jsonArray.get(1);
        JSONObject heroObject=(JSONObject) heroObj.get("hero");
        JSONObject inventoryObj=(JSONObject) jsonArray.get(2);
        JSONObject inventoryObject=(JSONObject) inventoryObj.get("inventory");
        Map<String, Pair> tmp=new HashMap<>();
        tmp.put("potion",new Pair(new Potion(),Math.toIntExact((Long) inventoryObject.get("potion"))));
        tmp.put("Spotion",new Pair(new SuperPotion(),Math.toIntExact((Long) inventoryObject.get("Spotion"))));
        tmp.put("Hpotion",new Pair(new HyperPotion(),Math.toIntExact((Long) inventoryObject.get("Hpotion"))));
        tmp.put("Mpotion",new Pair(new MaxPotion(),Math.toIntExact((Long) inventoryObject.get("Mpotion"))));
        Hero hero=new Hero(Math.toIntExact((Long) heroObject.get("level")),
                Math.toIntExact((Long) heroObject.get("atk")),
                Math.toIntExact((Long)heroObject.get("def")),
                Math.toIntExact((Long)heroObject.get("eva")),
                Math.toIntExact((Long) heroObject.get("exp")),
                Math.toIntExact((Long)heroObject.get("statpoint")),
                Math.toIntExact((Long)heroObject.get("hp")),
                Math.toIntExact((Long) heroObject.get("mp")),
                Math.toIntExact((Long) heroObject.get("sword")),
                tmp);
        game.setHero(hero);
        game.getHero().setLocation(game.getMap()[(Math.toIntExact((Long)heroObject.get("loc"))) /game.getMapBuilder().getSize()]
                [(Math.toIntExact((Long)heroObject.get("loc"))) %game.getMapBuilder().getSize()]);
        JSONObject monsterObj=(JSONObject) jsonArray.get(3);
        JSONObject monsterObject=(JSONObject) monsterObj.get("monster");
        Set monsterKeys = monsterObject.keySet();
        monsterKeys.forEach(key->{
            game.getMapBuilder().placeMonster(new Monster(Math.toIntExact((Long)monsterObject.get(key))), Integer.valueOf(key.toString()));
                }
                );
        JSONObject defeatedObj=(JSONObject) jsonArray.get(4);
        JSONObject defeatedObject=(JSONObject) defeatedObj.get("defeated");
        Set defeatedKeys = defeatedObject.keySet();
        for(Object key:defeatedKeys){
            game.getMapBuilder().upgradeAllBoss();
        }
        if(!defeatedKeys.isEmpty()){
            defeatedKeys.forEach(key->{
                game.getMap()[Integer.parseInt(key.toString())/game.getMapBuilder().getSize()][Integer.parseInt(key.toString())%game.getMapBuilder().getSize()]
                        .removeMonster();
                hero.unlockSkill();
            });
        }
        game.setLoaded();
    }
}
