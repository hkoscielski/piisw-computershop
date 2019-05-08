package com.piisw.computershop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "RAMS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")
public class RamEntity extends ProductEntity {

	@Column(length = 60, nullable = false)
	private String series;

	@Column(length = 30, name = "memory_size", nullable = false)
	private String memorySize;

	@Column(length = 20, name = "memory_type", nullable = false)
	private String memoryType;

	@Column(length = 20, name = "speed_rating", nullable = false)
	private String speedRating;

	@Column(length = 2, name = "number_of_modules", nullable = false)
	private Integer numberOfModules;

	@Column(length = 40, nullable = false)
	private String standard;

	@Column(length = 5, name = "cycle_latency", nullable = false)
	@Min(0)
	private Integer cycleLatency;

	@Column(length = 20, nullable = false)
	private String frequency;
}
