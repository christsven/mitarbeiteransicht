package com.itf201.mitarbeiteransicht.mitarbeiter;

import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.Mitarbeiter;
import com.itf201.mitarbeiteransicht.backend.person.mitarbeiter.SchichtArbeiter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MitarbeiterTest {

    @Test
    public void test_compareTo() {
        // Show how comparison works as console log
        final SchichtArbeiter arbeiter1 = new SchichtArbeiter(
                3000,
                "Aaa",
                10,
                10);
        final SchichtArbeiter arbeiter2 = new SchichtArbeiter(
                3001,
                "aac",
                10,
                10);
        final SchichtArbeiter arbeiter3 = new SchichtArbeiter(
                3002,
                "B",
                10,
                10);
        ArrayList<SchichtArbeiter> list = new ArrayList<>(List.of(arbeiter1, arbeiter2, arbeiter3));
        list.sort(Mitarbeiter::compareTo);
        System.out.println(list);
    }

    @Test
    public void test_nameIsNotBlank() {
        // Given
        final String invalidName = "";
        final String validName = "Test";

        // Assertions
        assertThrows(
                IllegalArgumentException.class,
                () -> new SchichtArbeiter(3001, invalidName, 1L, 1));
        assertThrows(
                NullPointerException.class,
                () -> new SchichtArbeiter(3001, null, 1L, 1));
        assertDoesNotThrow(() -> new SchichtArbeiter(3001, validName, 1L, 1));
    }

    @Test
    public void test_idHasToBeValid() {
        // Given
        final int invalidId = 100;
        final int validId = 3001;

        // Assertions
        assertThrows(
                IllegalArgumentException.class,
                () -> new SchichtArbeiter(invalidId, "Test", 1L, 1));
        assertDoesNotThrow(() -> new SchichtArbeiter(validId, "Test", 1L, 1));
    }
}