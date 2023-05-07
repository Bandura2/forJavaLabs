package ua.lviv.iot.part1.lab6.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.lviv.iot.part1.lab6.model.Mantis;
import ua.lviv.iot.part1.lab6.reposistory.MantisReposistory;

import java.util.List;

@Service
@Scope("singleton")
public class MantisService {

    private final MantisReposistory mantisReposistory = new MantisReposistory();


    public Mantis getMantisWithMapForId(final Integer mantisId) {
        return mantisReposistory.getById(mantisId);
    }

    public void postMantis(final Mantis mantis) {

        mantisReposistory.postMantisToMap(mantis);
    }

    public void removeMantisForId(final Integer mantisId) {
        mantisReposistory.removeMantisWithMapForId(mantisId);
    }

    public List<Mantis> getListOfMantis() {

        return mantisReposistory.getListOfMantisWithMap();
    }

    public boolean isEmptyId(final Integer mantisId) {
        return !mantisReposistory.isMapContainedId(mantisId);
    }

    public void putMantis(final Integer mantisId, final Mantis mantis) {
        mantisReposistory.updateMantisForId(mantisId, mantis);
    }

    public boolean isMapEmpty() {
        return mantisReposistory.isMapContainedAnyMantis();
    }
}
