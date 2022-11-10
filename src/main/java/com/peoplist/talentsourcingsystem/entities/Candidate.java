package com.peoplist.talentsourcingsystem.entities;
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
    private String candidateStatus;
}
