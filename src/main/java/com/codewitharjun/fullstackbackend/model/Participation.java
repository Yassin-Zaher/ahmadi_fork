package com.codewitharjun.fullstackbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "participation_daret")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;


    @ManyToOne
    @JoinColumn(name = "daret_id")
    private Daret daret;
    private double amount;

}
