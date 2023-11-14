package com.spring.e_commerce_back.payloads.responseEntityMessages;

import java.util.Date;

import org.springframework.http.HttpStatus;

public record UpdateProductMessage(HttpStatus status, String productTitle, String message, Date date) {
	
	
	public static Builder builder() {
		return new Builder();
	}
	
	
	public static class Builder{
		
		private HttpStatus status;
		private String productTitle;
		private String message;
		private Date date;
		
		public Builder withStatus(HttpStatus status) {
			this.status = status;
			return this;
		}
		
		public Builder withProductTitle(String title) {
			this.productTitle = title;
			return this;
		}
		
		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}
		
		public Builder withDate(Date date) {
			this.date = date;
			return this;
		}
		
		public UpdateProductMessage build() {
			return new UpdateProductMessage(status, productTitle, message, date);
		}
	}

}

