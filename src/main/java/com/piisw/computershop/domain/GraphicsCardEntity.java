package com.piisw.computershop.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "GRAPHICS_CARDS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")
public class GraphicsCardEntity extends ProductEntity {

	@Column(length = 50, name = "chipset_manufacturer", nullable = false)
	private String chipsetManufacturer;

	@Column(length = 75, nullable = false)
	private String chipset;

	@Column(length = 30, name = "memory_size", nullable = false)
	private String memorySize;

	@Column(length = 10, name = "memory_type", nullable = false)
	private String memoryType;

	@Column(length = 20, name = "core_speed", nullable = false)
	private String coreSpeed;

	@Column(length = 20, name = "memory_speed", nullable = false)
	private String memorySpeed;

	@Column(length = 30, name = "connector_type", nullable = false)
	private String connectorType;
}
