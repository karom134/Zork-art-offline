package ooc.hw2.hostileunit;

import ooc.hw2.helper.Pair;

public abstract class Enemy {
    public Integer hp;
    public Integer attack;
    public Integer defence;
    public Integer lifeCycle;
    public String status;
    public String getStatus(){return this.status;}
    public Integer getHp(){
        return this.hp;
    }
    abstract public Integer attack();
    public Integer getDefence(){
        return this.defence;
    }
    public void updateHp(Integer netDamage){
        this.hp-=netDamage;
    }
    public Integer getLifeCycle(){
        return this.lifeCycle;
    }
    abstract public void updateMonster();
    public void piercing(Integer value){
       this.defence=Math.max(this.defence-value,0);
    }
    public void armBreak(Integer value){
        this.attack=Math.max(this.attack-value,0);
    }
}
