package ooc.hw2;

import ooc.hw2.hostileunit.Enemy;

public class Grid {
    private Integer id;
    private Enemy enemy;
    private Boolean hostility;
    private String terrain;
    private double multiplier;

    public Grid(Integer num){
        id=num;
        hostility=false;
    }

    public void addMonster(Enemy enemy) {
        this.enemy = enemy;
        hostility = true;
    }

    public Integer getId() {
        return id;
    }

    public void removeMonster(){
        this.enemy=null;
        hostility=false;
    }

    public void setTerrain(String type){
        this.terrain=type;
    }

    public void setMultiplier(double factor){
        this.multiplier=factor;
    }
}
