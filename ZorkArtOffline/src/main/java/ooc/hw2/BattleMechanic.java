package ooc.hw2;

import ooc.hw2.command.AttackCommand;
import ooc.hw2.command.CommandWords;
import ooc.hw2.hostileunit.Enemy;

import java.util.HashSet;
import java.util.Set;

public class BattleMechanic {
    private Hero hero;
    private Enemy monster;
    private CommandWords commandWords;
    private Parser parser;
    public BattleMechanic(Hero hero,Enemy monster,CommandWords commandWords){
        this.hero=hero;
        this.monster=monster;
        this.commandWords=commandWords;
        parser=new Parser();
    }

    public Boolean isEnd(){
        return hero.getHp()<=0 || monster.getHp()<=0;
    }
    public void retaliate(){
        Integer rawDamage=monster.attack();
        int damageReduction= Math.toIntExact(Math.round(Math.pow(monster.getDefence(), ((double) 1) / 2) * 2));
        int netDamage=Math.toIntExact(Math.round(rawDamage*(1-((double) damageReduction)/100)));
        if(Math.random()<((double)hero.getEvasion())/100){
            System.out.println("You evade the attack");
        }
        else{
            hero.updateHpMp(-netDamage,0);
        }
    }
    public void battle() {
        Boolean end = false;
        commandWords.addCommand("attack", new AttackCommand(hero, monster, "Use this command to attack your enemy"));
        Set<String> set = new HashSet<>();
        set.add("attack");
        set.add("info");
        set.add("drink");
        set.add("help");
        commandWords.setAvailableCommands(set);
        while (!end) {
            String input = parser.getCommand();
            String word1 = input.split("/")[0];
            String word2 = input.split("/")[1];
            if (commandWords.checkAvailability(word1)) {
                commandWords.accessCommand(word1).execute(word2);
            } else {
                System.out.println("We don't know that command or that command can't be used right now.");
            }
            retaliate();
            hero.updateHpMp(1, 1);
            System.out.println("Monster:" + monster.getHp() + " Hero:"
                    + hero.getHp().toString() + "/" + hero.getMaxHp());
            end = isEnd();
        }
        commandWords.resetAvailableCommand();
    }
}
