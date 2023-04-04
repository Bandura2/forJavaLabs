package ua.lviv.iot.algo.part1.lab2;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(of = {"name", "numberOfLegs", "hasWings", "isDangerous", "isSleeping"})

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
}
