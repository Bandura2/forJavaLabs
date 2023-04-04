package ua.lviv.iot.algo.part1.lab2;
public class Butterfly extends Insect {
    public Butterfly(String name, int numberOfLegs, boolean hasWings, boolean isDangerous, boolean isSleeping)
    {
        super(name, numberOfLegs, hasWings, isDangerous, isSleeping);
    }
    @Override
    public String toString()
    {
        return super.toString();
    }
    @Override
    public boolean canInjectPoison() {
        return isDangerous();
    }
    @Override
    public boolean surviveOverWinter() {
        return isSleeping();
    }
}
