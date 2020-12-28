package com.capgemini.fitness.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is Admin POJO Class
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer admin_id;

	@NotNull
	@Size(min=2, message="Admin name should have atleast 2 characters!")
	@Column(name = "admin_name")
	private String admin_name;

	@NotBlank
	@Email(message="Email format invalid!")
	@Column(name = "email_id")
	private String emailId;

	@NotNull
	@Column(name = "address")
	private String address;

	@NotNull
	@Pattern(regexp="(^$|[0-9]{10})")
	@Column(name = "mobile_no")
	private Long mobileNo;

	@NotNull
	@Pattern(regexp="^[A-Za-z_0-9@#$%]{6,12}",message="Password must be 6 characters")
	@Column(name = "password")
	private String password;

	@NotNull
	@Column(name = "role") 
	@Enumerated(EnumType.STRING)
	private Role role;

}