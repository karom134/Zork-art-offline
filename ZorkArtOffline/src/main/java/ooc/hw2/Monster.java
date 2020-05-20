package ooc.hw2;


import java.util.Random;

public class Monster implements Enemy {
    private Integer hp;
    private Integer attack;
    private Integer defence;
    private Integer location;
    private Integer lifeCycle;
    private MovementControl movementControl;
    public Monster(MovementControl movementControl){
        hp=100;
        attack=10;
        defence=5;
        this.movementControl=movementControl;
        Random random=new Random();
        location=random.nextInt((int) Math.pow(this.movementControl.getSize(),2));
        lifeCycle=0;
    }
    @Override
    public Integer getHp() {
        return this.hp;
    }

    @Override
    public Integer getAttack() {
        return this.attack;
    }

    @Override
    public Integer getDefence() {
        return this.defence;
    }

    @Override
    public Integer getLocation() {
        return this.location;
    }

    public Integer getLifeCycle(){
        return this.lifeCycle;
    }
    public void moveMonster(){
        this.location=movementControl.randomMove(this.location);
    }
    public void updateMonster(){
        lifeCycle+=1;
        hp+=5;
        attack+=5;
        defence+=5;
    }
    public void updateHp(Integer damage){
        this.hp-=damage;
    }
}
