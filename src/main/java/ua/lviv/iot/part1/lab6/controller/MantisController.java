package ua.lviv.iot.part1.lab6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ua.lviv.iot.part1.lab6.model.Mantis;
import ua.lviv.iot.part1.lab6.service.MantisService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/mantises")
@RestController
public class MantisController {

    @Autowired
    private MantisService mantisService;

    @PostMapping
    public Mantis createMantis(final @RequestBody Mantis mantis) {

        mantis.setId(mantisService.getNextAvailableId());
        mantisService.getMapOfMantis().put(mantis.getId(), mantis);
        return mantis;
    }

    @GetMapping(path = "/{id}")
    public Mantis getMantis(final @PathVariable("id") Integer mantisId) {

        return mantisService.getMapOfMantis().get(mantisId);
    }

    @DeleteMapping(path = "/{id}")
    public void removeMantis(final @PathVariable("id") Integer mantisId) {

        mantisService.getMapOfMantis().remove(mantisId);
    }

    @GetMapping
    public List<Mantis> getAllMantis() {

        return new ArrayList<Mantis>(mantisService.getMapOfMantis().values());
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Mantis> updateMantis(final @RequestBody Mantis mantis,
                                               final @PathVariable("id") Integer mantisId) {

        if (!mantisService.getMapOfMantis().containsKey(mantisId)) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        mantis.setId(mantisId);
        mantisService.getMapOfMantis().put(mantisId, mantis);

        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
