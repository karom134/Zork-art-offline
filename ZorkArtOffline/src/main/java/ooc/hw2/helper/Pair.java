package ooc.hw2.helper;

import ooc.hw2.item.Item;

public class Pair{
    private Object first;
    private Object second;
    public Pair(Object item,Object amount){
        first=item;
        second=amount;
    }

    public Object getFirst() {
        return  first;
    }

    public Object getSecond() {
        return second;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

    public void setFirst(Object first) {
        this.first = first;
    }
}
