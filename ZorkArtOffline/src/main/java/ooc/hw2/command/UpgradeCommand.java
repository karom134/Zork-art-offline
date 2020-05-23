package ooc.hw2.command;

import ooc.hw2.Hero;

public class UpgradeCommand implements Command{
    private Hero hero;
    public UpgradeCommand(Hero hero){
        this.hero=hero;
    }
    @Override
    public String getDescription() {
        return "Use this command to upgrade your hero after level up." +
                "Need status argument (atk,eva,def)";
    }

    @Override
    public void execute(String word2) {
        hero.updateStatPoint(word2);
    }
}
