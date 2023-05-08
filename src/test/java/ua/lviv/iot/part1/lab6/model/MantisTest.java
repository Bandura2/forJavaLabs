package ua.lviv.iot.part1.lab6.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MantisTest {
    private Mantis mantis;

    @BeforeEach
    public void setUp() {
        mantis = new Mantis("Mantis", 8, false, false, false);
    }

    @Test
    public void testMantisIsPoisonous() {
        Assertions.assertFalse(mantis.canPoisonous());
    }

    @Test

    public void testMantisCanHibernate() {

        mantis.hibernate();
        System.out.println(mantis.isSleeping());
        Assertions.assertTrue(mantis.isSleeping());
    }

    @Test
    public void testMantisIsWakeUp() {

        mantis.wakeUp();
        Assertions.assertFalse(mantis.isSleeping());
    }

    @Test
    public void testMantisCanNotInjectPoison() {
        Assertions.assertFalse(mantis.canInjectPoison());
    }

    @Test
    public void testMantisCanNotSurviveOverWinter() {
        Assertions.assertFalse(mantis.surviveOverWinter());
    }

    @Test
    public void testGetHeaders() {

        String expected = ",name, numberOfLegs, hasWings, isDangerous, isSleeping";
        Assertions.assertEquals(expected, mantis.getHeaders());
    }

    @Test
    public void testToCVS() {

        String expected = "," + mantis.getName() + ", " + mantis.getNumberOfLegs() + ", " + mantis.isHasWings() + ", " + mantis.isDangerous() + ", " + mantis.isSleeping();
        Assertions.assertEquals(expected, mantis.toCSV());
    }
}
