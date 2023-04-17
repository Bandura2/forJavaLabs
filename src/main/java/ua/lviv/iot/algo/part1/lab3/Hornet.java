package ua.lviv.iot.algo.part1.lab3;
public final class Hornet extends Insect {
    public Hornet(final String name, final int numberOfLegs,
                  final boolean hasWings, final boolean isDangerous,
                  final boolean isSleeping) {
        super(name, numberOfLegs, hasWings, isDangerous, isSleeping);
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
