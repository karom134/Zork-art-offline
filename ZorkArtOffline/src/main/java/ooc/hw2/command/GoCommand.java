package ooc.hw2.command;

import ooc.hw2.Game;
import ooc.hw2.Hero;
import ooc.hw2.map.Grid;

public class GoCommand implements Command{
    private Hero hero;
    private Grid[][] map;

    public GoCommand(Hero hero,Grid[][] map){
        this.hero=hero;
        this.map=map;
    }
    public Boolean validateMove(String word2){
        Boolean vertical = true;
        Boolean horizontal=true;
        if(hero.getLocation().getId()%map.length==0){
            horizontal=!word2.equals("w") && !word2.equals("nw") && !word2.equals("sw");
        }
        else if(hero.getLocation().getId()%map.length==map.length-1){
            horizontal=!word2.equals("e") && !word2.equals("ne") && !word2.equals("se");
        }
        if(hero.getLocation().getId()/map.length==0){
            vertical=!word2.equals("n") && !word2.equals("ne") && !word2.equals("nw");
        }
        else if(hero.getLocation().getId()/map.length==map.length-1){
            vertical=!word2.equals("s") && !word2.equals("se") && !word2.equals("sw");
        }
        return horizontal && vertical;
    }

    @Override
    public String getDescription() {
        return "Use this to move around the map need argument(n,ne,nw,w,e,s,se,sw)";
    }

    @Override
    public void execute(String word2) {
        if(validateMove(word2)){
            if(word2.equals("n")){
                Grid next=map[hero.getLocation().getId()/map.length-1][hero.getLocation().getId()%map.length];
                hero.setLocation(next);
            }
            else if(word2.equals("e")){
                Grid next=map[hero.getLocation().getId()/map.length][hero.getLocation().getId()%map.length+1];
                hero.setLocation(next);
            }
            else if(word2.equals("s")){
                Grid next=map[hero.getLocation().getId()/map.length+1][hero.getLocation().getId()%map.length];
                hero.setLocation(next);
            }
            else if(word2.equals("w")){
                Grid next=map[hero.getLocation().getId()/map.length][hero.getLocation().getId()%map.length-1];
                hero.setLocation(next);
            }
            else if(word2.equals("ne")){
                Grid next=map[hero.getLocation().getId()/map.length-1][hero.getLocation().getId()%map.length+1];
                hero.setLocation(next);
            }
            else if(word2.equals("se")){
                Grid next=map[hero.getLocation().getId()/map.length+1][hero.getLocation().getId()%map.length+1];
                hero.setLocation(next);
            }
            else if(word2.equals("nw")){
                Grid next=map[hero.getLocation().getId()/map.length-1][hero.getLocation().getId()%map.length-1];
                hero.setLocation(next);
            }
            else if(word2.equals("sw")){
                Grid next=map[hero.getLocation().getId()/map.length+1][hero.getLocation().getId()%map.length-1];
                hero.setLocation(next);
            }else{
                System.out.println("Invalid direction input");
            }
        }else{
            System.out.println("Invalid move");
        }
    }
}
