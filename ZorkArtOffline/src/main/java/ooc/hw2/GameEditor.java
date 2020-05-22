package ooc.hw2;

import ooc.hw2.command.CommandFactory;
import ooc.hw2.map.Grid;
import ooc.hw2.map.MapBuilder;

public abstract class GameEditor {
    public Hero hero;
    public MapBuilder mapBuilder;
    public CommandFactory commandFactory;
    public Boolean mapExist;
    public Boolean gameClear;
    public Boolean quit;
    public Grid[][] map;
    public Parser parser;

    public void createMap(String path){
        String defaultPath="../ZorkArtOffline/src/main/resources/";
        String combinedPath=defaultPath+path;
        mapBuilder=new MapBuilder(combinedPath);
        mapBuilder.constructFinalMap();
        mapExist=true;
        map=mapBuilder.getMap();
        System.out.println("Map construction complete");
    }

    public Boolean getMapExist() {
        return mapExist;
    }

    public void exitGame(){
        mapExist=false;
    }

    public void quitGame(){
        quit=true;
    }
}
