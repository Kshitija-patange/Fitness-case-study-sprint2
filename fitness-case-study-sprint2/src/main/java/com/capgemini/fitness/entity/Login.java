package com.capgemini.fitness.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="login")
public class Login {
	@Id
	@NotNull(message="id must not be empty")
	@Column
	private Integer id;

	@NotNull(message="Password must not be empty")
	private String password;       
}