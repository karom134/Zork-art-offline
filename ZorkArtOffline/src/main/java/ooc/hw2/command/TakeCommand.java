package ooc.hw2.command;

import ooc.hw2.Hero;

public class TakeCommand implements Command{
    private Hero hero;
    public TakeCommand(Hero hero){
        this.hero=hero;
    }

    @Override
    public String getDescription() {
        return "Use this command to take an item";
    }

    @Override
    public void execute(String word2) {
        if(hero.getLocation().getItemExist()){
            hero.getInventory().addItem(hero.getLocation().getItem());
        }
        else{
            System.out.println("No item in this room");
        }
    }
}
