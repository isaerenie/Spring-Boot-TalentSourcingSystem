package com.peoplist.talentsourcingsystem.repositories;

import com.peoplist.talentsourcingsystem.entities.CanInterJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CanInterJoinRepository extends JpaRepository<CanInterJoin, Integer> {
    @Query(value = "SELECT c.name_surname,c.candidate_id, i.interaction_id,i.candidate_responded,i.content,i.date,i.interaction_type from  candidate c inner join interaction i on i.candidate_id=c.candidate_id WHERE i.candidate_id=?1", nativeQuery = true)
    List<CanInterJoin> findCanInt(int candidate_id);
}