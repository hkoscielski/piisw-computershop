package com.piisw.computershop.service;

import com.piisw.computershop.domain.CategoryEntity;
import com.piisw.computershop.exception.ResourceNotFoundException;
import com.piisw.computershop.mapper.CollectionModelMapper;
import com.piisw.computershop.payload.response.CategoryResponseDTO;
import com.piisw.computershop.repository.CategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

	@Mock
	private CollectionModelMapper collectionModelMapper;

	@Mock
	private CategoryRepository categoryRepository;

	@InjectMocks
	private CategoryService categoryService;

	@Test
	public void shouldReturnCategoryResponseDtos() {
		//given
		CategoryEntity entity1 = new CategoryEntity(1L, "Accessories");
		CategoryEntity entity2 = new CategoryEntity(2L, "CPU");
		CategoryEntity entity3 = new CategoryEntity(3L, "Graphics cards");

		CategoryResponseDTO dto1 = new CategoryResponseDTO(1L, "Accessories");
		CategoryResponseDTO dto2 = new CategoryResponseDTO(2L, "CPU");
		CategoryResponseDTO dto3 = new CategoryResponseDTO(3L, "Graphics cards");

		List<CategoryEntity> entities = Arrays.asList(entity1, entity2, entity3);
		Page<CategoryEntity> entitiesPage = new PageImpl<>(entities, PageRequest.of(1, 20), entities.size());
		List<CategoryResponseDTO> dtos = Arrays.asList(dto1, dto2, dto3);
		Page<CategoryResponseDTO> dtosPage = new PageImpl<>(dtos, PageRequest.of(1, 20), dtos.size());
		given(categoryRepository.findAll(ArgumentMatchers.<Pageable>any())).willReturn(entitiesPage);
		given(collectionModelMapper.mapPage(entitiesPage, CategoryResponseDTO.class)).willReturn(dtosPage);

		//when
		Page<CategoryResponseDTO> categoryResponseDTOPage = categoryService.findAll(PageRequest.of(1, 20));

		//then
		assertEquals(3, categoryResponseDTOPage.getContent().size());
		assertThat(categoryResponseDTOPage.getContent(), everyItem(notNullValue(CategoryResponseDTO.class)));
	}

	@Test
	public void shouldReturnCategoryResponseDto() {
		//given
		CategoryEntity entity = new CategoryEntity(1L, "Accessories");
		CategoryResponseDTO dto = new CategoryResponseDTO(1L, "Accessories");
		given(categoryRepository.findById(1L)).willReturn(Optional.of(entity));
		given(collectionModelMapper.map(entity, CategoryResponseDTO.class)).willReturn(dto);

		//when
		CategoryResponseDTO foundCategory = categoryService.findById(entity.getId());

		//then
		assertNotNull(foundCategory);
		assertEquals(entity.getId(), foundCategory.getId());
		assertEquals(entity.getName(), foundCategory.getName());
	}

	@Test(expected = ResourceNotFoundException.class)
	public void shouldNotFoundCategoryResponseDtoAndThrowResourceNotFoundException() {
		//given
		CategoryEntity entity = new CategoryEntity(10L, "Unknown");
		given(categoryRepository.findById(10L)).willReturn(Optional.empty());

		//when
		categoryService.findById(entity.getId());
	}
}