package com.imanager.common.audit;

import org.springframework.data.domain.AuditorAware;

public class SimpleAuditor implements AuditorAware<String> {

	@Override
	public String getCurrentAuditor() {
		return "Pulak Ghosh";
	}

}
