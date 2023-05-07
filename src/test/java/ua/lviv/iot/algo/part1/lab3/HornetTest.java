package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HornetTest {
    private Insect hornet;

    @BeforeEach
    public void setUp() {
        hornet = new Hornet("Hornet", 8, true, true, false);
    }

    @Test
    public void testHornetIsPoisonous() {
        Assertions.assertTrue(hornet.isPoisonous());
    }

    @Test
    public void testHornetCanHibernate() {

        hornet.hibernate();
        Assertions.assertTrue(hornet.isSleeping());
    }

    @Test
    public void testHornetIsWakeUp() {

        hornet.wakeUp();
        Assertions.assertFalse(hornet.isSleeping());
    }

    @Test
    public void testHornetCantInjectPoison() {
        Assertions.assertTrue(hornet.canInjectPoison());
    }

    @Test
    public void testHornetCanNotSurviveOverWinter() {
        Assertions.assertFalse(hornet.surviveOverWinter());
    }

    @Test
    public void testGetHeaders() {

        String expected = ",name, numberOfLegs, hasWings, isDangerous, isSleeping";
        Assertions.assertEquals(expected, hornet.getHeaders());
    }

    @Test
    public void testToCVS() {

        String expected = "," + hornet.getName() + ", " + hornet.getNumberOfLegs()
                + ", " + hornet.isHasWings() + ", " + hornet.isDangerous()
                + ", " + hornet.isSleeping();
        Assertions.assertEquals(expected, hornet.toCSV());
    }
}
