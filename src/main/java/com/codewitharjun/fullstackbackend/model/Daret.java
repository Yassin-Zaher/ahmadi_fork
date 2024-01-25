package com.codewitharjun.fullstackbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Daret {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int numberOfParticipants;
	private double amountPerPeriod;
	private String periodicity;
	private Enum state;
	@OneToMany(mappedBy = "daret")
	@JsonIgnore
	private Set<Participation> Participations;

}

