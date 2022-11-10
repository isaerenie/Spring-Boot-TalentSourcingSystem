package com.peoplist.talentsourcingsystem.repositories;

import com.peoplist.talentsourcingsystem.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    Candidate findByCandidateId(Integer candidateId);

    Candidate findByCandidateIdAndCandidateStatus(Integer candidateId, String candidateStatus);


}