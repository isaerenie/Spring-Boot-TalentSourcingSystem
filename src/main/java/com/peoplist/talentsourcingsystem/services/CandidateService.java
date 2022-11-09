package com.peoplist.talentsourcingsystem.services;

import com.peoplist.talentsourcingsystem.entities.Candidate;
import com.peoplist.talentsourcingsystem.repositories.CandidateRepository;

import com.peoplist.talentsourcingsystem.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CandidateService {
    final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public ResponseEntity save(Candidate candidate) {
        System.out.println(candidate);
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            Candidate candidate1 = candidateRepository.save(candidate);
            hm.put(ERest.status, true);
            hm.put(ERest.result, candidate1);
        } catch (Exception e) {
            hm.put(ERest.error, "Error" + e);
            hm.put(ERest.status, false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            List<Candidate> ls = candidateRepository.findAll();
            hm.put(ERest.status, true);
            hm.put(ERest.result, ls);
        } catch (Exception e) {
            hm.put(ERest.error, "Error" + e);
            hm.put(ERest.status, false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity update(Candidate candidate) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Candidate> optionalCandidate = candidateRepository.findById(candidate.getCandidateId());
        try {
            if (optionalCandidate.isPresent()) {
                Candidate candidate1 = candidateRepository.saveAndFlush(candidate);
                hm.put(ERest.status, true);
                hm.put(ERest.result, candidate1);
            } else {
                hm.put(ERest.status, false);
                hm.put(ERest.message, "There is not this candidate!");
            }
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.error, "Error"+e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(int candidateId){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
        candidateRepository.deleteById(candidateId);
            hm.put(ERest.status, true);
            hm.put(ERest.message, "Candidate deleted");
        }catch (Exception e){
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error"+e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
