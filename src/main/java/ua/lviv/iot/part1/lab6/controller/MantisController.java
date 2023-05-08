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

import java.util.List;

@RequestMapping("/mantises")
@RestController
public class MantisController {

    @Autowired
    private MantisService mantisService;

    @PostMapping
    public ResponseEntity<Mantis> createMantis(final @RequestBody Mantis mantis) {

        mantisService.createMantis(mantis);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Mantis> getMantis(final @PathVariable("id") Integer mantisId) {

        if (mantisService.isNotMantisWithId(mantisId)) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return new ResponseEntity<>(mantisService.getMantisForId(mantisId), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Mantis> removeMantis(final @PathVariable("id") Integer mantisId) {

        if (mantisService.isNotMantisWithId(mantisId)) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        mantisService.removeMantisForId(mantisId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<Mantis>> getAllMantis() {

        if (mantisService.isNotAnyMantises()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return new ResponseEntity<>(mantisService.getListOfMantis(), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Mantis> updateMantis(final @RequestBody Mantis mantis,
                                               final @PathVariable("id") Integer mantisId) {

        if (mantisService.isNotMantisWithId(mantisId)) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        mantis.setId(mantisId);
        mantisService.updateMantis(mantisId, mantis);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
