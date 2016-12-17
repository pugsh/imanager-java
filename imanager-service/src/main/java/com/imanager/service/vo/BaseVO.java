package com.imanager.service.vo;

import org.joda.time.DateTime;

public abstract class BaseVO {

	private String oid;
	private Long version;
	private DateTime createdAt;
	private DateTime lastModified;
	private String createdBy;
	private String lastModifiedBy;

	protected BaseVO() {
	}

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
		return "BaseVO [oid=" + oid + ", version=" + version + ", createdAt=" + createdAt + ", lastModified="
				+ lastModified + ", createdBy=" + createdBy + ", lastModifiedBy=" + lastModifiedBy + "]";
	}

}
