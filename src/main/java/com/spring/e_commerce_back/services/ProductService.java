package com.spring.e_commerce_back.services;

import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.e_commerce_back.entities.Product;
import com.spring.e_commerce_back.payloads.responseEntityMessages.CreateProductMessage;
import com.spring.e_commerce_back.payloads.responseEntityMessages.FindAllMessage;
import com.spring.e_commerce_back.payloads.responseEntityMessages.UpdateProductMessage;
import com.spring.e_commerce_back.repositories.ProductRepository;

@Service
public class ProductService {

	private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());

	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<FindAllMessage> findAll() {
		//@formatter:off
		var message = new FindAllMessage.Builder()
				.withStatus(HttpStatus.OK)
				.withDate(new Date())
				.withIterable(productRepository.findAll())
				.build();
		//@formatter:on
		return ResponseEntity.status(HttpStatus.OK).body(message);
	}

	public ResponseEntity<CreateProductMessage> create(Product product) {
		try {
			productRepository.save(product);

			var logMessage = String.format("Product %s with id %d has been successfully added", product.getTitle(),
					product.getId());
			LOGGER.log(Level.INFO, logMessage);

			//@formatter:off
            var message = new CreateProductMessage.Builder()
                    .withStatus(HttpStatus.OK)
                    .withTitle(product.getTitle())
                    .withQuantity(product.getQuantity())
                    .withLabel(product.getProductCategory())
                    .withMessage("Product Successfully added")
                    .withDate(new Date()).build();
            //@formatter:on

			return ResponseEntity.status(HttpStatus.OK).body(message);

		} catch (DataIntegrityViolationException ex) {
			//@formatter:off
            var message = new CreateProductMessage.Builder()
                    .withStatus(HttpStatus.BAD_REQUEST)
                    .withTitle(product.getTitle())
                    .withMessage("Error: Data integrity violation. Check your data.")
                    .withDate(new Date())
                    .build();
            //@formatter:on
			LOGGER.log(Level.SEVERE,
					String.format("Data integrity violation when creating a product: %s", ex.getMessage()));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		}
	}

	public ResponseEntity<UpdateProductMessage> update(Product product) {
		Optional<Product> optionalProduct = productRepository.findById(product.getId());

		if (optionalProduct.isPresent()) {
			productRepository.save(product);
			//@formatter:off
			var message = new UpdateProductMessage.Builder()
					.withStatus(HttpStatus.OK)
					.withProductTitle(product.getTitle())
					.withMessage("Product successfully updated")
					.withDate(new Date())
					.build();
			//@formatter:on

			var logMessage = String.format("Product %s with id %d has been updated", product.getTitle(),
					product.getId());
			LOGGER.log(Level.INFO, logMessage);
			return ResponseEntity.status(HttpStatus.OK).body(message);

		} else {
			//@formatter:off
			var message = new UpdateProductMessage.Builder()
					.withStatus(HttpStatus.NOT_FOUND)
					.withProductTitle(product.getTitle())
					.withMessage(String.format("Error when updating product: %s with id %d - PRODUCT NOT FOUND", product.getTitle(),product.getId()))
					.withDate(new Date())
					.build();
			//@formatter:on

			var logMessage = String.format("Error when updating product: %s with id %d - PRODUCT NOT FOUND",
					product.getTitle(), product.getId());
			LOGGER.log(Level.SEVERE, logMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}

	public ResponseEntity<?> delete(Long id) {

		Optional<Product> optionalProduct = productRepository.findById(id);

		if (optionalProduct.isPresent()) {
			productRepository.deleteById(id);
			var logMessage = String.format("Product with id %d deleted successfully", id);
			LOGGER.log(Level.SEVERE, logMessage);
			return ResponseEntity.status(HttpStatus.OK)
					.body(String.format("Product with id: %d has been successfully deleted", id));
		} else {
			var logMessage = String.format("Error when updating product with id %d - PRODUCT NOT FOUND", id);
			LOGGER.log(Level.SEVERE, logMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(String.format("Error when deleting product with id: %d - PRODUCT NOT FOUND", id));
		}

	}

}
