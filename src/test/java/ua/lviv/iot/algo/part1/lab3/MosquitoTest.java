package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MosquitoTest {
    Insect mosquito;
    @BeforeEach
    public void setUp() {
        mosquito = new Mosquito("Mosquito", 8, true, false, false);
    }
    @Test
    public void testMosquitoToString() {
        String expected = "Insect(name=Mosquito, numberOfLegs=8, hasWings=true, isDangerous=false, isSleeping=false)";
        String actual = mosquito.toString();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testMosquitoCanNotInjectPoison() {
        Assertions.assertFalse(mosquito.canInjectPoison());
    }
    @Test
    public void testMosquitoCanNotSurviveOverWinter() {
        Assertions.assertFalse(mosquito.surviveOverWinter());
    }
}