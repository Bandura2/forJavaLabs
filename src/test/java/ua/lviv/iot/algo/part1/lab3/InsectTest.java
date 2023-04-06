package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InsectTest {
    Insect mantisTester;
    @BeforeEach
    public void setUp() {
        mantisTester = new Mantis("Mantis", 6, false, false, true);
    }
    @Test
    public void testInsectIsNotPoisonous() {
        Assertions.assertFalse(mantisTester.isPoisonous());
    }
    @Test
    public void testInsectCanHibernate() {
        mantisTester.hibernate();
        Assertions.assertTrue(mantisTester.isSleeping());
    }
    @Test
    public void testInsectIsWakeUp() {
        mantisTester.wakeUp();
        Assertions.assertFalse(mantisTester.isSleeping());
    }
    @Test
    public void testInsectCanNotInjectPoison() {
        Assertions.assertFalse(mantisTester.canInjectPoison());
    }
    @Test
    public void testInsectCanSurviveOverWinter() {
        Assertions.assertTrue(mantisTester.surviveOverWinter());
    }
    @Test
    public void testInsectToString() {
            String expected = "Insect(name=Mantis, numberOfLegs=6, hasWings=false, isDangerous=false, isSleeping=true)";
            String actual = mantisTester.toString();
            Assertions.assertEquals(expected, actual);
        }
    }

