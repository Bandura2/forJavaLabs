package ua.lviv.iot.part1.lab6.manager;

import lombok.Getter;
import ua.lviv.iot.part1.lab6.model.Insect;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class InsectManager {

    private final List<Insect> insects = new LinkedList<>();

    public void addInsect(final Insect insect) {
        insects.add(insect);
    }

    public void addInsects(final List<Insect> listInsects) {
        this.insects.addAll(listInsects);
    }

    public List<Insect> findAll(final boolean isDangerous) {
        return insects.stream()
                .filter((insects) -> insects.isDangerous() == isDangerous)
                .collect(Collectors.toList());
    }

    public List<Insect> findAllWithNumOfLegsGreaterThan(final int numOfLegs) {
        return insects.stream()
                .filter((insect) -> insect.getNumberOfLegs() > numOfLegs)
                .collect(Collectors.toList());
    }
}
