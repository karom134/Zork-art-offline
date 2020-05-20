package ooc.hw2;

public class BattleMechanic {
    private Hero hero;
    private Enemy monster;
    public BattleMechanic(Hero hero,Enemy monster){
        this.hero=hero;
        this.monster=monster;
    }

    public Boolean isEnd(){
        return hero.getHp()<=0 || monster.getHp()<=0;
    }

    public void battle(){
        Boolean end=false;
        while(!end){

        }
    }

}
