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
        Insect mosquitoFirst = new Mosquito("Vasya", 4,true, false, false);
        Insect mosquitoSecond = new Mosquito("Artur", 6, true, true, true);
        Insect hornetFirst = new Hornet("Locky", 2, true, false, true);
        Insect hornetSecond = new Hornet("Herlok", 4, true, true, false);
        Insect butterflyFirst = new Butterfly("Filename", 8, true, false, false);
        Insect butterflySecond = new Butterfly("Dinar", 6, true, false, true);
        Insect mantisFirst= new Mantis("Olena", 8, false, true, false);
        Insect mantisSecond = new Mantis("Zoro", 2, false, true, true);

        InsectManager manager = new InsectManager();
        manager.addInsect(mosquitoFirst);
        manager.addInsect(mosquitoSecond);
        manager.addInsect(hornetFirst);
        manager.addInsect(hornetSecond);
        manager.addInsect(butterflyFirst);
        manager.addInsect(butterflySecond);
        manager.addInsect(mantisFirst);
        manager.addInsect(mantisSecond);

        System.out.println();
        manager.testAbstractMethods();

        System.out.println("Printing all insects that are dangerous:");
        for (Insect ins : manager.findAllDangerous()) {
            System.out.println(ins);
        }
        System.out.println("\nPrinting all insects that have more than 4 legs : ");
        for (Insect ins : manager.findAllWithNumberOfLegsGreaterThan(4)) {
            System.out.println(ins);
        }
    }
}
