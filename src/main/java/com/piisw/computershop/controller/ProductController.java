package com.piisw.computershop.controller;

import com.piisw.computershop.exception.ResourceNotFoundException;
import com.piisw.computershop.payload.response.ProductResponseDTO;
import com.piisw.computershop.repository.ImageContentStore;
import com.piisw.computershop.repository.ImageRepository;
import com.piisw.computershop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ImageContentStore imageContentStore;

	@Autowired
	private ImageRepository imageRepository;

	@GetMapping("/products")
	public ResponseEntity<Page<ProductResponseDTO>> getProducts(
			@RequestParam(value = "categoryId", required = false) Long categoryId,
			Pageable pageable) {

		Page<ProductResponseDTO> products;

		if (categoryId == null) {
			products = productService.findAll(pageable);
		} else {
			products = productService.findAllByCategory(categoryId, pageable);
		}

		return ResponseEntity.ok(products);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ProductResponseDTO> getGraphicsCard(@PathVariable Long id) {
		ProductResponseDTO product = productService.findById(id);
		return ResponseEntity.ok(product);
	}

	@GetMapping("/products/{id}/image")
	public ResponseEntity<?> getImage(@PathVariable Long id) {
		ProductResponseDTO product = productService.findById(id);
		System.out.println(product.getImageId());
		return imageRepository.findById(product.getImageId())
				.map(image -> {
					InputStreamResource inputStreamResource = new InputStreamResource(imageContentStore.getContent(image));
					HttpHeaders headers = new HttpHeaders();
					headers.setContentLength(image.getContentLength());
					headers.set(HttpHeaders.CONTENT_TYPE, image.getMimeType());
					return new ResponseEntity<Object>(inputStreamResource, headers, HttpStatus.OK);
				})
				.orElseThrow(() -> new ResourceNotFoundException("Product image", "id", id.toString()));
	}
}
