public class Shield {
    private String shieldName;
    private double baseDef;
    private double def;
    private double mp;

    public Shield(String shieldName, double def, double mp) {
        this.shieldName = shieldName;
        this.baseDef = def;
        this.def = this.baseDef;
        this.mp = mp;
    }

    public String getShieldName() {
        return shieldName;
    }

    public double getBaseDef() {
        return baseDef;
    }

    public double getDef() {
        return def;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public double getMP() {
        return mp;
    }
}
