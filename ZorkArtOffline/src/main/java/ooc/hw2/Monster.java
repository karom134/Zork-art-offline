package ooc.hw2;


import java.util.Random;

public class Monster implements Enemy {
    private Integer hp;
    private Integer attack;
    private Integer defence;
    private Integer location;
    private Integer lifeCycle;

    private Boolean boss;
    public Monster(Integer size){
        hp=100;
        attack=10;
        defence=5;
        Random random=new Random();
        setLocation(size);
        lifeCycle=0;
    }

    public Monster(Integer health,Integer attack,Integer defence,
                   Integer location,Boolean status){
        hp=health;
        this.attack=attack;
        this.defence=defence;
        this.location=location;
        this.boss=status;
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

    @Override
    public Boolean getBoss() {
        return this.boss;
    }
    @Override
    public Integer getLifeCycle(){
        return this.lifeCycle;
    }
    @Override
    public void updateMonster(){
        if(!getBoss()) {
            lifeCycle += 1;
            hp += 5;
            attack += 5;
            defence += 5;
        }else{
            hp+=1000;
            attack+=100;
            defence+=50;
        }
    }

    @Override
    public void setLocation(Integer size) {
        Random random=new Random();
        location=random.nextInt((int) Math.pow(size,2));
    }

    @Override
    public void updateHp(Integer damage){
        this.hp-=damage;
    }
}
