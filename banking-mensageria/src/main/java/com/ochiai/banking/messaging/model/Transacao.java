package com.ochiai.banking.messaging.model;

import java.util.UUID;

public class Transacao {
	protected String uuid;

	public Transacao() {
		setUuid(UUID.randomUUID().toString());
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
