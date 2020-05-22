package ooc.hw2.item;

public class MaxPotion implements Item{
    private String name="Mpotion";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer use() {
        return 10000;
    }
}
