package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MantisTest {
    Insect mantis;
    @BeforeEach
    public void setUp() {
        mantis = new Mantis("Mantis", 8, false, false, false);
    }
    @Test
    public void testMantisToString() {
        String expected = "Insect(name=Mantis, numberOfLegs=8, hasWings=false, isDangerous=false, isSleeping=false)";
        String actual = mantis.toString();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testMantisCanNotInjectPoison() {
        Assertions.assertFalse(mantis.canInjectPoison());
    }
    @Test
    public void testMantisCanNotSurviveOverWinter() {
        Assertions.assertFalse(mantis.surviveOverWinter());
    }

}