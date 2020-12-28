package com.capgemini.fitness.entity;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is Trainer POJO Class
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name="trainer")
public class Trainer {
	@Id
	@Column(name="trainer_id")
	private Integer trainerId;

	@NotNull
	@Column(name="trainer_name")
	private String trainerName;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z.0-9]*@[a-zA-Z]+([.][a-zA-Z]{2,3}){1,2}$",
	message = "Invalid emaiId")
	@Column(name="email_id")
	private String emailId;

	@Column(name="address")
	private String address;

	@Column(name="mobile_no",length=10)
	private Long mobileNo;

	@NotNull
	@Pattern(regexp="^[A-Za-z_0-9@#$%]{6,12}",message="Password must be 6 characters")
	@Column(name = "password")
	private String password;

	@NotNull
	@Column(name = "role") 
	@Enumerated(EnumType.STRING)
	private Role role;

	/*
	 *  many to many relation between user and trainer
	 */
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="trainers")
	private Set<User> users;
}