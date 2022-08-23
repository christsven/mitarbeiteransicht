package person.mitarbeiter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MitarbeiterTest {

    @Test
    public void test_compareTo() {
        //given
        SchichtArbeiter schichtArbeiter1 = new SchichtArbeiter(3000, "Aaa", 10, 10);
        SchichtArbeiter schichtArbeiter2 = new SchichtArbeiter(3001, "aac", 10, 10);
        SchichtArbeiter schichtArbeiter3 = new SchichtArbeiter(3002, "B", 10, 10);
        ArrayList<SchichtArbeiter> list = new ArrayList<SchichtArbeiter>();
        list.add(schichtArbeiter1);
        list.add(schichtArbeiter2);
        list.add(schichtArbeiter3);

        //when
        list.sort(Mitarbeiter::compareTo);

        System.out.println(list);
    }

}