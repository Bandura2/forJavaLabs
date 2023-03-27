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
        Insect MosquitoFirst = new Mosquito("Vasya", 4,true, false, false);
        Insect MosquitoSecond = new Mosquito("Artur", 6, true, true, true);
        Insect HornetFirst = new Hornet("Locky", 2, true, false, true);
        Insect HornetSecond = new Hornet("Herlok", 4, true, true, false);
        Insect ButterflyFirst = new Butterfly("Filuna", 8, true, false, false);
        Insect ButterflySecond = new Butterfly("Dunar", 6, true, false, true);
        Insect MantisFirst= new Mantis("Olena", 8, false, true, false);
        Insect MantisSecond = new Mantis("Zoro", 2, false, true, true);

        InsectManager Manager = new InsectManager();
        Manager.addInsect(MosquitoFirst);
        Manager.addInsect(MosquitoSecond);
        Manager.addInsect(HornetFirst);
        Manager.addInsect(HornetSecond);
        Manager.addInsect(ButterflyFirst);
        Manager.addInsect(ButterflySecond);
        Manager.addInsect(MantisFirst);
        Manager.addInsect(MantisSecond);

        System.out.println();
        Manager.testAbstractMethods();

        System.out.println("Printing all iinsects that are dangereous:");
        for (Insect ins : Manager.findAllDangerous()) {
            System.out.println(ins);
        }
        System.out.println("\nPrinting all iinsects that have more than 4 legs : ");
        for (Insect ins : Manager.findAllWithNumberOfLegsGreaterThan(4)) {
            System.out.println(ins);
        }
    }
}
