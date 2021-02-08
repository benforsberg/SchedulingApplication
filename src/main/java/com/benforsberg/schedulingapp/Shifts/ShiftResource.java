package com.benforsberg.schedulingapp.Shifts;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.benforsberg.schedulingapp.People.People;
import com.benforsberg.schedulingapp.People.PeopleNotFoundException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ShiftResource {

    private List<Shift> shiftsList = new ArrayList<Shift>();
    @Autowired
    private ShiftRepository shiftRepository;

    @GetMapping("/shifts")
    public List<Shift> retrieveAllShifts() {
        return shiftRepository.findAll();
    }

    @GetMapping("/shifts/{id}")
    public Shift retrieveShift(@PathVariable long id) {
        Optional<Shift> shift = shiftRepository.findById(id);

        if (!shift.isPresent())
            throw new ShiftNotFoundException("id-" + id);

        return shift.get();
    }

    @DeleteMapping("/shifts/{id}")
    public void deleteShift(@PathVariable long id) {
        shiftRepository.deleteById(id);
    }

    @PostMapping("/shifts")
    public ResponseEntity<Object> createShift(@RequestBody Shift shift) {
        Shift savedshift = shiftRepository.save(shift);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedshift.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/shifts/{id}")
    public ResponseEntity<Object> updateShift(@RequestBody Shift shift, @PathVariable long id) {

        Optional<Shift> shiftOptional = shiftRepository.findById(id);

        if (!shiftOptional.isPresent())
            return ResponseEntity.notFound().build();

        shift.setId(id);

        shiftRepository.save(shift);

        return ResponseEntity.noContent().build();
    }

}
