package com.piisw.computershop.controller;

import com.piisw.computershop.payload.response.CategoryResponseDTO;
import com.piisw.computershop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public ResponseEntity<Page<CategoryResponseDTO>> getCategories(Pageable pageable) {
		Page<CategoryResponseDTO> categories = categoryService.findAll(pageable);
		return ResponseEntity.ok(categories);
	}
}
