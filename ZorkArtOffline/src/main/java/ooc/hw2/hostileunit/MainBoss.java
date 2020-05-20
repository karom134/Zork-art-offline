package ooc.hw2.hostileunit;

public class MainBoss extends Enemy {

    public MainBoss(){
        hp=8000;
        attack=350;
        defence=625;
        location=111;
        lifeCycle=0;
    }
    @Override
    public Integer attack() {
        return null;
    }

    @Override
    public void updateMonster() {

    }
}
