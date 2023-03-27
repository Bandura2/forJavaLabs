package ua.lviv.iot.algo.part1.lab2;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
public class InsectManager {
    private List<Insect> insects = new LinkedList<>();
    public void addInsect(final Insect insect)
    {
        insects.add(insect);
    }
    public void testAbstractMethods()
    {
        for (Insect objectToTest : insects)
        {
            System.out.println("Now testing insect is : " + objectToTest.getClass().getSimpleName());
            System.out.println(objectToTest);
            System.out.println("Test method canInjectPoison() : ");
            System.out.println(objectToTest.canInjectPoison());
            System.out.println("Test method surviveOverWinter() : ");
            System.out.println(objectToTest.surviveOverWinter());
            System.out.println("Testing end \n");
        }
    }
    public List<Insect> findAllDangerous ()
    {
        return insects.stream()
                .filter((insect -> insect.isDangerous()))
                .collect(Collectors.toList());
    }
    public List<Insect> findAllWithNumberOfLegsGreaterThan(int numberOfLegs)
    {
        return insects.stream()
                .filter((insect) -> insect.getNumberOfLegs() > numberOfLegs)
                .collect(Collectors.toList());
    }
    public static void main(String[] args)
    {
        Insect mosquito1 = new Mosquito("Vasya", 4,true, false, false);
        Insect mosquito2 = new Mosquito("Artur", 6, true, true, true);
        Insect hornet1 = new Hornet("Locky", 2, true, false, true);
        Insect hornet2 = new Hornet("Herlok", 4, true, true, false);
        Insect butterfly1 = new Butterfly("Filuna", 8, true, false, false);
        Insect butterfly2 = new Butterfly("Dunar", 6, true, false, true);
        Insect mantis1 = new Mantis("Olena", 8, false, true, false);
        Insect mantis2 = new Mantis("Zoro", 2, false, true, true);

        InsectManager manager = new InsectManager();
        manager.addInsect(mosquito1);
        manager.addInsect(mosquito2);
        manager.addInsect(hornet1);
        manager.addInsect(hornet2);
        manager.addInsect(butterfly1);
        manager.addInsect(butterfly2);
        manager.addInsect(mantis1);
        manager.addInsect(mantis2);

        System.out.println();
        manager.testAbstractMethods();

        System.out.println("Printing all iinsects that are dangereous:");
        for (Insect ins : manager.findAllDangerous()) {
            System.out.println(ins);
        }
        System.out.println("\nPrinting all iinsects that have more than 4 legs : ");
        for (Insect ins : manager.findAllWithNumberOfLegsGreaterThan(4)) {
            System.out.println(ins);
        }
    }
}
