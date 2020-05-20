package ooc.hw2.item;

public class MaxPotion implements Item{
    private String name="Max potion";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer use() {
        return 10000;
    }
}
