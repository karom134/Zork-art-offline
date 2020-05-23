package ooc.hw2.hostileunit;


public class Monster extends Enemy {

    public Monster(){
        hp=100;
        attack=10;
        defence=5;
        this.lifeCycle=0;
        status="roaming";
    }
    public Monster(Integer lifeCycle){
        hp=100+5*lifeCycle;
        this.attack=10+5*lifeCycle;
        this.defence=5+5*lifeCycle;
        this.lifeCycle=lifeCycle;
        status="roaming";
    }
    @Override
    public Integer attack() {
        return this.attack;
    }
    @Override
    public void updateMonster(){
            lifeCycle += 1;
            hp += 5;
            attack += 2;
            defence += 5;
    }
}
