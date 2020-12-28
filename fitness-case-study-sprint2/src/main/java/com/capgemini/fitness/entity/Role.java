package com.capgemini.fitness.entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The Enum Role.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Role {
	USER("user"), TRAINER("trainer"), ADMIN("admin");

	@Getter
	private String role;
}
