package ooc.hw2.command;

import ooc.hw2.game.BattleMechanic;

import java.io.IOException;

public class RunCommand implements Command {
    private BattleMechanic battleMechanic;

    public RunCommand(BattleMechanic battleMechanic){
        this.battleMechanic=battleMechanic;
    }


    @Override
    public String getDescription() {
        return "Use this command to flee from monster if you know it is impossible to fight them";
    }

    @Override
    public void execute(String word2) throws IOException {
        battleMechanic.setRun();
    }
}
