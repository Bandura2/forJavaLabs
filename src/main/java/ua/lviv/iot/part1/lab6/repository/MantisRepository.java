package ua.lviv.iot.part1.lab6.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.part1.lab6.model.Mantis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@Scope("singleton")
public class MantisRepository {

    private final Map<Integer, Mantis> mapOfMantis = new HashMap<>();
    private final AtomicInteger availableId = new AtomicInteger();

    public Mantis getById(final Integer mantisId) {
        return mapOfMantis.get(mantisId);
    }

    public void addMantis(final Mantis mantis) {

        mantis.setId(availableId.incrementAndGet());
        mapOfMantis.put(mantis.getId(), mantis);
    }

    public void removeById(final Integer mantisId) {
        mapOfMantis.remove(mantisId);
    }

    public List<Mantis> getListOfMantis() {
        return new LinkedList<>(mapOfMantis.values());
    }

    public boolean exists(final Integer mantisId) {
        return mapOfMantis.containsKey(mantisId);
    }

    public void update(final Mantis mantis) {
        mapOfMantis.put(mantis.getId(), mantis);
    }

    public boolean hasNotAnyMantis() {
        return mapOfMantis.isEmpty();
    }
}
