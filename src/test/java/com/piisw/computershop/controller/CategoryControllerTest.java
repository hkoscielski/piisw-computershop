package com.piisw.computershop.controller;

import com.piisw.computershop.exception.ResourceNotFoundException;
import com.piisw.computershop.payload.response.CategoryResponseDTO;
import com.piisw.computershop.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategoryService categoryService;

	@Test
	public void shouldReturnThreeCategories() throws Exception {
		//given
		CategoryResponseDTO dto1 = new CategoryResponseDTO(1L, "Accessories");
		CategoryResponseDTO dto2 = new CategoryResponseDTO(2L, "CPU");
		CategoryResponseDTO dto3 = new CategoryResponseDTO(3L, "Graphics cards");

		List<CategoryResponseDTO> dtos = Arrays.asList(dto1, dto2, dto3);
		Page<CategoryResponseDTO> dtosPage = new PageImpl<>(dtos, PageRequest.of(1, 20), dtos.size());
		given(categoryService.findAll(any())).willReturn(dtosPage);

		//when
		mockMvc.perform(get("/api/products/categories"))
				//then
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.content", hasSize(3)));
	}

	@Test
	public void shouldReturnCategory() throws Exception {
		//given
		CategoryResponseDTO dto = new CategoryResponseDTO(1L, "Accessories");
		given(categoryService.findById(any())).willReturn(dto);

		//when
		mockMvc.perform(get(String.format("/api/products/categories/%d", dto.getId().intValue())))
				//then
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.id", is(1)));
	}

	@Test
	public void shouldNotReturnCategory() throws Exception {
		//given
		CategoryResponseDTO dto = new CategoryResponseDTO(10L, "Unknown");
		given(categoryService.findById(any())).willThrow(new ResourceNotFoundException("Category", "id", dto.getId().toString()));

		//when
		mockMvc.perform(get(String.format("/api/products/categories/%d", dto.getId().intValue())))
				//then
				.andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}
}