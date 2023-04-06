package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HornetTest {
    Insect hornet;
    @BeforeEach
    public void setUp() {
        hornet = new Hornet("Hornet", 8, true, true, false);
    }
    @Test
    public void testHornetToString() {
        String expected = "Insect(name=Hornet, numberOfLegs=8, hasWings=true, isDangerous=true, isSleeping=false)";
        String actual = hornet.toString();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testHornetCantInjectPoison() {
        Assertions.assertTrue(hornet.canInjectPoison());
    }
    @Test
    public void testHornetCanNotSurviveOverWinter() {
        Assertions.assertFalse(hornet.surviveOverWinter());
    }
}