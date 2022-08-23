package person.mitarbeiter;

public class Fahrer extends SchichtArbeiter {

    private String fuehrerschein;

    public Fahrer(int id, String name, double stundenSatz, int anzahlStunden, String fuehrerschein) {
        super(id, name, stundenSatz, anzahlStunden);
        setFuehrerschein(fuehrerschein);
    }

    public void setFuehrerschein(String fuehrerschein) {
        this.fuehrerschein = fuehrerschein;
    }

    public String getFuehrerschein() {
        return fuehrerschein;
    }
}
