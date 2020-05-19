package ooc.hw2;

public class Sword {
    private Integer attackDamage;

    public Sword(){
        attackDamage=10;
    }
    public Sword(Integer attackDamage){
        this.attackDamage=attackDamage;
    }
    public Integer getAttackDamage(){
        return attackDamage;
    }
    public void upgrade(){
        attackDamage+=2;
    }
}
