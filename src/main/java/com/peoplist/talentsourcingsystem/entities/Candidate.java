package com.peoplist.talentsourcingsystem.entities;
import com.peoplist.talentsourcingsystem.utils.CandidateStatus;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer candidateId;
    private String nameSurname;
    private String phone;
    private String email;
    @Enumerated(EnumType.STRING)
    private CandidateStatus candidateStatus;
}
