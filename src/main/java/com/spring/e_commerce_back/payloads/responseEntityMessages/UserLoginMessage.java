package com.spring.e_commerce_back.payloads.responseEntityMessages;

import java.util.Date;

public record UserLoginMessage(Date date, String username, boolean connected) {
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		
		private Date date;
		private String username;
		private boolean connected;
		
		public Builder atDate(Date date) {
			this.date = date;
			return this;
		}
		
		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}
		
		public Builder isConnected(boolean connected) {
			this.connected = connected;
			return this;
		}
		
		public UserLoginMessage build() {
			return new UserLoginMessage(date ,username, connected);
		}
		
	}
	
}
