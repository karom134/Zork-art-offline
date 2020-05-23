package ooc.hw2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {
    public Game game;

    public JsonWriter(Game game){
        this.game=game;
    }

    public void writer(String name){
        JSONObject mapDetail=new JSONObject();
        mapDetail.put("map",game.getMapId());

        JSONObject heroDetail=new JSONObject();
        heroDetail.put("hp",game.getHero().getHp());
        heroDetail.put("level",game.getHero().getLevel());
        heroDetail.put("statpoint",game.getHero().getStatPoint());
        heroDetail.put("eva",game.hero.getEvasion());
        heroDetail.put("def",game.getHero().getDefence());
        heroDetail.put("atk",game.getHero().getAttack());
        heroDetail.put("sword",game.getHero().checkWeapons().getAttackDamage());
        heroDetail.put("loc",game.getHero().getLocation().getId());
        heroDetail.put("exp",game.getHero().getExperiencePoint());
        JSONObject heroObject=new JSONObject();
        heroObject.put("hero",heroDetail);


        JSONArray main=new JSONArray();
        main.add(mapDetail);
        main.add(heroObject);
        try (FileWriter file = new FileWriter("../ZorkArtOffline/src/main/resources/"+name+".json")) {

            file.write(main.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
