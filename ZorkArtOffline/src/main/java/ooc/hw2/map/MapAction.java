package ooc.hw2.map;

import ooc.hw2.hostileunit.Enemy;
import ooc.hw2.hostileunit.Monster;
import ooc.hw2.map.Grid;

import java.io.File;
import java.util.*;

public abstract class MapAction {
    public Grid[][] map;
    public List<Integer> tiles;
    public List<Integer> forestTile=new ArrayList<>();
    public List<Integer> tundraTile=new ArrayList<>();
    public List<Integer> dessertTile=new ArrayList<>();
    public List<Integer> mountainTile=new ArrayList<>();
    public Integer size;
    public List<Integer> bossLocation=new ArrayList<>();
    public Integer finalBoss;
    public Integer spawn;
    public Map<String,String> asciiMap =new HashMap<>();
    public List<Integer> monsterLocation=new ArrayList<>();
    public Random random=new Random();
    public List<Integer> itemLoc=new ArrayList<>();

    public void constructAsciiMap(){
        asciiMap.put("Plain","@");
        asciiMap.put("Forest","#");
        asciiMap.put("Mountain","*");
        asciiMap.put("Tundra","+");
        asciiMap.put("Dessert","%");
    }

    public Integer getSize() {
        return size;
    }

    public void spawnMonster(Integer number){
        Integer count=0;
        while(count<number){
            Integer loc=random.nextInt(size*size);
            if(!monsterLocation.contains(loc) && !loc.equals(finalBoss) && !bossLocation.contains(loc)){
                map[loc/size][loc%size].addMonster(new Monster());
                monsterLocation.add(loc);
                count++;
            }
        }
    }
    public String randomItem(){
        double tmp=Math.random();
        if(tmp<=0.25){
            return "potion";
        }
        else if(tmp<=0.50){
            return "Spotion";
        }
        else if(tmp<=0.75){
            return "Hpotion";
        }
        else{
            return "Mpotion";
        }
    }

    public void spawnItem(Integer num){
        for(int i=0;i<num;i++){
            Integer loc=random.nextInt(size*size);
            if(!itemLoc.contains(loc)){
                map[loc/size][loc%size].addItem(randomItem());
            }
        }
    }

    public void moveMonster(){
        for(int i=0;i<monsterLocation.size();i++){
            Integer loc=monsterLocation.get(i);
            List<Integer> validMove=validateMove(loc);
            validMove.remove(finalBoss);
            validMove.removeAll(monsterLocation);
            validMove.removeAll(bossLocation);
            if(validMove.isEmpty()){
                continue;
            }
            else{
                Integer index=random.nextInt(validMove.size());
                Integer newLoc=validMove.get(index);
                Enemy enemy=map[loc/size][loc%size].getEnemy();
                map[newLoc/size][newLoc%size].addMonster(enemy);
                map[loc/size][loc%size].removeMonster();
                monsterLocation.set(i,newLoc);
            }
        }
    }
    public void upgradeAllMonster(){
        for(int idx=0;idx<monsterLocation.size();idx++){
            Integer loc=monsterLocation.get(idx);
            Enemy enemy=map[loc/size][loc%size].getEnemy();
            enemy.updateMonster();
        }
    }
    public List<Integer> getMonsterLocation() {
        return monsterLocation;
    }
    public List<Integer> validateMove(Integer location){
        List<Integer> allMove=new ArrayList<>();
        allMove.add(location+1);
        allMove.add(location-(this.size-1));
        allMove.add(location+(this.size+1));
        allMove.add(location-1);
        allMove.add(location-(this.size+1));
        allMove.add(location+(this.size-1));
        allMove.add(location-(this.size));
        allMove.add(location+(this.size));
        int horizontalBound=location%this.size;
        int verticalBound=location/this.size;
        if(horizontalBound==this.size-1){
            allMove.remove(Integer.valueOf(location+1));
            allMove.remove(Integer.valueOf(location-(this.size-1)));
            allMove.remove(Integer.valueOf(location+(this.size+1)));
        }
        else if(horizontalBound==0){
            allMove.remove(Integer.valueOf(location-1));
            allMove.remove(Integer.valueOf(location-(this.size+1)));
            allMove.remove(Integer.valueOf(location+(this.size-1)));
        }
        if(verticalBound==this.size-1){
            allMove.remove(Integer.valueOf(location+(this.size-1)));
            allMove.remove(Integer.valueOf(location+(this.size)));
            allMove.remove(Integer.valueOf(location+(this.size+1)));
        }
        else if(verticalBound==0){
            allMove.remove(Integer.valueOf(location-(this.size-1)));
            allMove.remove(Integer.valueOf(location-(this.size)));
            allMove.remove(Integer.valueOf(location-(this.size+1)));
        }
        return allMove;
    }

    public Integer getSpawn() {
        return spawn;
    }
}
