package ooc.hw2;

public class attackCommand implements Command {
    private Hero hero;
    private Monster monster;
    private String description;
    public attackCommand(Hero hero, Monster monster,String desc){
        this.hero=hero;
        this.monster=monster;
        this.description=desc;
    }


    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void execute(String word2) {
        Integer netAttack=hero.getAttack()+hero.checkWeapons().getAttackDamage();
        Integer damageReduction= Math.toIntExact(Math.round(Math.pow(monster.getDefence(), 1 / 2) * 2));
        Integer netDamage=Math.toIntExact(Math.round(netAttack*damageReduction/100));
        monster.updateHp(netDamage);
    }
}
