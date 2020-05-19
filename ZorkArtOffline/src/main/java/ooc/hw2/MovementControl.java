package ooc.hw2;

import java.util.*;

public class MovementControl {
    private List<Integer> terrain;
    private Integer size;
    public MovementControl(List<Integer> terrain, Integer boardSize) {
        this.terrain=terrain;
        this.size=boardSize;
    }
    public Boolean validateMove(Integer finalLocation,Integer location){
        Integer horizontalBound=location%this.size;
        Integer verticalBound=location/this.size;
        Boolean horizontalBool=true;
        Boolean verticalBool=true;
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
            Double randomDirection= Math.random();
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

    public static void main(String[] args) {
        MovementControl movementControl=new MovementControl(new ArrayList<>(),15);
        System.out.println(movementControl.randomMove(14));
    }
}