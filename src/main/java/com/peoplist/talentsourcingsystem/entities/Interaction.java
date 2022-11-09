package com.peoplist.talentsourcingsystem.entities;

import com.peoplist.talentsourcingsystem.utils.CandidateStatus;
import com.peoplist.talentsourcingsystem.utils.InteractionType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer InteractionId;
    private int candidateId;
    @Enumerated(EnumType.STRING)
    private InteractionType interactionType;
    private String content;
    private Date date;
    private boolean candidateResponded;
}
