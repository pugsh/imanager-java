package com.imanager.service.model;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

public abstract class BaseDocument {
	
	@Id
	private String oid;
	@Version
	private Long version;
	@CreatedDate
	private DateTime createdAt;
	@LastModifiedDate
	private DateTime lastModified;
	@CreatedBy
	private String createdBy;
	@LastModifiedBy
	private String lastModifiedBy;

	protected BaseDocument() {
	}

	public abstract String getKeyName();

	public abstract Long getKeyValue();

	public abstract void setKeyValue(Long value);

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public DateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(DateTime createdAt) {
		this.createdAt = createdAt;
	}

	public DateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(DateTime lastModified) {
		this.lastModified = lastModified;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	@Override
	public String toString() {
		return "BaseDocument [oid=" + oid + ", version=" + version + ", createdAt=" + createdAt + ", lastModified="
				+ lastModified + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + "]";
	}

}
