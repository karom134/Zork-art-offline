package ooc.hw2.item;

import java.util.HashMap;
import java.util.Map;

import ooc.hw2.helper.Pair;


public class Inventory {
    private Map<String,Pair> bagPack;
    private Integer itemCount;
    public Inventory(){
        bagPack=new HashMap<>();
        bagPack.put("potion", new Pair(new Potion(),0));
        bagPack.put("Spotion", new Pair(new SuperPotion(),0));
        bagPack.put("Hpotion", new Pair(new HyperPotion(),0));
        bagPack.put("Mpotion", new Pair(new MaxPotion(),0));
        itemCount=0;
    }

    public Inventory(Map<String,Pair> map){
        bagPack=map;
        itemCount=0;
        for(String key:map.keySet()){
            itemCount+=(Integer) bagPack.get(key).getSecond();
        }
    }

    public void dropItem(String itemName) {
        itemCount-=1;
        Pair pair=bagPack.get(itemName);
        if (((Integer)pair.getSecond()) != 0) {
            pair.setSecond(((Integer)pair.getSecond())-1);
            bagPack.put(itemName, pair);
        }
    }

    public void addItem(String itemName) {
        itemCount+=1;
        Pair pair=bagPack.get(itemName);
        pair.setSecond(((Integer)pair.getSecond())+1);
        bagPack.put(itemName, pair);
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public Item accessItem(String arg) {
        if (!bagPack.containsKey(arg)) {
            System.out.println("Invalid item name");
            return null;
        } else {
            if ((Integer) bagPack.get(arg).getSecond() != 0) {
                return (Item) bagPack.get(arg).getFirst();
            } else {
                System.out.println("You don't have that item in the inventory");
                return null;
            }
        }
    }

    public Map<String, Pair> getBagPack() {
        return bagPack;
    }

    public String toString(){
        String tmp="";
        for(String key:bagPack.keySet()){
            tmp=tmp+key+":"+bagPack.get(key).getSecond()+" ";
        }
        return tmp;
    }
}
