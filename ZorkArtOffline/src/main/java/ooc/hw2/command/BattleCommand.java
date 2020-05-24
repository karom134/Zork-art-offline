package ooc.hw2.command;

import ooc.hw2.game.BattleMechanic;
import ooc.hw2.game.Hero;
import ooc.hw2.hostileunit.Enemy;

import java.io.IOException;

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
    public void execute(String word2) throws IOException {
        if(hero.getLocation().getHostility()){
            System.out.println("You enter the battle with monster some command will be disable.");
            Enemy enemy=hero.getLocation().getEnemy();
            BattleMechanic battleMechanic=new BattleMechanic(hero,enemy,commandFactory);
            battleMechanic.battle();
        } else{
            System.out.println("There is no enemy in this room and you can't battle with yourself.");
        }

    }
}
