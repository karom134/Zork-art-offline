package ooc.hw2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MapAction {
    public File path;
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
    public Map<String,String> asciimap=new HashMap<>();
    public List<Integer> monsterLocation=new ArrayList<>();
    public void constructAsciiMap(){
        asciimap.put("Plain","@");
        asciimap.put("Forest","#");
        asciimap.put("Mountain","*");
        asciimap.put("Tundra","+");
        asciimap.put("Dessert","%");
    }

    public void spawnMonster(Integer number,List<Integer> restriction){

    }
    public Boolean validateMove(Integer finalLocation, Integer location){
        int horizontalBound=location%this.size;
        int verticalBound=location/this.size;
        boolean horizontalBool=true;
        boolean verticalBool=true;
        if(horizontalBound==this.size-1){
            horizontalBool=finalLocation!=location+1
                    && finalLocation!=location-(this.size-1)
                    &&finalLocation!=location+(this.size+1);
        }
        else if(horizontalBound==0){
            horizontalBool=finalLocation!=location-1
                    && finalLocation!=location-(this.size+1)
                    &&finalLocation!=location+(this.size-1);
        }
        if(verticalBound==this.size-1){
            verticalBool=finalLocation!=location+(this.size-1)
                    &&finalLocation!=location+(this.size)
                    &&finalLocation!=location+(this.size+1);
        }
        else if(verticalBound==0){
            verticalBool=finalLocation!=location-(this.size-1)
                    &&finalLocation!=location-(this.size)
                    &&finalLocation!=location-(this.size+1);
        }
        return horizontalBool && verticalBool;
    }
    public Integer randomMove(Integer location){
        Boolean checker=false;
        Integer finalLocation=location;
        while(!checker){
            double randomDirection= Math.random();
            if(randomDirection<=0.125){
                finalLocation=location-(this.size+1);
            }
            else if(randomDirection<=0.25){
                finalLocation=location-(this.size);
            }
            else if(randomDirection<=0.375){
                finalLocation=location-(this.size-1);
            }
            else if(randomDirection<=0.5){
                finalLocation=location-1;
            }
            else if(randomDirection<=0.625){
                finalLocation=location+1;
            }
            else if(randomDirection<=0.75){
                finalLocation=location+(this.size-1);
            }
            else if(randomDirection<=0.875){
                finalLocation=location+(this.size);
            }
            else{
                finalLocation=location+(this.size+1);
            }
            checker=validateMove(finalLocation,location);
        }
        return finalLocation;
    }
}
