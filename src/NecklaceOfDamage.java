public class NecklaceOfDamage implements Accessory {
    private String name;
    private double hpBonus;
    private double mpBonus;
    private double speedBonus;
    private double dmgBonus;
    private double defBonus;

    public NecklaceOfDamage(String name, double hpBonus, double mpBonus, double speedBonus, double dmgBonus, double defBonus) {
        this.name = name;
        this.hpBonus = hpBonus;
        this.mpBonus = mpBonus;
        this.speedBonus = speedBonus;
        this.dmgBonus = dmgBonus;
        this.defBonus = defBonus;
    }

    public String getName() {
        return name;
    }

    public double getHPBonus() {
        return hpBonus;
    }

    public double getMPBonus() {
        return mpBonus;
    }

    public double getSpeedBonus() {
        return speedBonus;
    }

    public double getDmgBonus() {
        return dmgBonus;
    }

    public double getDefBonus() {
        return defBonus;
    }
}
