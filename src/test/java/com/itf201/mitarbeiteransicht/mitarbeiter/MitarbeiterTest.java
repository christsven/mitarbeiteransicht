package com.itf201.mitarbeiteransicht.mitarbeiter;

import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.Mitarbeiter;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.SchichtArbeiter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class MitarbeiterTest {

    @Test
    public void test_compareTo() {
        //given
        SchichtArbeiter schichtArbeiter1 = new SchichtArbeiter(3000, "Aaa", 10, 10);
        SchichtArbeiter schichtArbeiter2 = new SchichtArbeiter(3001, "aac", 10, 10);
        SchichtArbeiter schichtArbeiter3 = new SchichtArbeiter(3002, "B", 10, 10);
        ArrayList<SchichtArbeiter> list = new ArrayList<>();
        list.add(schichtArbeiter1);
        list.add(schichtArbeiter2);
        list.add(schichtArbeiter3);

        //when
        list.sort(Mitarbeiter::compareTo);

        System.out.println(list);
    }

}