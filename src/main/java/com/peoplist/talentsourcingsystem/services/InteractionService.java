package com.peoplist.talentsourcingsystem.services;

import com.peoplist.talentsourcingsystem.entities.CanInterJoin;
import com.peoplist.talentsourcingsystem.entities.Interaction;
import com.peoplist.talentsourcingsystem.repositories.CanInterJoinRepository;
import com.peoplist.talentsourcingsystem.repositories.InteractionRepository;
import com.peoplist.talentsourcingsystem.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InteractionService {
   final InteractionRepository interactionRepository;
final CanInterJoinRepository canInterJoinRepository;
    public InteractionService(InteractionRepository interactionRepository, CanInterJoinRepository canInterJoinRepository) {
        this.interactionRepository = interactionRepository;
        this.canInterJoinRepository = canInterJoinRepository;
    }


    public ResponseEntity save(Interaction interaction) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            interaction.setDate(new Date());
            Interaction interaction1 = interactionRepository.save(interaction);
            hm.put(ERest.status, true);
            hm.put(ERest.result, interaction1);
        } catch (Exception e) {
            hm.put(ERest.error, "Error" + e);
            hm.put(ERest.status, false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            List<Interaction> ls = interactionRepository.findAll();
            hm.put(ERest.status, true);
            hm.put(ERest.result, ls);
        } catch (Exception e) {
            hm.put(ERest.error, "Error" + e);
            hm.put(ERest.status, false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity update(Interaction interaction) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Interaction> optionalInteraction = interactionRepository.findById(interaction.getInteractionId());
        try {
            if (optionalInteraction.isPresent()) {
                Interaction interaction1 = interactionRepository.saveAndFlush(interaction);
                hm.put(ERest.status, true);
                hm.put(ERest.result, interaction1);
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

    public ResponseEntity delete(int interactionId){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            interactionRepository.deleteById(interactionId);
            hm.put(ERest.status, true);
            hm.put(ERest.message, "Interaction deleted");
        }catch (Exception e){
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Error"+e);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity getCanInterList(int candidate_id) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<CanInterJoin> ls = canInterJoinRepository.findCanInt(candidate_id);
        hm.put(ERest.status, true);
        hm.put(ERest.result, ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
