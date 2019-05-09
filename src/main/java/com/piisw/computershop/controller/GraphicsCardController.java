package com.piisw.computershop.controller;

import com.piisw.computershop.payload.response.GraphicsCardResponseDTO;
import com.piisw.computershop.service.GraphicsCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GraphicsCardController {

	@Autowired
	private GraphicsCardService graphicsCardService;

	@GetMapping("graphics-cards")
	public ResponseEntity<Page<GraphicsCardResponseDTO>> getGraphicsCards(Pageable pageable) {
		Page<GraphicsCardResponseDTO> graphicsCards = graphicsCardService.findAll(pageable);
		return ResponseEntity.ok(graphicsCards);
	}
}
