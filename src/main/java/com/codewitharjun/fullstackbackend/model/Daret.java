package com.codewitharjun.fullstackbackend.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
public class Daret {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private int numberOfParticipants;
	private double amountPerPeriod;
	private String periodicity;
	private LocalDateTime startDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfParticipants() {
		return numberOfParticipants;
	}

	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}

	public double getAmountPerPeriod() {
		return amountPerPeriod;
	}

	public void setAmountPerPeriod(double amountPerPeriod) {
		this.amountPerPeriod = amountPerPeriod;
	}

	public String getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(String periodicity) {
		this.periodicity = periodicity;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	@Override
	public String toString() {
		return "Daret [id=" + id + ", name=" + name + ", numberOfParticipants=" + numberOfParticipants
				+ ", amountPerPeriod=" + amountPerPeriod + ", periodicity=" + periodicity + ", startDate=" + startDate
				+ "]";
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	

}
