package com.imanager.service.enums;

import java.util.HashMap;
import java.util.Map;

public enum SortDirection {
	ASCENDING(SortDirection.ASC), DESCENDING(SortDirection.DESC);

	static final String ASC = "asc";
	static final String DESC = "desc";

	private static final Map<String, SortDirection> enumKeyValueMap = new HashMap<>();

	static {
		for (SortDirection sortDirection : SortDirection.values()) {
			enumKeyValueMap.put(sortDirection.getValue(), sortDirection);
		}
	}

	private String direction;

	private SortDirection(String direction) {
		this.direction = direction;
	}

	public String getValue() {
		return direction;
	}

	public static SortDirection toEnum(String direction) {
		return enumKeyValueMap.get(direction);
	}

}
