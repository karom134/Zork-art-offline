package ooc.hw2.item;

public class HyperPotion implements Item {
    private String name="Hyper potion";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer use() {
        return 200;
    }
}
