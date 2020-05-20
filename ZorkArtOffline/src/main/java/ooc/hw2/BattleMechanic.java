package ooc.hw2;

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
    public void monsterAttack(){
        Integer atk=monster.getAttack();
        Integer damageBlock=Math.toIntExact(Math.round(Math.pow(hero.getDefence(), ((double) 1) / 2) * 2));
        Integer netDamage=Math.toIntExact(Math.round(atk*(1-((double) damageBlock)/100)));
        if(((double) hero.getEvasion())/100<=Math.random()){
            hero.updateHpMp(-netDamage,0);
        }
        else{
            System.out.println("You evade the attack");
        }
    }
    public Boolean battle(){
        Boolean end=false;
        commandWords.addCommand("attack", new AttackCommand(hero,monster,"Use this command to attack your enemy"));
        Set<String> set=new HashSet<>();
        set.add("attack");
        set.add("info");
        set.add("drink");
        set.add("help");
        commandWords.setAvailableCommands(set);
        while(!end){
            String input=parser.getCommand();
            String word1=input.split("/")[0];
            String word2=input.split("/")[1];
            if(commandWords.checkAvailability(word1)){
                commandWords.accessCommand(word1).execute(word2);
            }
            else{
                System.out.println("We don't know that command or that command can't be used right now.");
            }
            monsterAttack();
            hero.updateHpMp(1,1);
            System.out.println("Monster:"+monster.getHp()+" Hero:"
                    +hero.getHp().toString()+"/"+hero.getMaxHp());
            end=isEnd();
        }
        commandWords.resetAvailableCommand();
        if(hero.getHp()<=0){
            System.out.println("You dead");
            return true;
        }
        else{
            System.out.println("You defeat a monster");
            hero.updateExperience(20+monster.getLifeCycle()*2);
            hero.checkWeapons().upgrade();
            return false;
        }
    }
}
