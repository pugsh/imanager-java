package com.imanager.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.imanager.service.constants.ServiceConstants;

@Document(collection = ServiceConstants.SEQUENCE_COLLECTION)
public class Sequence {

	@Id
	private String oid;
	@Indexed
	private String name;
	private Long seq;

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "Sequence [oid=" + oid + ", name=" + name + ", seq=" + seq + "]";
	}

}
