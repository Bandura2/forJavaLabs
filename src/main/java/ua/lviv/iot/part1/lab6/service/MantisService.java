package ua.lviv.iot.part1.lab6.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.lviv.iot.part1.lab6.model.Mantis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Scope("singleton")
public class MantisService {

    private Map<Integer, Mantis> mapOfMantis = new HashMap<>();
    private AtomicInteger availableId = new AtomicInteger();

    public Integer getNextAvailableId() {

        availableId.set(1);

        while (mapOfMantis.containsKey(availableId.get())) {

            availableId.incrementAndGet();
        }
        return availableId.get();
    }

    public Mantis getMantisWithMapForId(Integer mantisId) {
        return mapOfMantis.get(mantisId);
    }

    public void postMantisToMapWithId(Mantis mantis) {
        mantis.setId(getNextAvailableId());
        mapOfMantis.put(mantis.getId(), mantis);
    }

    public void removeMantisWithMapForId(Integer mantisId) {
        mapOfMantis.remove(mantisId);
    }

    public List<Mantis> getListOfMantis() {
        return new LinkedList<>(mapOfMantis.values());
    }

    public boolean isMapContainId(Integer mantisId) {
        return mapOfMantis.containsKey(mantisId);
    }

    public void putMantis(Integer mantisId, Mantis mantis) {
        mapOfMantis.put(mantisId, mantis);
    }
}
