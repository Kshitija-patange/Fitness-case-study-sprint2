package com.capgemini.fitness.entity;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is Appointment POJO Class
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@Column(name = "appointment_id")
	private Integer appointment_id;

	@NotNull
	@Column(name = "user_id")
	private Integer user_id;

	@NotNull
	@Column(name = "trainer_id")
	private Integer trainer_id;

	@Column(name = "trainer_preference")
	private String trainer_Preference;

	@Column(name = "phy_theropist")
	private String phy_the;

	@NotNull
	@Column(name = "amount")
	private Integer amount;

	@Column(name = "location")
	private String location;

	@NotNull
	@Column(name = "date")
	private LocalDate date;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_appointment_id")
	private User user;

	public Appointment(Integer appointment_id) {
		super();
		this.appointment_id = appointment_id;
	}

	
	
}