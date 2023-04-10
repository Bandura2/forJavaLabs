package ua.lviv.iot.algo.part1.lab3;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class InsectManager {
    private List<Insect> insects = new LinkedList<>();
    public void addInsect(final Insect insect) {
        insects.add(insect);
    }

    public void addInsects(final List<Insect> insects) {
        this.insects.addAll(insects);
    }

    public List<Insect> findAll(boolean isDangerous) {
        return insects.stream()
                .filter((insects) ->  insects.isDangerous() == isDangerous)
                .collect(Collectors.toList());
    }
    public List<Insect> findAllWithNumOfLegsGreaterThan(final int numOfLegs) {
        return insects.stream()
                .filter((insect) -> insect.getNumberOfLegs() > numOfLegs)
                .collect(Collectors.toList());
    }
}

