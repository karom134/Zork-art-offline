package ooc.hw2.helper;

import ooc.hw2.game.Game;
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
        heroDetail.put("mp",game.getHero().getMp());
        JSONObject heroObject=new JSONObject();
        heroObject.put("hero",heroDetail);

        JSONObject inventoryDetail=new JSONObject();
        inventoryDetail.put("potion",game.getHero().getInventory().getBagPack().get("potion").getSecond());
        inventoryDetail.put("Spotion",game.getHero().getInventory().getBagPack().get("Spotion").getSecond());
        inventoryDetail.put("Hpotion",game.getHero().getInventory().getBagPack().get("Hpotion").getSecond());
        inventoryDetail.put("Mpotion",game.getHero().getInventory().getBagPack().get("Mpotion").getSecond());
        JSONObject inventoryObject=new JSONObject();
        inventoryObject.put("inventory",inventoryDetail);

        JSONObject monsterDetail=new JSONObject();
        for (Integer i:game.getMapBuilder().getMonsterLocation()) {
            monsterDetail.put(i,game.getMap()[i/game.getMap().length][i%game.getMap().length].getEnemy().getLifeCycle());
        }
        JSONObject monsterObject=new JSONObject();
        monsterObject.put("monster",monsterDetail);

        JSONObject bossDefeated=new JSONObject();
        for (Integer i:game.getDefeatedBoss()) {
            bossDefeated.put(i,i);
        }
        JSONObject defeatedObject=new JSONObject();
        defeatedObject.put("defeated",bossDefeated);
        JSONArray main=new JSONArray();
        main.add(mapDetail);
        main.add(heroObject);
        main.add(inventoryObject);
        main.add(monsterObject);
        main.add(defeatedObject);
        try (FileWriter file = new FileWriter("../ZorkArtOffline/src/main/resources/"+name+".json")) {

            file.write(main.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
