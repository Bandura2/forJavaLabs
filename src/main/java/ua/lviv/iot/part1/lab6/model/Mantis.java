package ua.lviv.iot.part1.lab6.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public final class Mantis extends Insect {

    private Integer id;

    public Mantis(final String name, final int numberOfLegs,
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
