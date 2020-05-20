package ooc.hw2.hostileunit;

public class BossMonster extends Enemy{

    public BossMonster(Integer location){
        this.hp=1000;
        this.attack=50;
        this.defence=100;
        this.lifeCycle=0;
        this.location=location;
    }

    @Override
    public Integer attack() {
        double random=Math.random();
        if(random<=0.05){
            System.out.println("The boss decide to stare at you and do nothing");
            return 0;
        }
        else if(random<=0.60){
            System.out.println("The boss use his standard attack");
            double multiplier=0.8+0.4*Math.random();
            return Math.toIntExact(Math.round(attack*multiplier));
        }
        else if(random<=0.80){
            System.out.println("The boss buff it stat, his attack and defence are increasing");
            attack+=20;
            defence+=20;
            return 0;
        }
        else if(random<=0.90){
            System.out.println("The boss attack you furiously, this deal a lot of damage");
            return Math.toIntExact((long) (50+attack*1.5));
        }
        else if(random<=0.95){
            System.out.println("The boss use his ultimate attack, you might need to pray for survival.");
            Integer count=0;
            double multi=Math.random();
            while(multi<=0.6){
                count++;
                multi=Math.random();
            }
            return Math.toIntExact((long) (attack*0.75*count));
        }
        else{
            System.out.println("The boss decide to heal itself, He recover 20% of his current hp.");
            Integer healing=Math.toIntExact((long) (hp*0.2));
            updateHp(-healing);
            return 0;
        }
    }

    @Override
    public void updateMonster() {
        this.hp+=1000;
        this.attack+=50;
        this.defence+=50;
    }
}
