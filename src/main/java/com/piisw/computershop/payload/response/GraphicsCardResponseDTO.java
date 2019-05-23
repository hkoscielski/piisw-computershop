package com.piisw.computershop.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class GraphicsCardResponseDTO {

	@NotNull
	private Long id;

	@NotBlank
	private String chipsetManufacturer;

	@NotBlank
	private String chipset;

	@NotBlank
	private String memorySize;

	@NotBlank
	private String memoryType;

	@NotBlank
	private String coreSpeed;

	@NotBlank
	private String memorySpeed;

	@NotBlank
	private String connectorType;

	@JsonIgnore
	@NotNull
	private Long imageId;
}
