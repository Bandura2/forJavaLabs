package ua.lviv.iot.algo.part1.lab1.isect;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(of = {"name", "numberOfLegs", "hasWings", "isDangerous", "isSleeping"})

public class Insect {
    private String name;
    private int numberOfLegs;
    private boolean hasWings = false;
    private boolean isDangerous = false;
    private boolean isSleeping = false;
    private static Insect instance = new Insect();
    private static Insect getInstance()
    {
        return instance;
    }
    public boolean isPoisonous()
    {
        return isDangerous;
    }
    public void hibernate()
    {
        isSleeping = true;
    }
    public void wakeUp()
    {
        isSleeping = false;
    }
    public static void main (String[] args) {
        int numberOfInsect = 4;
        Insect[] arrayInsects = new Insect[numberOfInsect];
        arrayInsects[0] = new Insect("fly", 6, true, true, false);
        arrayInsects[1] = new Insect();
        arrayInsects[2] = getInstance();
        arrayInsects[3] = getInstance();

        for (Insect objectToPrint : arrayInsects)
        {
            System.out.println(objectToPrint);
        }
    }
}
