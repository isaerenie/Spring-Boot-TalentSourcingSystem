package com.peoplist.talentsourcingsystem.entities;

import com.peoplist.talentsourcingsystem.utils.InteractionType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class CanInterJoin {
    @Id
    private Integer InteractionId;
    private Integer candidateId;
    private String nameSurname;
    @Enumerated(EnumType.STRING)
    private InteractionType interactionType;
    private String content;
    private Date date;
    private boolean candidateResponded;
}
