package ooc.hw2.map;

import ooc.hw2.hostileunit.BossMonster;
import ooc.hw2.hostileunit.MainBoss;

import java.io.*;
import java.util.*;

public class MapBuilder extends MapAction {

    public MapBuilder(String path){
        this.path=new File(path);
        constructAsciiMap();
    }

    public void constructEmptyMap(){
        map=new Grid[size][size];
        tiles=new ArrayList<>();
        for(int i=0;i<size*size;i++){
            map[i/size][i%size]= new Grid(i);
            tiles.add(i);
        }
    }
    public void getMapData() throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader reader=new BufferedReader(fileReader);
        String line;
        while((line = reader.readLine()) != null) {
            String check = line.split(":")[0];
            String val = line.split(":")[1];
            if (check.equals("Size")) {
                size = Integer.valueOf(val);
            } else if (check.equals("Boss")) {
                String[] vals = val.split(",");
                for (int idx = 0; idx < vals.length; idx++) {
                    bossLocation.add(Integer.valueOf(vals[idx]));
                }
            } else if (check.equals("Final")) {
                finalBoss = Integer.valueOf(val);
            } else if (check.equals("Spawn")) {
                spawn = Integer.valueOf(val);
            } else if (check.equals("forest")) {
                String[] vals = val.split(",");
                for (int idx = 0; idx < vals.length; idx++) {
                    forestTile.add(Integer.valueOf(vals[idx]));
                }
            } else if (check.equals("tundra")) {
                String[] vals = val.split(",");
                for (int idx = 0; idx < vals.length; idx++) {
                    tundraTile.add(Integer.valueOf(vals[idx]));
                }
            } else if (check.equals("dessert")) {
                String[] vals = val.split(",");
                for (int idx = 0; idx < vals.length; idx++) {
                    dessertTile.add(Integer.valueOf(vals[idx]));
                }
            } else if (check.equals("mountain")) {
                String[] vals = val.split(",");
                for (int idx = 0; idx < vals.length; idx++) {
                    mountainTile.add(Integer.valueOf(vals[idx]));
                }
            }
        }
    }
    public void constructFinalMap(){
        try {
            getMapData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        constructEmptyMap();
        for(int i=0;i<size*size;i++){
            if(forestTile.contains(i)){
                map[i/size][i%size].setTerrain("Forest");
            }
            else if(tundraTile.contains(i)){
                map[i/size][i%size].setTerrain("Tundra");
            }
            else if(dessertTile.contains(i)){
                map[i/size][i%size].setTerrain("Dessert");
            }
            else if(mountainTile.contains(i)){
                map[i/size][i%size].setTerrain("Mountain");
            }
            else{
                map[i/size][i%size].setTerrain("Plain");
            }
            if(i==finalBoss){
                map[i/size][i%size].addMonster(new MainBoss());
            }
            if(bossLocation.contains(i)){
                map[i/size][i%size].addMonster(new BossMonster());
            }
        }
        spawnMonster(20);
    }

    public Grid[][] getMap() {
        return map;
    }
    public void toAsciiArt(){
        for(int i=0;i<size;i++){
            String line="";
            for(int j=0;j<size;j++){
                line=line+ asciiMap.get(map[i][j].getTerrain())+" ";
            }
            System.out.println(line);
        }
        System.out.println("@-Plain +-Tundra #-Forest %-Dessert *-Mountain");
    }

    public static void main(String[] args) {
        MapBuilder map=new MapBuilder("../ZorkArtOffline/src/main/resources/SampleMap");
        map.constructFinalMap();
        System.out.println(map.getMonsterLocation().toString());
        Integer test=map.getMonsterLocation().get(0);
        System.out.println(map.getMap()[test/map.getSize()][test%map.getSize()].getHostility());
        System.out.println(map.getMap()[test/map.getSize()][test%map.getSize()].getId());
        map.moveMonster();
        System.out.println(map.getMonsterLocation().toString());
        Integer test2=map.getMonsterLocation().get(0);
        System.out.println(map.getMap()[test/map.getSize()][test%map.getSize()].getHostility());
        System.out.println(map.getMap()[test/map.getSize()][test%map.getSize()].getId());
        System.out.println(map.getMap()[test2/map.getSize()][test2%map.getSize()].getHostility());
        System.out.println(map.getMap()[test2/map.getSize()][test2%map.getSize()].getId());
    }
}
