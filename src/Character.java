public interface Character {
    String getName();
    int getLevel();
    void levelUp();
    double getMaxHP();
    void setMaxHP(double maxHP);
    double getMaxMP();
    void setMaxMP(double maxMP);
    double getCurrentHP();
    void setCurrentHP(double currentHP);
    double getCurrentMP();
    void setCurrentMP(double currentMP);
    double getBaseMaxSpeed();
    double getMaxSpeed();
    void setMaxSpeed(double maxSpeed);
    double getSpeed();
    void setSpeed(double speed);
    void equipAccessory(Accessory accessory);
    Accessory getAccessory();
    boolean isDead();
    void updateStats();
    void attack(Character target);
    double takeDamage(double damage);
    void showCharacterInfo();
}
