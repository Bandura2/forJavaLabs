package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ButterflyTest {
    Insect butterfly;
    @BeforeEach
    public void setUp() {
        butterfly = new Butterfly("Butterfly", 6, true, false, true);
    }
    @Test
    public void testButterflyToString() {
        String expected = "Insect(name=Butterfly, numberOfLegs=6, hasWings=true, isDangerous=false, isSleeping=true)";
        String actual = butterfly.toString();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testButterflyCanNotInjectPoison() {
        Assertions.assertFalse(butterfly.canInjectPoison());
    }
    @Test
    public void testButterflyCanSurviveOverWinter() {
        Assertions.assertTrue(butterfly.surviveOverWinter());
    }
}