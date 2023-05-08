package ua.lviv.iot.part1.lab6.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class Insect {

    private String name;
    private int numberOfLegs;
    private boolean hasWings = false;
    private boolean isDangerous = false;
    private boolean isSleeping = false;

    public boolean canPoisonous() {
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
                + hasWings + ", " + isDangerous + ", "
                + isSleeping;
    }
}
