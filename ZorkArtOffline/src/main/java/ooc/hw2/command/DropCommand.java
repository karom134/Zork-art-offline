package ooc.hw2.command;

import ooc.hw2.game.Hero;

public class DropCommand implements Command{
    private Hero hero;
    public DropCommand(Hero hero){
        this.hero=hero;
    }

    @Override
    public String getDescription() {
        return "Drop item from your bag to prove that you need no healing need item argument" +
                "(potion, Spotion, Hpotion, Mpotion)";
    }

    @Override
    public void execute(String word2) {
        if(hero.getInventory().getBagPack().keySet().contains(word2)){
            hero.getInventory().dropItem(word2);
        }
        else{
            System.out.println("You can't drop what you don't have");
        }
    }
}
