package ua.lviv.iot.part1.lab6.service;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.lviv.iot.part1.lab6.model.Mantis;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
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
}
