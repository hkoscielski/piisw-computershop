package com.piisw.computershop.controller;

import com.piisw.computershop.payload.response.GraphicsCardResponseDTO;
import com.piisw.computershop.service.GraphicsCardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GraphicsCardController.class)
public class GraphicsCardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GraphicsCardService graphicsCardService;

	@Test
	public void shouldReturnGraphicsCards() throws Exception {
		//given
		GraphicsCardResponseDTO dto1 = GraphicsCardResponseDTO.builder()
				.chipsetManufacturer("NVIDIA")
				.chipset("GeForce GTX 1050 Ti")
				.memorySize("4096 MB")
				.memoryType("GDDR5")
				.coreSpeed("1341 MHz")
				.memorySpeed("7008 MHz")
				.connectorType("PCI-Express x16")
				.build();
		GraphicsCardResponseDTO dto2 = GraphicsCardResponseDTO.builder()
				.chipsetManufacturer("AMD")
				.chipset("Radeon RX 590")
				.memorySize("8192 MB")
				.memoryType("GDDR5")
				.coreSpeed("1565 MHz")
				.memorySpeed("8000 MHz")
				.connectorType("PCI-Express x16")
				.build();
		List<GraphicsCardResponseDTO> dtos = Arrays.asList(dto1, dto2);
		Page<GraphicsCardResponseDTO> dtosPage = new PageImpl<>(dtos, PageRequest.of(1, 20), dtos.size());
		given(graphicsCardService.findAll(ArgumentMatchers.<Pageable>any())).willReturn(dtosPage);

		//when
		mockMvc.perform(get("/api/graphics-cards"))
				//then
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.content", hasSize(2)));
	}
}