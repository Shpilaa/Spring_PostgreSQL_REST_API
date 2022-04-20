package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Actor;
import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;

    // get Manager
    @GetMapping("managers")
    public List<Manager> getAllManagers(){
        return this.managerRepository.findAll();
    }
    // get Manager by id
    @GetMapping("managers/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable(value = "id") Long id_manager)
            throws ResourceNotFoundException {
        Manager manager = managerRepository.findById(id_manager)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id_manager));
        return ResponseEntity.ok().body(manager);
    }
    // save Manager
    @PostMapping("managers")
    public Manager createManager(@RequestBody Manager manager){
        return this.managerRepository.save(manager);

    }
    // update Manager
    @PutMapping("managers/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable(value = "id") Long id_manager,
                                                 @RequestBody Manager managerDetails) throws ResourceNotFoundException {
        Manager manager = managerRepository.findById(id_manager)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id_manager));
        manager.setName(managerDetails.getName());
        manager.setSurname(managerDetails.getSurname());
        manager.setActor(managerDetails.getActor());
        
        return ResponseEntity.ok(this.managerRepository.save(manager));
    }
    // delete Manager
    @DeleteMapping("managers/{id}")
    public Map<String, Boolean> deleteManager(@PathVariable(value = "id") Long id_manager) throws ResourceNotFoundException {
        Manager manager = managerRepository.findById(id_manager)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id_manager));

        this.managerRepository.delete(manager);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
