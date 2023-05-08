package ua.lviv.iot.algo.part1.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class InsectManagerTest {
    private InsectManager manager, managerWithDangerousInsects, managerWithoutDangerousInsects;

    @BeforeEach
    public void setUp() {

        manager = new InsectManager();
        managerWithDangerousInsects = new InsectManager();
        managerWithoutDangerousInsects = new InsectManager();

        managerWithDangerousInsects.addInsect(new Hornet("Hornet", 6, true, true, false));
        managerWithDangerousInsects.addInsect(new Mantis("Mantis", 6, false, true, false));
        managerWithoutDangerousInsects.addInsect(new Mosquito("Mosquito", 8, true, false, true));
        managerWithoutDangerousInsects.addInsect(new Butterfly("Butterfly", 8, true, false, true));

        manager.addInsects(managerWithDangerousInsects.getInsects());
        manager.addInsects(managerWithoutDangerousInsects.getInsects());
    }

    @Test
    public void testFindAllDangerousInsects() {

        List<Insect> results = manager.findAll(true);
        Assertions.assertEquals(2, results.size());
        Assertions.assertEquals(managerWithDangerousInsects.getInsects(), results);
    }

    @Test
    public void testFindAllNotDangerous() {

        List<Insect> results = manager.findAll(false);
        Assertions.assertEquals(managerWithoutDangerousInsects.getInsects(), results);
    }

    @Test
    public void testFindAllIsNotDangerousInsectsInEmptyList() {
        Assertions.assertEquals(0, new InsectManager().findAll(false).size());
    }

    @Test
    public void testFindAllInsectsWithNumberOfLegsGreaterThanSix() {

        List<Insect> results = manager.findAllWithNumOfLegsGreaterThan(6);
        Assertions.assertEquals(results.size(), 2);

        for (var insect : results) {
            Assertions.assertTrue(insect.getNumberOfLegs() > 6);
        }
    }

    @Test
    public void testFindAllInsectsByLegsCountReturnsEmptyList() {

        List<Insect> results = manager.findAllWithNumOfLegsGreaterThan(60);
        Assertions.assertEquals(results.size(), 0);

        for (var insect : results) {
            Assertions.assertNull(insect);
        }
    }

    @Test
    public void testFindAllInsectsWithNumberOfLegsGreaterThanSixInEmptyList() {
        Assertions.assertEquals(0, new InsectManager().findAllWithNumOfLegsGreaterThan(6).size());
    }
}
