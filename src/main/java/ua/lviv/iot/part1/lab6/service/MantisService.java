package ua.lviv.iot.part1.lab6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.lviv.iot.part1.lab6.model.Mantis;
import ua.lviv.iot.part1.lab6.repository.MantisRepository;

import java.util.List;

@Service
@Scope("singleton")
public class MantisService {

    @Autowired
    private MantisRepository mantisRepository;

    public Mantis getMantisForId(final Integer mantisId) {
        return mantisRepository.getById(mantisId);
    }

    public void createMantis(final Mantis mantis) {
        mantisRepository.addMantis(mantis);
    }

    public void removeMantisForId(final Integer mantisId) {
        mantisRepository.removeById(mantisId);
    }

    public List<Mantis> getListOfMantis() {
        return mantisRepository.getListOfMantis();
    }

    public boolean notExists(final Integer mantisId) {
        return !mantisRepository.exists(mantisId);
    }

    public void updateMantis(final Integer mantisId, final Mantis mantis) {
        mantis.setId(mantisId);
        mantisRepository.update(mantis);
    }

    public boolean isNotAnyMantises() {
        return mantisRepository.hasNotAnyMantis();
    }
}
