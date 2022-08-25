package com.itf201.mitarbeiteransicht.idvalidation;

import com.itf201.mitarbeiteransicht.backend.idvalidation.IDStatus;
import com.itf201.mitarbeiteransicht.backend.idvalidation.IDValidator;
import com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.itf201.mitarbeiteransicht.backend.person.MitarbeiterTyp.SCHICHTARBEITER;

class IDValidatorTest {

    @Test
    void test_validation_for_wrong_id() {
        Assertions.assertEquals(
                IDStatus.INVALID_ID,
                IDValidator.validateID(SCHICHTARBEITER, 5700));
    }

    @Test
    void test_validation_for_short_id() {
        Assertions.assertEquals(
                IDStatus.INVALID_ID,
                IDValidator.validateID(SCHICHTARBEITER, 50));
    }

    @Test
    void test_validation_correct_id() {
        Assertions.assertEquals(
                IDStatus.OK,
                IDValidator.validateID(SCHICHTARBEITER, 3500));
    }

    @Test
    void test_validation_taken_id() {
        //when
        Assertions.assertEquals(
                IDStatus.OK,
                IDValidator.saveID(MitarbeiterTyp.MANAGER, 5000));
        //then
        Assertions.assertEquals(
                IDStatus.ALREADY_TAKEN,
                IDValidator.saveID(MitarbeiterTyp.MANAGER, 5000));
    }

}