package com.piisw.computershop.service;

import com.piisw.computershop.domain.CategoryEntity;
import com.piisw.computershop.mapper.CollectionModelMapper;
import com.piisw.computershop.payload.response.CategoryResponseDTO;
import com.piisw.computershop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CollectionModelMapper collectionModelMapper;

	public Page<CategoryResponseDTO> findAll(Pageable pageable) {
		Page<CategoryEntity> categoryEntityPage = categoryRepository.findAll(pageable);
		return collectionModelMapper.mapPage(categoryEntityPage, CategoryResponseDTO.class);
	}
}
