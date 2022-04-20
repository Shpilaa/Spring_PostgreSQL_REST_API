//package com.example.demo.controller;
//
//import com.example.demo.exception.ResourceNotFoundException;
//import com.example.demo.model.Studio;
//import com.example.demo.repository.StudioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/")
//public class StudioController {
//    @Autowired
//    private StudioRepository studioRepository;
//
//    // get Studio
//    @GetMapping("studios")
//    public List<Studio> getAllStudios(){
//        return this.studioRepository.findAll();
//    }
//    // get Studio by id
//    @GetMapping("studios/{name}")
//    public ResponseEntity<Studio> getStudioByName(@PathVariable(value = "name") String name_studio)
//            throws ResourceNotFoundException {
//        Studio studio = studioRepository.findById(name_studio)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + name_studio));
//        return ResponseEntity.ok().body(studio);
//    }
//    // save Studio
//    @PostMapping("studios")
//    public Studio createStudio(@RequestBody Studio studio){
//        return this.studioRepository.save(studio);
//
//    }
//    // update Studio
//    @PutMapping("studios/{name}")
//    public ResponseEntity<Studio> updateStudio(@PathVariable(value = "name") String name_studio,
//                                           @RequestBody Studio studioDetails) throws ResourceNotFoundException {
//        Studio studio = studioRepository.findById(name_studio)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + name_studio));
//        studio.setName(studio.getName());
//        studio.setId(studioDetails.getId());
//
//        return ResponseEntity.ok(this.studioRepository.save(studio));
//    }
//    // delete Studio
//    @DeleteMapping("studios/{name}")
//    public Map<String, Boolean> deleteStudio(@PathVariable(value = "name") String name_studio) throws ResourceNotFoundException {
//        Studio studio = studioRepository.findById(name_studio)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + name_studio));
//
//        this.studioRepository.delete(studio);
//
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//
//        return response;
//    }
//}
