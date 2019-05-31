package com.piisw.computershop.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piisw.computershop.payload.AttributeDTO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponseDTO {

	@NotNull
	private Long id;

	@JsonIgnore
	@NotNull
	private Long imageId;

	@NotNull
	private Map<String, AttributeDTO> mainAttributes;

	@NotNull
	private Map<String, AttributeDTO> additionalAttributes;
}
