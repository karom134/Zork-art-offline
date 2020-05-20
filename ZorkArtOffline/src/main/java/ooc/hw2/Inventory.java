package ooc.hw2;

import java.util.HashMap;
import java.util.Map;
import ooc.hw2.helper.Pair;

public class Inventory {
    private Map<String,Pair> bagPack;
    public Inventory(){
        bagPack=new HashMap<>();
    }

    public Inventory(Map<String,Pair> map){
        bagPack=map;
    }

    public void dropItem(String itemName) {
        if (bagPack.get(itemName).getSecond() != 0) {
            bagPack.put(itemName, bagPack.get(item) - 1);
        }
        else{
            System.out.println("You can't drop the item you don't have");
        }
    }

    public void addItem(Item item) {
        bagPack.put(item, bagPack.getOrDefault(item,0) + 1);
    }

    public Map<Item, Integer> getBagPack() {
        return bagPack;
    }
}
