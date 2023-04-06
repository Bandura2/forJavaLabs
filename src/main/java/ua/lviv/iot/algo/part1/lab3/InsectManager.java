package ua.lviv.iot.algo.part1.lab3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class InsectManager {
    private List<Insect> insects = new LinkedList<>();
    public void addInsect(final Insect insect) {
        insects.add(insect);
    }
    public List<Insect> findAllDangerous() {
        return insects.stream()
                        .filter((insect -> insect.isDangerous()))
                        .collect(Collectors.toList());
    }
    public List<Insect> findAllWithNumberOfLegsGreaterThan(final int numberOfLegs) {
        return insects.stream()
                        .filter((insect) -> insect.getNumberOfLegs() > numberOfLegs)
                        .collect(Collectors.toList());
    }
}
