public class Staff {
    private String staffName;
    private double baseDmg;
    private double dmg;
    private double mp;


    public Staff(String staffName, double dmg, double mp) {
        this.staffName = staffName;
        this.baseDmg = dmg;
        this.dmg = this.baseDmg;
        this.mp = mp;
    }

    public String getStaffName() {
        return staffName;
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
