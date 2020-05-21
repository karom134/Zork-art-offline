package ooc.hw2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private File path;
    private Grid[][] map;
    private List<Integer> tiles;
    public Map(String path){
        this.path=new File(path);
    }

    public void constructEmptyMap(Integer size){
        map=new Grid[size][size];
        tiles=new ArrayList<>();
        for(int i=0;i<size*size;i++){
            map[i/size][i%size]= new Grid(i);
            tiles.add(i);
        }
    }
    public void getMapData() throws FileNotFoundException {
        FileReader fileReader = new FileReader(path);
        BufferedReader reader=new BufferedReader(fileReader);

    }
    public File getPath() {
        return path;
    }

    public Grid[][] getMap() {
        return map;
    }

    public static void main(String[] args) {
        Map map=new Map("..ZorkArtOffline/src/main/resources/SampleMap");
        map.constructEmptyMap(15);
        System.out.println(map.getMap()[0][14].getId());
    }
}
