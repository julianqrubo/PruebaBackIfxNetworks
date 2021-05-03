package com.backend.ifxnetworks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "El documento es requerido")
	@Column(name = "document", unique = true, nullable = false)
	private Long document;

	@NotNull(message = "El nombre es requerido")
	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "phone")
	private Long phone;
}
