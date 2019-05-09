package com.piisw.computershop.service;

import com.piisw.computershop.domain.GraphicsCardEntity;
import com.piisw.computershop.mapper.CollectionModelMapper;
import com.piisw.computershop.payload.response.GraphicsCardResponseDTO;
import com.piisw.computershop.repository.GraphicsCardRepository;
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

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class GraphicsCardServiceTest {

	@Mock
	private CollectionModelMapper collectionModelMapper;

	@Mock
	private GraphicsCardRepository graphicsCardRepository;

	@InjectMocks
	private GraphicsCardService graphicsCardService;

	@Test
	public void shouldReturnGraphicsCardResponseDtos() {
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
		GraphicsCardEntity entity1 = GraphicsCardEntity.builder()
				.id(1L)
				.chipsetManufacturer("NVIDIA")
				.chipset("GeForce GTX 1050 Ti")
				.memorySize("4096 MB")
				.memoryType("GDDR5")
				.coreSpeed("1341 MHz")
				.memorySpeed("7008 MHz")
				.connectorType("PCI-Express x16")
				.build();
		GraphicsCardEntity entity2 = GraphicsCardEntity.builder()
				.id(2L)
				.chipsetManufacturer("AMD")
				.chipset("Radeon RX 590")
				.memorySize("8192 MB")
				.memoryType("GDDR5")
				.coreSpeed("1565 MHz")
				.memorySpeed("8000 MHz")
				.connectorType("PCI-Express x16")
				.build();
		List<GraphicsCardResponseDTO> dtos = Arrays.asList(dto1, dto2);
		List<GraphicsCardEntity> entities = Arrays.asList(entity1, entity2);
		Page<GraphicsCardResponseDTO> dtosPage = new PageImpl<>(dtos, PageRequest.of(1, 20), dtos.size());
		Page<GraphicsCardEntity> entitiesPage = new PageImpl<>(entities, PageRequest.of(1, 20), entities.size());
		given(graphicsCardRepository.findAll(ArgumentMatchers.<Pageable>any())).willReturn(entitiesPage);
		given(collectionModelMapper.mapPage(entitiesPage, GraphicsCardResponseDTO.class)).willReturn(dtosPage);

		//when
		Page<GraphicsCardResponseDTO> graphicsCardResponseDTOPage = graphicsCardService.findAll(PageRequest.of(1, 20));

		//then
		assertEquals(2, graphicsCardResponseDTOPage.getContent().size());
		assertThat(dtosPage.getContent(), containsInAnyOrder(graphicsCardResponseDTOPage.getContent().toArray()));
	}
}