package com.spring.e_commerce_back.payloads.responseEntityMessages;

import java.util.Date;

import org.springframework.http.HttpStatus;


public record CreateProductMessage(HttpStatus status, String productTitle, int productQuantity, String productLabel, String message, Date date) {

	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		
		private HttpStatus status;
		private String productTitle;
		private int productQuantity;
		private String productLabel;
		private String message;
		private Date date;
		
		public Builder withStatus(HttpStatus status) {
			this.status = status;
			return this;
		}
		
		public Builder withTitle(String title) {
			this.productTitle = title;
			return this;
		}
		
		public Builder withQuantity(int quantity) {
			this.productQuantity = quantity;
			return this;
		}
		
		public Builder withLabel(String label) {
			this.productLabel = label;
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
		
		public CreateProductMessage build() {
			return new CreateProductMessage(status,productTitle, productQuantity, productLabel, message, date);
		}
		
	}
	
	
	
	
	

	
	
}
