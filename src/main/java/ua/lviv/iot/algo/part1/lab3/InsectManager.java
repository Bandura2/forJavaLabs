package ua.lviv.iot.algo.part1.lab3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
public final class InsectManager {
    private List<Insect> insects = new LinkedList<>();
    public void addInsect(final Insect insect) {
        insects.add(insect);
    }
    public List<Insect> findAllDangerous() {
        return insects.stream()
                .filter((insect -> insect.isDangerous()))
                .collect(Collectors.toList());
    }
    public List<Insect> findAllWithNumOfLegsGreaterThan(final int numOfLegs) {
        return insects.stream()
                .filter((insect) -> insect.getNumberOfLegs() > numOfLegs)
                .collect(Collectors.toList());
    }
}

