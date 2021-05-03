package com.backend.ifxnetworks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(name = "company_employee", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "company_id", "employee_id" }, name = "IX_CompanyEmployee") })
public class CompanyEmployeeEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "El empleado es requerido")
	@Column(name = "employee_id", nullable = false)
	private Long employee_id;

	@NotNull(message = "La emprea es requerido")
	@Column(name = "company_id", nullable = false)
	private Long company_id;
}
