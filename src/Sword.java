public class Sword {
    private String swordName;
    private double baseDmg;
    private double dmg;
    private double mp;


    public Sword(String swordName, double dmg, double mp) {
        this.swordName = swordName;
        this.baseDmg = dmg;
        this.dmg = this.baseDmg;
        this.mp = mp;
    }

    public String getSwordName() {
        return swordName;
    }

    public double getBaseDmg() {
        return baseDmg;
    }

    public double getDmg() {
        return dmg;
    }

    public void setDmg(double dmg) {
        this.dmg = dmg;
    }

    public double getMP() {
        return mp;
    }

}
