package ooc.hw2.command;

import ooc.hw2.Hero;
import ooc.hw2.item.Item;

public class DrinkCommand implements Command{
    private Hero hero;
    public DrinkCommand(Hero hero){
        this.hero=hero;
    }
    @Override
    public String getDescription() {
        return "Use this command to drink potion if needed";
    }

    @Override
    public void execute(String word2) {
        Item potion=hero.getInventory().accessItem(word2);
        if(potion!=null){
            Integer effect=potion.use();
            hero.updateHpMp(effect,0);
        }
        hero.getInventory().dropItem(word2);
    }
}
