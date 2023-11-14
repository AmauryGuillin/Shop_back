package com.spring.e_commerce_back.payloads.responseEntityMessages;

import java.util.Date;

import org.springframework.http.HttpStatus;

public record FindAllMessage(HttpStatus status, Date date, Iterable<?> productsList) {
	
	public Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		
		private HttpStatus status;
		private Date date;
		private Iterable<?> productsList;
		
		public Builder withStatus(HttpStatus status) {
			this.status = status;
			return this;
		}
		
		public Builder withDate(Date date) {
			this.date = date;
			return this;
		}
		
		public Builder withIterable(Iterable<?> productsList) {
			this.productsList = productsList;
			return this;
		}
		
		public FindAllMessage build() {
			return new FindAllMessage(status, date, productsList);
		}
		
	}
	
}
