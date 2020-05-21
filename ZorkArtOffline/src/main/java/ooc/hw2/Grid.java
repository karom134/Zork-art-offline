package ooc.hw2;

import ooc.hw2.hostileunit.Enemy;

public class Grid {
    private Integer id;
    private Enemy enemy;
    private Boolean hostility;
    private String terrain;

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

    public String getTerrain() {
        return terrain;
    }

    public void removeMonster(){
        this.enemy=null;
        hostility=false;
    }

    public Boolean getHostility() {
        return hostility;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setTerrain(String type){
        this.terrain=type;
    }

}
