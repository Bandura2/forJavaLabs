package ua.lviv.iot.part1.lab6.reposistory;

import ua.lviv.iot.part1.lab6.model.Mantis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class MantisReposistory {

    private final Map<Integer, Mantis> mapOfMantis = new HashMap<>();
    private final AtomicInteger availableId = new AtomicInteger();

    public Integer getNextAvailableId() {

        availableId.set(1);

        while (mapOfMantis.containsKey(availableId.get())) {

            availableId.incrementAndGet();
        }
        return availableId.get();
    }

    public Mantis getById(Integer mantisId) {
        return mapOfMantis.get(mantisId);
    }

    public void postMantisToMap(Mantis mantis) {

        mantis.setId(getNextAvailableId());
        mapOfMantis.put(mantis.getId(), mantis);
    }

    public void removeMantisWithMapForId(Integer mantisId) {
        mapOfMantis.remove(mantisId);
    }

    public List<Mantis> getListOfMantisWithMap() {
        return new LinkedList<>(mapOfMantis.values());
    }

    public boolean isMapContainedId(Integer mantisId) {
        return mapOfMantis.containsKey(mantisId);
    }

    public void updateMantisForId(Integer mantisId, Mantis mantis) {
        mapOfMantis.put(mantisId, mantis);
    }

    public boolean isMapContainedAnyMantis() {
        return mapOfMantis.isEmpty();
    }
}
