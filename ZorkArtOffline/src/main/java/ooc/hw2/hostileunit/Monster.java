package ooc.hw2.hostileunit;


public class Monster extends Enemy {

    public Monster(){
        hp=100;
        attack=10;
        defence=5;
        this.lifeCycle=0;
        status="roaming";
    }
    public Monster(Integer health, Integer attack, Integer defence,Integer lifeCycle
                   ){
        hp=health;
        this.attack=attack;
        this.defence=defence;
        this.lifeCycle=lifeCycle;
    }
    @Override
    public Integer attack() {
        return this.attack;
    }
    @Override
    public void updateMonster(){
            lifeCycle += 1;
            hp += 5;
            attack += 5;
            defence += 5;
    }
}
