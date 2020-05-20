package ooc.hw2.command;

import ooc.hw2.Hero;

public class InfoCommand implements Command {
    private Hero hero;
    private String description;
    public InfoCommand(Hero hero,String desc){
        this.hero=hero;
        this.description=desc;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void execute(String word2) {
        System.out.println("HP:"+hero.getHp().toString()+"/"+hero.getMaxHp().toString());
        System.out.println("MP:"+hero.getMp().toString()+"/"+hero.getMaxMp().toString());
        System.out.println("Attack:"+hero.getAttack().toString());
        System.out.println("Defence:"+hero.getDefence().toString());
        System.out.println("Evasion"+hero.getLevel().toString());
        System.out.println("Weapon"+hero.checkWeapons().getAttackDamage().toString());
    }
}
