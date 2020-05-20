package ooc.hw2;

public interface Enemy {
    Integer getHp();
    Integer getAttack();
    Integer getDefence();
    Integer getLocation();
    void updateHp(Integer netDamage);
    Integer getLifeCycle();
    Boolean getBoss();
    void updateMonster();
    void setLocation(Integer size);
}
