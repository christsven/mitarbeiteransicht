package backend.fahrzeuge;


import backend.person.mitarbeiter.Fahrer;

public abstract class KraftFahrZeug implements Comparable<KraftFahrZeug>{

    private Fahrer fahrer;
    private double tankInhalt;
    private double tankGroesse;
    private GPS position;
    private boolean motorAn;

    public KraftFahrZeug(Fahrer fahrer, GPS position, double tankgroesse, double tankinhalt) {
        setFahrer(fahrer);
        setMotorZustand(false);
        setPosition(position);
        setTankGroesse(tankgroesse);
        setTankInhalt(tankinhalt);
    }

    public double tanken(double zufuhr) {
        if((tankInhalt + zufuhr) > tankGroesse) {
            double ueberlauf = tankInhalt - tankGroesse;
            setTankInhalt(tankGroesse);
            return ueberlauf;
        } else {
            setTankInhalt(tankInhalt + zufuhr);
            return 0.0;
        }
    }

    public GPS fahreZu(GPS neuePos) {
        if (isMotorAn() && getTankInhalt() > 0 && getFahrer() != null) {
            setPosition(neuePos);
        }
        return getPosition();
    }

    public boolean einsteigen(Fahrer neuerFahrer) {
        if(neuerFahrer.getFuehrerschein() != null) {
            setFahrer(neuerFahrer);
        }
        return getFahrer() == neuerFahrer;
    }

    public void motorAusschalten() {
        setMotorZustand(false);
    }

    public void parken() {
        motorAusschalten();
        setFahrer(null);
    }

    public abstract double auslastung();

    //Getter und Setter
    public boolean isMotorAn() {
        return motorAn;
    }

    public double getTankGroesse() {
        return tankGroesse;
    }

    public double getTankInhalt() {
        return tankInhalt;
    }

    public Fahrer getFahrer() {
        return fahrer;
    }

    public GPS getPosition() {
        return position;
    }

    public void setFahrer(Fahrer fahrer) {
        this.fahrer = fahrer;
    }

    public void setMotorZustand(boolean motorZustand) {
        this.motorAn = motorZustand;
    }

    public void setPosition(GPS position) {
        this.position = position;
    }

    public void setTankGroesse(double tankGroesse) {
        this.tankGroesse = tankGroesse;
    }

    public void setTankInhalt(double tankInhalt) {
        this.tankInhalt = tankInhalt;
    }

}
