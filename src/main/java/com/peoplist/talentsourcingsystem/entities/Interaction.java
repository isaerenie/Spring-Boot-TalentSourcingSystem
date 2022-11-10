package com.peoplist.talentsourcingsystem.entities;

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
    private String interactionType;
    private String content;
    private Date date;
    private boolean candidateResponded;
}
