package ooc.hw2.item;



public class Potion implements Item {
    private String name="potion";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer use() {
        return 20;
    }
}
