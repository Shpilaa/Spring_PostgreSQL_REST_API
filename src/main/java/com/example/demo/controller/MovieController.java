//package com.example.demo.controller;
//
//import com.example.demo.exception.ResourceNotFoundException;
//import com.example.demo.model.Boss;
//import com.example.demo.repository.BossRepository;
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
//public class MovieController {
//    @Autowired
//    private BossRepository bossRepository;
//
//    // get Boss
//    @GetMapping("bosses")
//    public List<Boss> getAllBosses(){
//        return this.bossRepository.findAll();
//    }
//    // get Boss by id
//    @GetMapping("bosses/{id}")
//    public ResponseEntity<Boss> getEmployeeById(@PathVariable(value = "id") Long id_boss)
//            throws ResourceNotFoundException {
//        Boss boss = bossRepository.findById(id_boss)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id_boss));
//        return ResponseEntity.ok().body(boss);
//    }
//    // save Boss
//    @PostMapping("bosses")
//    public Boss createBoss(@RequestBody Boss boss){
//        return this.bossRepository.save(boss);
//
//    }
//    // update Boss
//    @PutMapping("bosses/{id}")
//    public ResponseEntity<Boss> updateBoss(@PathVariable(value = "id") Long id_boss,
//                                           @RequestBody Boss bossDetails) throws ResourceNotFoundException {
//        Boss boss = bossRepository.findById(id_boss)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id_boss));
//        boss.setName(boss.getName());
//        boss.setSurname(bossDetails.getSurname());
//
//        return ResponseEntity.ok(this.bossRepository.save(boss));
//    }
//    // delete Boss
//    @DeleteMapping("bosses/{id}")
//    public Map<String, Boolean> deleteBoss(@PathVariable(value = "id") Long id_boss) throws ResourceNotFoundException {
//        Boss boss = bossRepository.findById(id_boss)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id_boss));
//
//        this.bossRepository.delete(boss);
//
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//
//        return response;
//    }
//}
