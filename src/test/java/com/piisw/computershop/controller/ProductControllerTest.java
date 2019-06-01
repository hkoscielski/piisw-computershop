package com.piisw.computershop.controller;

import com.piisw.computershop.exception.ResourceNotFoundException;
import com.piisw.computershop.payload.AttributeDTO;
import com.piisw.computershop.payload.response.ProductResponseDTO;
import com.piisw.computershop.repository.ImageContentStore;
import com.piisw.computershop.repository.ImageRepository;
import com.piisw.computershop.service.ProductService;
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
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@MockBean
	private ImageContentStore imageContentStore;

	@MockBean
	private ImageRepository imageRepository;

	@Test
	public void shouldReturnTwoProducts() throws Exception {
		//given
		List<AttributeDTO> mainAttributesDtos1 = Arrays.asList(
				new AttributeDTO("Chipset manufacturer", "NVIDIA"),
				new AttributeDTO("Chipset", "GeForce GTX 1050 Ti")
		);
		List<AttributeDTO> additionalAttributesDtos1 = Arrays.asList(
				new AttributeDTO("Core speed", "1341 MHz"),
				new AttributeDTO("Memory speed", "7008 MHz")
		);
		ProductResponseDTO dto1 = new ProductResponseDTO(1L, 1L, mainAttributesDtos1, additionalAttributesDtos1);

		List<AttributeDTO> mainAttributesDtos2 = Arrays.asList(
				new AttributeDTO("Chipset manufacturer", "AMD"),
				new AttributeDTO("Chipset", "Radeon RX 590")
		);
		List<AttributeDTO> additionalAttributesDtos2 = Arrays.asList(
				new AttributeDTO("Core speed", "1565 MHz"),
				new AttributeDTO("Memory speed", "8000 MHz")
		);
		ProductResponseDTO dto2 = new ProductResponseDTO(2L, 2L, mainAttributesDtos2, additionalAttributesDtos2);

		List<ProductResponseDTO> dtos = Arrays.asList(dto1, dto2);
		Page<ProductResponseDTO> dtosPage = new PageImpl<>(dtos, PageRequest.of(1, 20), dtos.size());
		given(productService.findAll(any())).willReturn(dtosPage);

		//when
		mockMvc.perform(get("/api/products"))
				//then
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.content", hasSize(2)));
	}

	@Test
	public void shouldReturnProductsForGivenCategory() throws Exception {
		//given
		List<AttributeDTO> mainAttributes = Arrays.asList(
				new AttributeDTO("Chipset manufacturer", "NVIDIA"),
				new AttributeDTO("Chipset", "GeForce GTX 1050 Ti")
		);
		List<AttributeDTO> additionalAttributes = Arrays.asList(
				new AttributeDTO("Core speed", "1341 MHz"),
				new AttributeDTO("Memory speed", "7008 MHz")
		);
		ProductResponseDTO dto1 = new ProductResponseDTO(1L, 1L, mainAttributes, additionalAttributes);

		List<ProductResponseDTO> dtos = Collections.singletonList(dto1);
		Page<ProductResponseDTO> dtosPage = new PageImpl<>(dtos, PageRequest.of(1, 20), dtos.size());
		given(productService.findAllByCategory(any(), any())).willReturn(dtosPage);

		//when
		mockMvc.perform(get("/api/products")
				.param("categoryId", "3"))
				//then
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.content", hasSize(1)));
	}

	@Test
	public void shouldReturnProduct() throws Exception {
		//given
		List<AttributeDTO> mainAttributes = Arrays.asList(
				new AttributeDTO("Chipset manufacturer", "NVIDIA"),
				new AttributeDTO("Chipset", "GeForce GTX 1050 Ti")
		);
		List<AttributeDTO> additionalAttributes = Arrays.asList(
				new AttributeDTO("Core speed", "1341 MHz"),
				new AttributeDTO("Memory speed", "7008 MHz")
		);
		ProductResponseDTO dto = new ProductResponseDTO(1L, 1L, mainAttributes, additionalAttributes);

		given(productService.findById(any())).willReturn(dto);

		//when
		mockMvc.perform(get(String.format("/api/products/%d", dto.getId().intValue())))
				//then
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.id", is(1)));
	}

	@Test
	public void shouldNotReturnProduct() throws Exception {
		//given
		List<AttributeDTO> mainAttributes = Arrays.asList(
				new AttributeDTO("Chipset manufacturer", "NVIDIA"),
				new AttributeDTO("Chipset", "GeForce GTX 1050 Ti")
		);
		List<AttributeDTO> additionalAttributes = Arrays.asList(
				new AttributeDTO("Core speed", "1341 MHz"),
				new AttributeDTO("Memory speed", "7008 MHz")
		);
		ProductResponseDTO dto = new ProductResponseDTO(1L, 1L, mainAttributes, additionalAttributes);

		given(productService.findById(any())).willThrow(new ResourceNotFoundException("Product", "id", dto.getId().toString()));

		//when
		mockMvc.perform(get(String.format("/api/products/%d", dto.getId().intValue())))
				//then
				.andExpect(status().isNotFound())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}
}