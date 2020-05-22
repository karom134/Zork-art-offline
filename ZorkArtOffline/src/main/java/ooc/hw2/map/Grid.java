package ooc.hw2.map;

import ooc.hw2.hostileunit.Enemy;
import ooc.hw2.item.Item;

public class Grid {
    private Integer id;
    private Enemy enemy;
    private Boolean hostility;
    private String terrain;
    private Boolean itemExist;
    private String item;
    public Grid(Integer num){
        id=num;
        hostility=false;
        itemExist=false;
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

    public void addItem(String item){
        this.itemExist=true;
        this.item=item;
    }

    public void removeItem(){
        this.item=null;
        this.itemExist=false;
    }

    public Boolean getItemExist(){
        return itemExist;
    }

    public String getItem(){
        return item;
    }
}
