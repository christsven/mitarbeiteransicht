package institution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import person.mitarbeiter.BueroArbeiter;
import person.mitarbeiter.Manager;
import person.mitarbeiter.Mitarbeiter;
import person.mitarbeiter.SchichtArbeiter;

import java.util.ArrayList;

class AbteilungTest {

    @Test
    @DisplayName("Test_Gehaltsliste")
    void test_gehaltsliste() {
        //given
        Manager manager = new Manager(5100, "Chef", 60, 1.4);
        SchichtArbeiter schichtArbeiter = new SchichtArbeiter(3100, "Büro",50, 10);
        BueroArbeiter bueroArbeiter = new BueroArbeiter(5200, "Schicht", 50);
        Abteilung sut = new Abteilung("Testabteilung", manager);
        sut.addMitarbeiter(bueroArbeiter);
        sut.addMitarbeiter(schichtArbeiter);

        //when
        String result = sut.getGehalsliste();

        //then
        System.out.println(result);
    }

    @Test
    @DisplayName("Test_Mitarbeiter_gesamt")
    void test_gesamt() {

        //Abteilung
        Manager manager = new Manager(5150,"ManagerName", 200, 1.5);
        Abteilung abteilung = new Abteilung("Abteilungsname", manager);

        ArrayList<Mitarbeiter> mitarbeiterArrayList = new ArrayList<>();

        //mehrere Mitarbeiter
        SchichtArbeiter schichtArbeiter = new SchichtArbeiter(3200, "SchichtName", 50, 10);
        BueroArbeiter bueroArbeiter = new BueroArbeiter(5800, "BueroName", 200);
        abteilung.addMitarbeiter(schichtArbeiter);
        abteilung.addMitarbeiter(bueroArbeiter);

        mitarbeiterArrayList.add(bueroArbeiter);
        mitarbeiterArrayList.add(schichtArbeiter);

        for (Mitarbeiter mitarbeiter: mitarbeiterArrayList) {
            mitarbeiter.einkommen();
        }

        System.out.println(abteilung.getGehalsliste());
    }

}