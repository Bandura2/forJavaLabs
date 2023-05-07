package ua.lviv.iot.part1.lab6.model;

public final class Mosquito extends Insect {

    public Mosquito(final String name, final int numberOfLegs,
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
