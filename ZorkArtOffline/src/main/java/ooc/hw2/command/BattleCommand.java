package ooc.hw2.command;

import ooc.hw2.BattleMechanic;
import ooc.hw2.Hero;
import ooc.hw2.hostileunit.Enemy;

public class BattleCommand implements Command{
    private Hero hero;
    private CommandFactory commandFactory;
    public BattleCommand(Hero hero,CommandFactory commandFactory){
        this.hero=hero;
        this.commandFactory=commandFactory;
    }


    @Override
    public String getDescription() {
        return "Use this command to initiate battle with enemy";
    }

    @Override
    public void execute(String word2) {
        if(hero.getLocation().getHostility()){
            Enemy enemy=hero.getLocation().getEnemy();
            BattleMechanic battleMechanic=new BattleMechanic(hero,enemy,commandFactory);
            battleMechanic.battle();
        } else{
            System.out.println("There is no enemy in this room and you can't battle with yourself.");
        }

    }
}
