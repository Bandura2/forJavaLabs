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
        if (!isSleeping) {
        isSleeping = true;
        System.out.println("The insect fell asleep");
        } else {
            System.out.println("The insect is already asleep");
        }
    }
    public void wakeUp()
    {
        if (isDangerous){
        isSleeping = false;
        System.out.println("The insect has woken up");
        } else {
            System.out.println("The insect is awake");
        }
    }
    public static void main (String[] args) {
        int numberOfInsect = 4;
        Insect[] arrayInsects = new Insect[numberOfInsect];
        arrayInsects[0] = new Insect("fly", 6, true, true, false);
        arrayInsects[1] = new Insect();
        arrayInsects[2] = getInstance();
        arrayInsects[3] = getInstance();

        for (int i = 0; i < numberOfInsect; i++)
        {
            System.out.println(arrayInsects[i].toString());
        }
    }
}
