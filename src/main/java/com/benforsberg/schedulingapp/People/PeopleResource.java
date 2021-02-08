package com.benforsberg.schedulingapp.People;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PeopleResource {

    public String greeting = "Welcome ";

    @Autowired
    private PeopleRepository peopleRepository;


    @GetMapping("/")
    public String greeting() {
        return "<center><h1>Hello! Welcome to Ben's spring boot application!</h1></center>";
    }
    @GetMapping("/home")
    public String greetingHome() {
        return greeting  + retrieveAllPeople().get(0).getFirstName() +  " " + retrieveAllPeople().get(0).getLastName() + "!";
    }

    @GetMapping("/private")
    public String privateMessage() {
        return "Heyyy you're on a private page!";
    }



    @GetMapping("/people")
    public List<People> retrieveAllPeople() {
        return peopleRepository.findAll();
    }

    @GetMapping("/people/{id}")
    public People retrievePeople(@PathVariable long id) {
        Optional<People> people = peopleRepository.findById(id);

        if (!people.isPresent())
            throw new PeopleNotFoundException("id-" + id);

        return people.get();
    }

    @DeleteMapping("/people/{id}")
    public void deletePerson(@PathVariable long id) {
        peopleRepository.deleteById(id);
    }

    @PostMapping("/people")
    public ResponseEntity<Object> createPerson(@RequestBody People people) {
        People savedPeople = peopleRepository.save(people);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPeople.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Object> updatePerson(@RequestBody People people, @PathVariable long id) {

        Optional<People> personOptional = peopleRepository.findById(id);

        if (!personOptional.isPresent())
            return ResponseEntity.notFound().build();

        people.setId(id);

        peopleRepository.save(people);

        return ResponseEntity.noContent().build();
    }
}
