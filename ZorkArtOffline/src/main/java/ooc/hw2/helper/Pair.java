package ooc.hw2.helper;

import ooc.hw2.item.Item;

public class Pair{
    private Item first;
    private Integer second;
    public Pair(Item item,Integer amount){
        first=item;
        second=amount;
    }

    public Item getFirst() {
        return  first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }
}
