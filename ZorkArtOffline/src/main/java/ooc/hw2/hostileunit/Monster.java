package ooc.hw2.hostileunit;


import ooc.hw2.Grid;
import ooc.hw2.helper.Pair;

public class Monster extends Enemy {

    public Monster(Integer size){
        hp=100;
        attack=10;
        defence=5;
        this.lifeCycle=0;
    }
    public Monster(Integer health, Integer attack, Integer defence,
                   Pair location){
        hp=health;
        this.attack=attack;
        this.defence=defence;
        this.location=location;

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
