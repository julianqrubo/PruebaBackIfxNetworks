package com.backend.ifxnetworks.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {

	@Column(name = "datecreated")
	private Timestamp dateCreated;

	@Column(name = "dateupdated")
	private Timestamp dateUpdated;

	public void setDateCreated() {
		if (this.getDateCreated() == null) {
			this.dateCreated = com.backend.ifxnetworks.Utils.EntityUtils.getCurrentDate();
		}
	}
}