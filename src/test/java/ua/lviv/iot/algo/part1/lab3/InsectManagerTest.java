package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import java.util.List;
class InsectManagerTest {
    InsectManager manager, secondManager;
    List<Insect> expected, results;
    Insect mosquito, hornet, butterfly, mantis;
    @BeforeEach
    public void setUp() {
        mosquito = new Mosquito("Mosquito", 8, true, false, true);
        hornet = new Hornet("Hornet", 6, true, true, false);
        butterfly = new Butterfly("Butterfly", 8, true, false, true);
        mantis = new Mantis("Mantis", 6, false, true, false);

        manager = new InsectManager();
        manager.addInsect(mosquito);
        manager.addInsect(hornet);
        manager.addInsect(butterfly);
        manager.addInsect(mantis);

        secondManager = new InsectManager();
        expected = new LinkedList<>();
    }
    @Test
    public void testFindAllDangerousInsects() {
        expected.add(hornet);
        expected.add(mantis);

        results = manager.findAllDangerous();
        Assertions.assertEquals(results, expected);
    }
    @Test
    public void testFindAllIsNotDangerousInsects() {
        mosquito.setDangerous(false);
        hornet.setDangerous(false);
        butterfly.setDangerous(false);
        mantis.setDangerous(false);

        secondManager.addInsect(mosquito);
        secondManager.addInsect(hornet);
        secondManager.addInsect(butterfly);
        secondManager.addInsect(mantis);

        results = secondManager.findAllDangerous();
        Assertions.assertEquals(results, expected);
    }
    @Test
    public void testFindAllIsNotDangerousInsectsInEmptyList() {
        results = secondManager.findAllDangerous();
        Assertions.assertEquals(results, expected);
    }
    @Test
    public void testFindAllInsectsWithNumberOfLegsGreaterThanSix() {
        expected.add(mosquito);
        expected.add(butterfly);

        results = manager.findAllWithNumOfLegsGreaterThan(6);
        Assertions.assertEquals(results, expected);
    }
    @Test
    public void testFindAllInsectsWithNumberOfLegsGreaterThanSixty() {
        secondManager.addInsect(mosquito);
        secondManager.addInsect(hornet);
        secondManager.addInsect(butterfly);
        secondManager.addInsect(mantis);

        results = manager.findAllWithNumOfLegsGreaterThan(60);
        Assertions.assertEquals(results, expected);
    }
    @Test
    public void testFindAllInsectsWithNumberOfLegsGreaterThanSixInEmptyList() {
        results = secondManager.findAllWithNumOfLegsGreaterThan(6);
        Assertions.assertEquals(results, expected);
    }
}