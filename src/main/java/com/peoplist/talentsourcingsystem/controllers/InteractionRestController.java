package com.peoplist.talentsourcingsystem.controllers;

import com.peoplist.talentsourcingsystem.entities.Candidate;
import com.peoplist.talentsourcingsystem.entities.Interaction;
import com.peoplist.talentsourcingsystem.services.InteractionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interaction")
public class InteractionRestController {
    final InteractionService interactionService;

    public InteractionRestController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }
    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Interaction interaction){
        return interactionService.save(interaction);
    }
    @GetMapping("/list")
    public ResponseEntity list(){
        return interactionService.list();
    }
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Interaction interaction){
        return interactionService.update(interaction);
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam int interactionId){
        return interactionService.delete(interactionId);
    }
    @GetMapping("/getCanInterList/{candidateId}")
    public ResponseEntity getCanInterList(@PathVariable int candidateId){
        return interactionService.getCanInterList(candidateId);
    }

}
