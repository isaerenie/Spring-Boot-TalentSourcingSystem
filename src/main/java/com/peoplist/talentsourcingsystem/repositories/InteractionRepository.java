package com.peoplist.talentsourcingsystem.repositories;

import com.peoplist.talentsourcingsystem.entities.CanInterJoin;
import com.peoplist.talentsourcingsystem.entities.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InteractionRepository extends JpaRepository<Interaction, Integer> {

}