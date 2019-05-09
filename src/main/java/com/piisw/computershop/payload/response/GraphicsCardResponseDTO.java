package com.piisw.computershop.payload.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class GraphicsCardResponseDTO {

	@NotBlank private String chipsetManufacturer;
	@NotBlank private String chipset;
	@NotBlank private String memorySize;
	@NotBlank private String memoryType;
	@NotBlank private String coreSpeed;
	@NotBlank private String memorySpeed;
	@NotBlank private String connectorType;
}
