package com.piisw.computershop.service;

import com.piisw.computershop.domain.ProductEntity;
import com.piisw.computershop.exception.ResourceNotFoundException;
import com.piisw.computershop.mapper.CollectionModelMapper;
import com.piisw.computershop.payload.response.ProductResponseDTO;
import com.piisw.computershop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CollectionModelMapper collectionModelMapper;

	public Page<ProductResponseDTO> findAll(Pageable pageable) {
		Page<ProductEntity> productEntityPage = productRepository.findAll(pageable);
		return collectionModelMapper.mapPage(productEntityPage, ProductResponseDTO.class);
	}

	public ProductResponseDTO findById(Long id) {
		return productRepository.findById(id)
				.map(product -> collectionModelMapper.map(product, ProductResponseDTO.class))
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id.toString()));
	}
}
