package com.peoplist.talentsourcingsystem.controllers;

import com.peoplist.talentsourcingsystem.entities.Candidate;
import com.peoplist.talentsourcingsystem.services.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Candidate candidate){
        System.out.println(candidate);
        return candidateService.save(candidate);
    }
    @GetMapping("/list")
    public ResponseEntity list(){
        return candidateService.list();
    }
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody Candidate candidate){
        return candidateService.update(candidate);
    }
    @PostMapping("/candidateChangeStatus")
    public ResponseEntity update(@RequestParam int candidateId,@RequestParam String candidateStatus){
        return candidateService.candidateChangeStatus(candidateId,candidateStatus);
    }
    @DeleteMapping("/delete/{candidateId}")
    public ResponseEntity delete(@PathVariable int candidateId){
        return candidateService.delete(candidateId);
    }
    @GetMapping("/findByCandidateId/{candidateId}")
    public ResponseEntity findByCandidateId(@PathVariable int candidateId){
        return candidateService.findByCandidateId(candidateId);
    }


}
