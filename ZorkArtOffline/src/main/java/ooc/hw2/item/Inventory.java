package ooc.hw2.item;

import java.util.HashMap;
import java.util.Map;

import ooc.hw2.helper.Pair;


public class Inventory {
    private Map<String,Pair> bagPack;
    public Inventory(){
        bagPack=new HashMap<>();
        bagPack.put("potion", new Pair(new Potion(),0));
    }

    public Inventory(Map<String,Pair> map){
        bagPack=map;
    }

    public void dropItem(String itemName) {
        Pair pair=bagPack.get(itemName);
        if (pair.getSecond() != 0) {
            pair.setSecond(pair.getSecond()-1);
            bagPack.put(itemName, pair);
        }
        else{
            System.out.println("You can't drop the item you don't have");
        }
    }

    public void addItem(String itemName) {
        Pair pair=bagPack.get(itemName);
        pair.setSecond(pair.getSecond()+1);
        bagPack.put(itemName, pair);
    }

    public Map<String, Pair> getBagPack() {
        return bagPack;
    }
}
