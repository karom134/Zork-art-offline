package ooc.hw2.command;

import ooc.hw2.map.MapBuilder;

public class MapCommand implements Command{
    private MapBuilder mapBuilder;
    public MapCommand(MapBuilder mapBuilder){
        this.mapBuilder=mapBuilder;
    }
    @Override
    public String getDescription() {
        return "Use this command to open the map,This not really help a lot but better than nothing";
    }

    @Override
    public void execute(String word2) {
        mapBuilder.toAsciiArt();
    }
}
