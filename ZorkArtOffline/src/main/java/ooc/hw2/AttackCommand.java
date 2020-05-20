package ooc.hw2;

public class AttackCommand implements Command {
    private Hero hero;
    private Enemy monster;
    private String description;
    public AttackCommand(Hero hero, Enemy monster, String desc){
        this.hero=hero;
        this.monster=monster;
        this.description=desc;
    }


    @Override
    public String getDescription() {
        return this.description;
    }

    public void skillValidation(Integer netDamage,double accuracy,Integer mpUsage) {
        double checker = Math.random();
        if (mpUsage > hero.getMp()) {
            System.out.println("not enough mp");
        }
        else {
            if (checker <= accuracy) {
                monster.updateHp(netDamage);
            } else {
                System.out.println("Sorry,you missed the attack");
            }
            hero.updateHpMp(0,-mpUsage);
        }
    }

    @Override
    public void execute(String word2) {
        int netAttack=hero.getAttack()+hero.checkWeapons().getAttackDamage();
        int damageReduction= Math.toIntExact(Math.round(Math.pow(monster.getDefence(), ((double) 1) / 2) * 2));
        if(word2.equals("skill1") && hero.getSkill1()){
            double skillDamage=netAttack*1.3;
            Integer netDamage=Math.toIntExact(Math.round(skillDamage*(1-((double) damageReduction)/100)));
            skillValidation(netDamage,0.9,15);
        }
        else if(word2.equals("skill2")&& hero.getSkill2()){
            double skillDamage=netAttack*1.5;
            Integer netDamage=Math.toIntExact(Math.round(skillDamage*(1-((double) damageReduction)/100)));
            skillValidation(netDamage,0.8,25);
        }
        else if(word2.equals("skill3")&& hero.getSkill3()){
            double skillDamage=netAttack*2;
            Integer netDamage=Math.toIntExact(Math.round(skillDamage*(1-((double) damageReduction)/100)));
            skillValidation(netDamage,0.7,40);
        }
        else if(word2.equals("skill4")&& hero.getSkill4()){
            double skillDamage=netAttack*4;
            Integer netDamage=Math.toIntExact(Math.round(skillDamage*(1-((double) damageReduction)/100)));
            skillValidation(netDamage,0.9,150);
        }
        else{
            Integer netDamage=Math.toIntExact(Math.round(netAttack*(1-((double) damageReduction)/100)));
            skillValidation(netDamage,1.0,0);
        }

    }
}
