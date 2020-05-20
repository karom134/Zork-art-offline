package ooc.hw2.hostileunit;

import java.util.Random;

public abstract class Enemy {
    public Integer hp;
    public Integer attack;
    public Integer defence;
    public Integer location;
    public Integer lifeCycle;
    public Integer getHp(){
        return this.hp;
    }
    abstract public Integer attack();
    public Integer getDefence(){
        return this.defence;
    }
    public Integer getLocation(){
        return this.location;
    }
    public void updateHp(Integer netDamage){
        this.hp-=netDamage;
    }
    public Integer getLifeCycle(){
        return this.lifeCycle;
    }
    abstract public void updateMonster();
    public void setLocation(Integer size){
        Random random=new Random();
        location=random.nextInt((int) Math.pow(size,2));
    }
    public void piercing(Integer value){
       this.defence=Math.max(this.defence-value,0);
    }
    public void armBreak(Integer value){
        this.attack=Math.max(this.attack-value,0);
    }
}
