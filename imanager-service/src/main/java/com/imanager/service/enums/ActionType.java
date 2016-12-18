package com.imanager.service.enums;

import java.util.HashMap;
import java.util.Map;

public enum ActionType {
	ADD("add"), UPDATE("update"), DELETE("delete");

	private static final Map<String, ActionType> enumKeyValueMap = new HashMap<>();

	static {
		for (ActionType action : ActionType.values()) {
			enumKeyValueMap.put(action.getAction(), action);
		}
	}

	private String action;

	private ActionType(String action) {
		this.action = action;
	}

	public String getAction() {
		return action;
	}

	public static ActionType toEnum(String action) {
		return enumKeyValueMap.get(action);
	}
}
