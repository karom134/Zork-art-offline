package ooc.hw2.game;

import ooc.hw2.helper.Pair;
import ooc.hw2.item.Inventory;
import ooc.hw2.item.Sword;
import ooc.hw2.map.Grid;

import java.util.Map;

public class Hero {
    private Integer hp;
    private Integer maxHp;
    private Integer mp;
    private Integer maxMp;
    private Integer attack;
    private Integer defence;
    private Integer evasion;
    private Integer level;
    private Integer experiencePoint;
    private Integer statPoint;
    private Sword sword;
    private Boolean skill1=false;
    private Boolean skill2=false;
    private Boolean skill3=false;
    private Boolean skill4=false;
    private Inventory inventory;
    private Grid location;

    public Hero(){
        this.hp=100;
        this.mp=100;
        this.attack=10;
        this.defence=10;
        this.evasion=0;
        this.level=5;
        this.experiencePoint=0;
        this.maxHp=100;
        this.maxMp=100;
        this.statPoint =10;
        sword=new Sword();
        this.inventory=new Inventory();
    }

    public Hero(Integer level,Integer attack,Integer defence,Integer evasion,Integer exp,Integer statPoint,
                Integer hp,Integer mp, Integer swordDamage, Map<String, Pair> map){
            this.hp=hp;
            this.mp=mp;
            this.level=level;
            this.maxHp=75+5*this.level;
            this.maxMp=75+5*this.level;
            this.statPoint=statPoint;
            this.experiencePoint=exp;
            this.evasion=evasion;
            this.defence=defence;
            this.attack=attack;
            this.sword=new Sword(swordDamage);
            this.inventory=new Inventory(map);

    }

    public Grid getLocation() {
        return location;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getEvasion() {
        return evasion;
    }

    public Integer getDefence() {
        return defence;
    }

    public Sword checkWeapons(){return this.sword;}

    public Integer getHp() {
        return hp;
    }

    public Integer getStatPoint() {
        return statPoint;
    }

    public Integer getMaxHp() {
        return maxHp;
    }

    public Integer getMaxMp() {
        return maxMp;
    }

    public Integer getMp() {
        return mp;
    }

    public Integer getLevel() {
        return level;
    }

    public Boolean getSkill1() {
        return skill1;
    }

    public Boolean getSkill2() {
        return skill2;
    }

    public Boolean getSkill3() {
        return skill3;
    }

    public Boolean getSkill4() {
        return skill4;
    }

    public Integer getExperiencePoint() {
        return experiencePoint;
    }

    //Update the change in hp/mp of hero.
    public void updateHpMp(Integer changeHp,Integer changeMp){
        this.hp=Math.min(this.hp+=changeHp,this.maxHp);
        this.mp=Math.min(this.mp+=changeMp,this.maxMp);
    }

    public void levelUp(){
        System.out.println("Congratulation your hero level up by 1");
        this.maxHp+=5;
        this.maxMp+=5;
        this.attack+=2;
        this.defence+=2;
        this.statPoint +=2;
        this.level+=1;
    }

//apply the exp to hero+check leveling up.
    public void updateExperience(Integer exp){
        this.experiencePoint+=exp;
        System.out.println("You gain "+exp.toString()+" experience point");
        while(this.experiencePoint>=Math.pow(this.level,2)){
            levelUp();
            this.experiencePoint-=Math.toIntExact((long) Math.pow(this.level,2));
        }
    }

//Spend stat point on to hero(Just for variation of the gameplay experience).
    public void updateStatPoint(String arg){
        if(this.statPoint !=0){
            System.out.println(arg+" has increased by 1");
            switch (arg) {
                case "atk":
                    this.attack += 1;
                    this.statPoint -= 1;
                    break;
                case "def":
                    this.defence += 1;
                    this.statPoint -= 1;
                    break;
                case "eva":
                    if (this.evasion < 50) {
                        this.evasion += 1;
                        this.statPoint -= 1;
                    } else {
                        System.out.println("Evasion maxed out already");
                    }
                    break;
            }
        }
        else{
            System.out.println("Not enough stat point");
        }
    }
    public void unlockSkill(){
        if(skill1){
            if(skill2){
                if(skill3){
                    if(skill4){
                        System.out.println("You unlock all skill");
                    }
                    skill4=true;
                }
                skill3=true;
            }
            skill2=true;
        }
        skill1=true;
    }
    public void setLocation(Grid location) {
        this.location = location;
    }
}
