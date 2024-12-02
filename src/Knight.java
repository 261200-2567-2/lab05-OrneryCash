import java.util.Random;

public class Knight implements Character {
    private String name;

    private int level;
    private double maxHP;
    private double maxMP;
    private double currentHP;
    private double currentMP;
    private double baseMaxSpeed;
    private double maxSpeed;
    private double speed;
    private Accessory accessory;

    private Sword sword;
    private Shield shield;

    public Knight(String name) {
        Random rand  = new Random();
        this.name = name;
        this.level = 1;
        this.maxHP = 100 + (10 * level);
        this.maxMP = 50 + (2 * level);
        this.currentHP = this.maxHP;
        this.currentMP = this.maxMP;
        this.baseMaxSpeed = rand.nextInt(50) + 1;
        this.maxSpeed = this.baseMaxSpeed * (0.1 + 0.03 * level);
        this.speed = this.maxSpeed;

        this.sword = null;
        this.shield = null;

        this.accessory = null;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
        updateStats();
        setCurrentHP(getMaxHP());
        setCurrentMP(getMaxMP());
        System.out.println(getName() + " has leveled up!!!");
    }

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public double getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(double maxMP) {
        this.maxMP = maxMP;
    }

    public double getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(double currentHP) {
        this.currentHP = currentHP;
    }

    public double getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(double currentMP) {
        this.currentMP = currentMP;
    }

    public double getBaseMaxSpeed() {
        return baseMaxSpeed;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void equipSword(Sword sword) {
        if (isDead()) {
            System.out.println(getName() + " is dead!");
            return;
        }
        if (getSword() != null) {
            this.sword = null;
            System.out.println("Unequipped sword");
        } else {
            this.sword = sword;
            System.out.println("Equipped sword: " + sword.getSwordName());
        }
        updateStats();
    }

    private Sword getSword() {
        return sword;
    }

    public void equipShield(Shield shield) {
        if (isDead()) {
            System.out.println(getName() + " is dead!");
            return;
        }
        if (getShield() != null) {
            this.shield = null;
            System.out.println("Unequipped shield");
        } else {
            this.shield = shield;
            System.out.println("Equipped shield: " + shield.getShieldName());
        }
        updateStats();
    }

    private Shield getShield() {
        return shield;
    }

    public void equipAccessory(Accessory accessory) {
        if (isDead()) {
            System.out.println(getName() + " is dead!");
            return;
        }
        if (getAccessory() != null) {
            this.accessory = null;
            System.out.println("Unequipped accessory");
        } else {
            this.accessory = accessory;
            System.out.println("Equipped accessory: " + accessory.getName());
        }
        updateStats();
    }

    public Accessory getAccessory() {
        return accessory;
    }

    public boolean isDead() {
        return currentHP <= 0;
    }

    public void updateStats() {
        setMaxHP(100 + (10 * getLevel()));
        setMaxMP(50 + (2 * getLevel()));
        setMaxSpeed(getBaseMaxSpeed() * (0.1 + 0.03 * getLevel()));
        setSpeed(getMaxSpeed());

        Sword sword = getSword();

        if (sword != null) {
            sword.setDmg(sword.getBaseDmg() * (1 + 0.1 * getLevel()));
            setSpeed(getSpeed() - (getSpeed() * (0.1 + 0.04 * getLevel())));
        }

        Shield shield = getShield();
        if (shield != null) {
            shield.setDef(shield.getBaseDef() * (1 + 0.05 * getLevel()));
            setSpeed(getSpeed() - (getSpeed() * (0.1 + 0.08 * getLevel())));
        }

        Accessory accessory = getAccessory();
        if (accessory != null) {
            maxHP += accessory.getHPBonus();
            maxMP += accessory.getMPBonus();
            maxSpeed += accessory.getSpeedBonus();
            if (sword != null) {
                sword.setDmg(sword.getDmg() + accessory.getDmgBonus());
            }

            if (shield != null) {
                shield.setDef(shield.getDef() + accessory.getDefBonus());
            }
        }
    }

    public void attack(Character target) {
        if (isDead()) {
            System.out.println(getName() + " is dead!");
            return;
        }
        if (this == target) {
            System.out.println("You cannot attack yourself");
            return;
        }

        if (target.isDead()) {
            System.out.println(target.getName() + " is already dead");
            return;
        }

        Sword sword = getSword();
        if (sword == null) {
            System.out.println(getName() + " cannot fight with your bare hand");
            return;
        }

        if (getCurrentMP() - sword.getMP() <= 0) {
            System.out.println(getName() + " doesn't have enough mana to attack");
            return;
        }

        double trueDmg = target.takeDamage(sword.getDmg());
        System.out.printf("%s attacked %s for %.2f damage\n", getName(), target.getName(), trueDmg );
        setCurrentMP(getCurrentMP() - sword.getMP());

        if (target.getCurrentHP() <= 0) {
            levelUp();
            System.out.println(getName() + " killed " + target.getName());
        }
    }

    public double takeDamage(double damage) {
        Shield shield = getShield();
        if (shield != null) {
            if (getCurrentMP() - shield.getMP() <= 0) {
                System.out.println(getName() + " doesn't have enough mana to block");
            } else {
                damage -= shield.getDef();
                setCurrentMP(getCurrentMP() - shield.getMP());
            }
        }
        setCurrentHP(getCurrentHP() - damage);
        return damage;
    }

    public void showCharacterInfo() {
        System.out.println("--------------------");
        System.out.println("Name: " + getName());
        System.out.println("Level: " + getLevel());
        System.out.printf("HP: %.2f / %.2f\n", getCurrentHP(), getMaxHP());
        System.out.printf("MP: %.2f / %.2f\n", getCurrentMP(), getMaxMP());
        System.out.printf("Speed: %.2f / %.2f\n", getSpeed(), getMaxSpeed());

        if (getSword() != null) {
            System.out.println("Sword: " + getSword().getSwordName());
        } else {
            System.out.println(getName() + " doesn't equip a sword");
        }

        if (getShield() != null) {
            System.out.println("Shield: " + getShield().getShieldName());
        } else {
            System.out.println(getName() + " doesn't equip a shield");
        }

        if (getAccessory() != null) {
            System.out.println("Accessory: " + getAccessory().getName());
        } else {
            System.out.println(getName() + " doesn't equip a accessory");
        }

        if (isDead()) {
            System.out.println(getName() + " is dead!");
        }
        System.out.println("--------------------");
    }
}
