package ooc.hw2.item;

public class SuperPotion implements Item{
    private String name="Spotion";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer use() {
        return 60;
    }
}
