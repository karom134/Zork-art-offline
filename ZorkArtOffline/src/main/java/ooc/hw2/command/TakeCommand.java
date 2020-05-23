package ooc.hw2.command;

import ooc.hw2.game.Hero;

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
            if(hero.getInventory().getItemCount()<=40){
            hero.getInventory().addItem(hero.getLocation().getItem());
            hero.getLocation().removeItem();
            }
            else{
                System.out.println("Your inventory is full");
            }
        }
        else{
            System.out.println("No item in this room");
        }
    }
}
