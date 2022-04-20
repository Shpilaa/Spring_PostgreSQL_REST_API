package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.ActorRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    // get Actor
    @GetMapping("actors")
    public List<Actor> getAllActors(){
        return this.actorRepository.findAll();
    }
    // get Actor by id
    @GetMapping("actors/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable(value = "id") Long id_actor)
            throws ResourceNotFoundException {
        Actor actor = actorRepository.findById(id_actor)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id_actor));
        return ResponseEntity.ok().body(actor);
    }
    // save Actor
    @PostMapping("actors")
    public Actor createActor(@RequestBody Actor actor){
        return this.actorRepository.save(actor);

    }
    // update Actor
    @PutMapping("actors/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") Long id_actor,
                                             @RequestBody Actor actorDetails) throws ResourceNotFoundException {
        Actor actor = actorRepository.findById(id_actor)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id_actor));
        actor.setName(actorDetails.getName());
        actor.setSurname(actorDetails.getSurname());

        return ResponseEntity.ok(this.actorRepository.save(actor));
    }
    // delete Actor
    @DeleteMapping("actors/{id}")
    public Map<String, Boolean> deleteActor(@PathVariable(value = "id") Long id_actor) throws ResourceNotFoundException {
        Actor actor = actorRepository.findById(id_actor)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id_actor));

        this.actorRepository.delete(actor);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
