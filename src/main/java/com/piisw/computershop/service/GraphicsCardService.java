package com.piisw.computershop.service;

import com.piisw.computershop.domain.GraphicsCardEntity;
import com.piisw.computershop.exception.ResourceNotFoundException;
import com.piisw.computershop.mapper.CollectionModelMapper;
import com.piisw.computershop.payload.response.GraphicsCardResponseDTO;
import com.piisw.computershop.repository.GraphicsCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
//@Transactional
public class GraphicsCardService {

	@Autowired
	private GraphicsCardRepository graphicsCardRepository;

	@Autowired
	private CollectionModelMapper collectionModelMapper;

	public Page<GraphicsCardResponseDTO> findAll(Pageable pageable) {
		Page<GraphicsCardEntity> graphicsCardEntityPage = graphicsCardRepository.findAll(pageable);
		return collectionModelMapper.mapPage(graphicsCardEntityPage, GraphicsCardResponseDTO.class);
	}

	public GraphicsCardResponseDTO findById(Long id) {
		return graphicsCardRepository.findById(id)
				.map(graphicsCard -> collectionModelMapper.map(graphicsCard, GraphicsCardResponseDTO.class))
				.orElseThrow(() -> new ResourceNotFoundException("Graphics card", "id", id.toString()));
	}
}
