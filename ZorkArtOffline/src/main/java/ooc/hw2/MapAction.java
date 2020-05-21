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

    public void constructAsciiMap(){
        asciimap.put("Plain","@");
        asciimap.put("Forest","#");
        asciimap.put("Mountain","*");
        asciimap.put("Tundra","+");
        asciimap.put("Dessert","%");
    }
}
