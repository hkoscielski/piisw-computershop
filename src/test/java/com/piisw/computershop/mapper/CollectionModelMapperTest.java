package com.piisw.computershop.mapper;

import com.piisw.computershop.domain.GraphicsCardEntity;
import com.piisw.computershop.payload.response.GraphicsCardResponseDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class CollectionModelMapperTest {

	@TestConfiguration
	static class MappingTestConfiguration {

		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}

		@Bean
		@DependsOn("modelMapper")
		public CollectionModelMapper collectionModelMapper() {
			return new CollectionModelMapper();
		}
	}

	@Autowired
	private CollectionModelMapper collectionModelMapper;

	@Test
	public void shouldMapDtoToEntity() {
		//given
		GraphicsCardResponseDTO dto = GraphicsCardResponseDTO.builder()
				.chipsetManufacturer("NVIDIA")
				.chipset("GeForce GTX 1050 Ti")
				.memorySize("4096 MB")
				.memoryType("GDDR5")
				.coreSpeed("1341 MHz")
				.memorySpeed("7008 MHz")
				.connectorType("PCI-Express x16")
				.build();

		//when
		GraphicsCardEntity entity = collectionModelMapper.map(dto, GraphicsCardEntity.class);

		//then
		assertEquals(dto.getChipsetManufacturer(), entity.getChipsetManufacturer());
		assertEquals(dto.getChipset(), entity.getChipset());
		assertEquals(dto.getMemorySize(), entity.getMemorySize());
		assertEquals(dto.getMemoryType(), entity.getMemoryType());
		assertEquals(dto.getCoreSpeed(), entity.getCoreSpeed());
		assertEquals(dto.getMemorySpeed(), entity.getMemorySpeed());
		assertEquals(dto.getConnectorType(), entity.getConnectorType());
	}

	@Test
	public void shouldMapEntityToDto() {
		//given
		GraphicsCardEntity entity = GraphicsCardEntity.builder()
				.id(1L)
				.chipsetManufacturer("NVIDIA")
				.chipset("GeForce GTX 1050 Ti")
				.memorySize("4096 MB")
				.memoryType("GDDR5")
				.coreSpeed("1341 MHz")
				.memorySpeed("7008 MHz")
				.connectorType("PCI-Express x16")
				.build();

		//when
		GraphicsCardResponseDTO dto = collectionModelMapper.map(entity, GraphicsCardResponseDTO.class);

		//then
		assertEquals(entity.getChipsetManufacturer(), dto.getChipsetManufacturer());
		assertEquals(entity.getChipset(), dto.getChipset());
		assertEquals(entity.getMemorySize(), dto.getMemorySize());
		assertEquals(entity.getMemoryType(), dto.getMemoryType());
		assertEquals(entity.getCoreSpeed(), dto.getCoreSpeed());
		assertEquals(entity.getMemorySpeed(), dto.getMemorySpeed());
		assertEquals(entity.getConnectorType(), dto.getConnectorType());
	}

	@Test
	public void shouldMapPageDtoToPageEntity() {
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

		//when
		Page<GraphicsCardEntity> entitiesPage = collectionModelMapper.mapPage(dtosPage, GraphicsCardEntity.class);

		//then
		List<GraphicsCardResponseDTO> dtosPageContent = dtosPage.getContent();
		List<GraphicsCardEntity> entitiesPageContent = entitiesPage.getContent();
		assertEquals(dtosPage.getTotalElements(), entitiesPage.getTotalElements());
		assertEquals(dtosPageContent.get(0).getChipsetManufacturer(), entitiesPageContent.get(0).getChipsetManufacturer());
		assertEquals(dtosPageContent.get(0).getChipset(), entitiesPageContent.get(0).getChipset());
		assertEquals(dtosPageContent.get(0).getMemorySize(), entitiesPageContent.get(0).getMemorySize());
		assertEquals(dtosPageContent.get(0).getMemoryType(), entitiesPageContent.get(0).getMemoryType());
		assertEquals(dtosPageContent.get(0).getCoreSpeed(), entitiesPageContent.get(0).getCoreSpeed());
		assertEquals(dtosPageContent.get(0).getMemorySpeed(), entitiesPageContent.get(0).getMemorySpeed());
		assertEquals(dtosPageContent.get(0).getConnectorType(), entitiesPageContent.get(0).getConnectorType());
		assertEquals(dtosPageContent.get(1).getChipsetManufacturer(), entitiesPageContent.get(1).getChipsetManufacturer());
		assertEquals(dtosPageContent.get(1).getChipset(), entitiesPageContent.get(1).getChipset());
		assertEquals(dtosPageContent.get(1).getMemorySize(), entitiesPageContent.get(1).getMemorySize());
		assertEquals(dtosPageContent.get(1).getMemoryType(), entitiesPageContent.get(1).getMemoryType());
		assertEquals(dtosPageContent.get(1).getCoreSpeed(), entitiesPageContent.get(1).getCoreSpeed());
		assertEquals(dtosPageContent.get(1).getMemorySpeed(), entitiesPageContent.get(1).getMemorySpeed());
		assertEquals(dtosPageContent.get(1).getConnectorType(), entitiesPageContent.get(1).getConnectorType());
	}

	@Test
	public void shouldMapListDtoToListEntity() {
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

		//when
		List<GraphicsCardEntity> entities = collectionModelMapper.mapAll(dtos, GraphicsCardEntity.class);

		//then
		assertEquals(dtos.size(), entities.size());
		assertEquals(dtos.get(0).getChipsetManufacturer(), entities.get(0).getChipsetManufacturer());
		assertEquals(dtos.get(0).getChipset(), entities.get(0).getChipset());
		assertEquals(dtos.get(0).getMemorySize(), entities.get(0).getMemorySize());
		assertEquals(dtos.get(0).getMemoryType(), entities.get(0).getMemoryType());
		assertEquals(dtos.get(0).getCoreSpeed(), entities.get(0).getCoreSpeed());
		assertEquals(dtos.get(0).getMemorySpeed(), entities.get(0).getMemorySpeed());
		assertEquals(dtos.get(0).getConnectorType(), entities.get(0).getConnectorType());
		assertEquals(dtos.get(1).getChipsetManufacturer(), entities.get(1).getChipsetManufacturer());
		assertEquals(dtos.get(1).getChipset(), entities.get(1).getChipset());
		assertEquals(dtos.get(1).getMemorySize(), entities.get(1).getMemorySize());
		assertEquals(dtos.get(1).getMemoryType(), entities.get(1).getMemoryType());
		assertEquals(dtos.get(1).getCoreSpeed(), entities.get(1).getCoreSpeed());
		assertEquals(dtos.get(1).getMemorySpeed(), entities.get(1).getMemorySpeed());
		assertEquals(dtos.get(1).getConnectorType(), entities.get(1).getConnectorType());
	}

	@Test
	public void shouldMapListEntityToListDto() {
		//given
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
		List<GraphicsCardEntity> entities = Arrays.asList(entity1, entity2);

		//when
		List<GraphicsCardResponseDTO> dtos = collectionModelMapper.mapAll(entities, GraphicsCardResponseDTO.class);

		//then
		assertEquals(dtos.size(), entities.size());
		assertEquals(entities.get(0).getChipsetManufacturer(), dtos.get(0).getChipsetManufacturer());
		assertEquals(entities.get(0).getChipset(), dtos.get(0).getChipset());
		assertEquals(entities.get(0).getMemorySize(), dtos.get(0).getMemorySize());
		assertEquals(entities.get(0).getMemoryType(), dtos.get(0).getMemoryType());
		assertEquals(entities.get(0).getCoreSpeed(), dtos.get(0).getCoreSpeed());
		assertEquals(entities.get(0).getMemorySpeed(), dtos.get(0).getMemorySpeed());
		assertEquals(entities.get(0).getConnectorType(), dtos.get(0).getConnectorType());
		assertEquals(entities.get(1).getChipsetManufacturer(), dtos.get(1).getChipsetManufacturer());
		assertEquals(entities.get(1).getChipset(), dtos.get(1).getChipset());
		assertEquals(entities.get(1).getMemorySize(), dtos.get(1).getMemorySize());
		assertEquals(entities.get(1).getMemoryType(), dtos.get(1).getMemoryType());
		assertEquals(entities.get(1).getCoreSpeed(), dtos.get(1).getCoreSpeed());
		assertEquals(entities.get(1).getMemorySpeed(), dtos.get(1).getMemorySpeed());
		assertEquals(entities.get(1).getConnectorType(), dtos.get(1).getConnectorType());
	}
}