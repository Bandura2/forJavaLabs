package ua.lviv.iot.algo.part1.lab3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Insect {

    private String name;
    private int numberOfLegs;
    private boolean hasWings = false;
    private boolean isDangerous = false;
    private boolean isSleeping = false;

    public boolean isPoisonous() {
        return isDangerous;
    }

    public void hibernate() {
        isSleeping = true;
    }

    public void wakeUp() {
        isSleeping = false;
    }

    public abstract boolean canInjectPoison();

    public abstract boolean surviveOverWinter();

    public String getHeaders() {
        return ",name, numberOfLegs, hasWings, isDangerous, isSleeping";
    }

    public String toCSV() {
        return "," + name + ", " + numberOfLegs + ", "
                + hasWings + ", " + isDangerous + ", " + isSleeping;
    }
}