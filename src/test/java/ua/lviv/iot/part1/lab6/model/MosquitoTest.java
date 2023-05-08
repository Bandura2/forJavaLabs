package ua.lviv.iot.part1.lab6.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MosquitoTest {
    private Insect mosquito;

    @BeforeEach
    public void setUp() {
        mosquito = new Mosquito("Mosquito", 8, true, false, false);
    }

    @Test
    public void testMosquitoIsPoisonous() {
        Assertions.assertFalse(mosquito.canPoisonous());
    }

    @Test
    public void testMosquitoCanHibernate() {

        mosquito.hibernate();
        Assertions.assertTrue(mosquito.isSleeping());
    }

    @Test
    public void testMosquitoIsWakeUp() {

        mosquito.wakeUp();
        Assertions.assertFalse(mosquito.isSleeping());
    }

    @Test
    public void testMosquitoCanNotInjectPoison() {
        Assertions.assertFalse(mosquito.canInjectPoison());
    }

    @Test
    public void testMosquitoCanNotSurviveOverWinter() {
        Assertions.assertFalse(mosquito.surviveOverWinter());
    }

    @Test
    public void testGetHeaders() {

        String expected = ",name, numberOfLegs, hasWings, isDangerous, isSleeping";
        Assertions.assertEquals(expected, mosquito.reurnHeaders());
    }

    @Test
    public void testToCVS() {

        String expected = "," + mosquito.getName() + ", " + mosquito.getNumberOfLegs() + ", " + mosquito.isHasWings() + ", " + mosquito.isDangerous() + ", " + mosquito.isSleeping();
        Assertions.assertEquals(expected, mosquito.toCSV());
    }
}
