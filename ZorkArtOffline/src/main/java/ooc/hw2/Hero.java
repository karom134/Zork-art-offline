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
    private Integer statPoint;

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
        if(this.experiencePoint>=Math.pow(this.level,2)){
            levelUp();
            this.experiencePoint=0;
        }
    }
//Spend stat point on to hero(Just for variation of the gameplay experience).
    public void updateStatPoint(String arg){
        if(this.statPoint !=0){
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
}
