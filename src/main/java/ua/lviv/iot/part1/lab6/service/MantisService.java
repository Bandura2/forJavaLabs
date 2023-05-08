package ua.lviv.iot.part1.lab6.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.lviv.iot.part1.lab6.model.Mantis;
import ua.lviv.iot.part1.lab6.repository.MantisRepository;

import java.util.List;

@Service
@Scope("singleton")
public class MantisService {

    private final MantisRepository mantisRepository = new MantisRepository();


    public Mantis getMantisWithMapForId(final Integer mantisId) {
        return mantisRepository.getById(mantisId);
    }

    public void postMantis(final Mantis mantis) {

        mantisRepository.postMantisToMap(mantis);
    }

    public void removeMantisForId(final Integer mantisId) {
        mantisRepository.removeMantisWithMapForId(mantisId);
    }

    public List<Mantis> getListOfMantis() {

        return mantisRepository.getListOfMantisWithMap();
    }

    public boolean isEmptyId(final Integer mantisId) {
        return !mantisRepository.isMapContainedId(mantisId);
    }

    public void putMantis(final Integer mantisId, final Mantis mantis) {
        mantisRepository.updateMantisForId(mantisId, mantis);
    }

    public boolean isMapEmpty() {
        return mantisRepository.isMapContainedAnyMantis();
    }
}
