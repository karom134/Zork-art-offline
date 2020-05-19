package ooc.hw2;


public class Monster implements Enemy {
    private Integer hp;
    private Integer attack;
    private Integer defence;
    private Integer location;
    private Integer lifeCycle;
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

    }
    public void updateMonster(){
        lifeCycle+=1;
        hp+=5;
        attack+=5;
        defence+=5;
    }
    public void monsterMovement(){

    }
}
