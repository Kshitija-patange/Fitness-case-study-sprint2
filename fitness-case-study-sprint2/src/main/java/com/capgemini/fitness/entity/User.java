package com.capgemini.fitness.entity;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This is User POJO Class
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "user_table")
public class User{
	@Id
	@Column(name="user_id")
	private Integer userId;

	@NotNull
	@Column(name="f_name")
	private String fname;

	@NotNull
	@Column(name="l_name")
	private String lname;

	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z.0-9]*@[a-zA-Z]+([.][a-zA-Z]{2,3}){1,2}$",
	message = "Invalid emaiId")
	@Column(name="email_id")
	private String emailId;

	@NotNull
	@Column(name="shipping_address")
	private String shippingAddress;

	@Column(name="country")
	private String country;

	@Column(name="state")
	private String state;

	@NotNull
	@Column(name="city")
	private String city;

	@NotNull
	@Size(min=6 ,max=6)
	@Column(name="pincode")
	private Integer pincode;

	@Column(name="mobile_no",length=10)
	private Long mobileNo;

	@NotNull
	@Column(name="age")
	private Integer age;

	@NotNull
	@Pattern(regexp="^[A-Za-z_0-9@#$%]{6,12}",message="Password must be 6 characters")
	@Column(name = "password")
	private String password;

	@NotNull
	@Column(name = "role") 
	@Enumerated(EnumType.STRING)
	private Role role;


	/*
	 * many to many relation between user and trainer
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_trainer", 
	joinColumns = { @JoinColumn(name = "user_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "trainer_id") })
	private Set<Trainer> trainers;

	/*
	 * one to many relation with user and appointment
	 */
	@OneToMany(mappedBy = "user")
	private Set<Appointment> appointment;
}