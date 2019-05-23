package com.piisw.computershop.controller;

import com.piisw.computershop.exception.ResourceNotFoundException;
import com.piisw.computershop.payload.response.GraphicsCardResponseDTO;
import com.piisw.computershop.repository.ImageContentStore;
import com.piisw.computershop.repository.ImageRepository;
import com.piisw.computershop.service.GraphicsCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GraphicsCardController {

	@Autowired
	private GraphicsCardService graphicsCardService;

	@Autowired
	private ImageContentStore imageContentStore;

	@Autowired
	private ImageRepository imageRepository;

	@GetMapping("/graphics-cards")
	public ResponseEntity<Page<GraphicsCardResponseDTO>> getGraphicsCards(Pageable pageable) {
		Page<GraphicsCardResponseDTO> graphicsCards = graphicsCardService.findAll(pageable);
		return ResponseEntity.ok(graphicsCards);
	}

	@GetMapping("/graphics-cards/{id}")
	public ResponseEntity<GraphicsCardResponseDTO> getGraphicsCard(@PathVariable Long id) {
		GraphicsCardResponseDTO graphicsCard = graphicsCardService.findById(id);
		return ResponseEntity.ok(graphicsCard);
	}

	@GetMapping("/graphics-cards/{id}/image")
	public ResponseEntity<?> getImage(@PathVariable Long id) {
		GraphicsCardResponseDTO graphicsCard = graphicsCardService.findById(id);
		System.out.println(graphicsCard.getImageId());
		return imageRepository.findById(graphicsCard.getImageId())
				.map(image -> {
					InputStreamResource inputStreamResource = new InputStreamResource(imageContentStore.getContent(image));
					HttpHeaders headers = new HttpHeaders();
					headers.setContentLength(image.getContentLength());
					headers.set(HttpHeaders.CONTENT_TYPE, image.getMimeType());
					return new ResponseEntity<Object>(inputStreamResource, headers, HttpStatus.OK);
				})
				.orElseThrow(() -> new ResourceNotFoundException("Graphics card image", "id", id.toString()));
	}
}
