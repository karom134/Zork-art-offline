package ooc.hw2.command;

import ooc.hw2.game.Hero;

public class InfoCommand implements Command {
    private Hero hero;

    public InfoCommand(Hero hero){
        this.hero=hero;

    }

    @Override
    public String getDescription() {
        return "Use this to get description of your hero.";
    }

    @Override
    public void execute(String word2) {
        System.out.println("Level:"+hero.getLevel().toString());
        System.out.println("HP:"+hero.getHp().toString()+"/"+hero.getMaxHp().toString());
        System.out.println("MP:"+hero.getMp().toString()+"/"+hero.getMaxMp().toString());
        System.out.println("Attack:"+hero.getAttack().toString());
        System.out.println("Defence:"+hero.getDefence().toString());
        System.out.println("Evasion:"+hero.getEvasion().toString());
        System.out.println("Weapon:"+hero.checkWeapons().getAttackDamage().toString());
        System.out.println("Inventory:"+hero.getInventory().toString());
        System.out.println("Unused Stat Point:"+hero.getStatPoint().toString());
    }
}
