package ooc.hw2.hostileunit;

public class MainBoss extends Enemy {

    public MainBoss(){
        hp=8000;
        attack=350;
        defence=625;
        lifeCycle=0;
        status="calamity boss";
    }
    @Override
    public Integer attack() {
        double random=Math.random();
        if(random<=0.05){
            System.out.println("The boss heal itself by 20%of it current hp and buff its attack massively");
            int healing=Math.toIntExact((long) (hp*0.2));
            updateHp(-healing);
            attack+=50;
            return 0;
        }
        else if(random<=0.1){
            System.out.println("The boss heal itself by 20%of it current hp and buff its defense massively");
            int healing=Math.toIntExact((long) (hp*0.2));
            updateHp(-healing);
            defence+=50;
            return 0;
        }
        else if(random<=0.6){
            System.out.println("The boss use his standard attack");
            double multiplier=0.85+0.5*Math.random();
            return Math.toIntExact(Math.round(attack*multiplier));
        }
        else if(random<=0.8){
            System.out.println("The boss use multi-hit attack");
            int count=0;
            double multi=Math.random();
            while (multi<=0.8){
                count++;
                multi=Math.random();
            }
            return count*25;
        }
        else if(random<=0.98){
            System.out.println("The boss use his strong attack, this will deal a lot of damage, but cause him to get weaker");
            attack-=50;
            defence-=50;
            if(hp<1000){
                hp=hp/2;
            }
            else{
                hp-=1000;
            }
            return (attack+50)*3;
        }
        else{
            System.out.println("the boss decide to cheat and kill you at the spot,only evasion can help you survive this attack.");
            return 30000;
        }
    }

    @Override
    public void updateMonster() {
        System.out.println("This thing don't have to be upgraded.");
    }
}
