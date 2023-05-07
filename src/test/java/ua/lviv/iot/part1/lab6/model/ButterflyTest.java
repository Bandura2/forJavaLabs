package ua.lviv.iot.part1.lab6.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ButterflyTest {
    private Insect butterfly;

    @BeforeEach
    public void setUp() {
        butterfly = new Butterfly("Butterfly", 6, true, false, true);
    }

    @Test
    public void testButterflyIsPoisonous() {
        Assertions.assertFalse(butterfly.canPoisonous());
    }

    @Test
    public void testButterflyCanHibernate() {

        butterfly.hibernate();
        Assertions.assertTrue(butterfly.isSleeping());
    }

    @Test
    public void testButterflyIsWakeUp() {

        butterfly.wakeUp();
        Assertions.assertFalse(butterfly.isSleeping());
    }

    @Test
    public void testButterflyCanNotInjectPoison() {
        Assertions.assertFalse(butterfly.canInjectPoison());
    }

    @Test
    public void testButterflyCanSurviveOverWinter() {
        Assertions.assertTrue(butterfly.surviveOverWinter());
    }

    @Test
    public void testGetHeaders() {

        String expected = ",name, numberOfLegs, hasWings, isDangerous, isSleeping";
        Assertions.assertEquals(expected, butterfly.getHeaders());
    }

    @Test
    public void testToCVS() {

        String expected = "," + butterfly.getName() + ", " +
                butterfly.getNumberOfLegs() + ", " + butterfly.isHasWings() +
                ", " + butterfly.isDangerous() + ", " + butterfly.isSleeping();
        Assertions.assertEquals(expected, butterfly.toCSV());
    }
}
