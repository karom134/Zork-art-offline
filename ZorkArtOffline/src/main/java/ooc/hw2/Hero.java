package ooc.hw2;

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
    private Integer StatPoint;

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
        this.StatPoint=10;
    }

    public void turnRegeneration(){
        if(this.hp<this.maxHp){
            this.hp++;
        }
        if(this.mp<this.maxMp){
            this.mp++;
        }
    }

    public void levelUp(){
        this.maxHp+=5;
        this.maxMp+=5;
        this.attack+=2;
        this.defence+=2;
        this.StatPoint+=2;
    }

    public void updateExperience(Integer exp){
        this.experiencePoint+=exp;
        if(this.experiencePoint<=Math.pow(this.level,2)){
            levelUp();
            this.experiencePoint=0;
        }
    }

    public void updateStatPoint(String arg){
        if(this.StatPoint!=0){
            switch (arg) {
                case "atk":
                    this.attack += 1;
                    this.StatPoint -= 1;
                    break;
                case "def":
                    this.defence += 1;
                    this.StatPoint -= 1;
                    break;
                case "eva":
                    if (this.evasion < 50) {
                        this.evasion += 1;
                        this.StatPoint -= 1;
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
}
