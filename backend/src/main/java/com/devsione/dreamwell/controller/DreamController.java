package com.devsione.dreamwell.controller;

import com.devsione.dreamwell.dto.DreamDTO;
import com.devsione.dreamwell.entity.Dream;
import com.devsione.dreamwell.service.DreamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/dreams")
public class DreamController {

    private final DreamService dreamService;

    public DreamController(DreamService dreamService) {
        this.dreamService = dreamService;
    }

    @GetMapping("")
    public ResponseEntity<List<DreamDTO>> getAllDreams(){
        return ResponseEntity.ok(dreamService.findAll());
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<List<DreamDTO>> getDreams(@PathVariable UUID userid){
        return ResponseEntity.ok(dreamService.findByUser(userid));
    }

    @GetMapping("/{dreamid}")
    public ResponseEntity<DreamDTO> getDreamById(@PathVariable UUID dreamid){
        return ResponseEntity.ok(dreamService.findByID(dreamid));
    }

    @PostMapping("")
    public ResponseEntity<DreamDTO> saveDream(@RequestBody DreamDTO dreamDTO){
        return ResponseEntity.ok(dreamService.newDream(dreamDTO));
    }

    @DeleteMapping("/{dreamid}")
    void delete(@PathVariable UUID dreamid){
        dreamService.deleteDream(dreamid);
    }

}
