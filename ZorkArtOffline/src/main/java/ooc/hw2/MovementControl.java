package ooc.hw2;

import com.sun.org.apache.xpath.internal.operations.Bool;

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
    }
    public Integer randomMove(Integer location){
        Boolean checker=true;
        Integer finalLocation;
        while(checker){
            Double randomDirection= Math.random();
            if(randomDirection<=0.125){

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MovementControl movementControl=new MovementControl(new ArrayList<>(),15);
        System.out.println(movementControl);
    }
}
