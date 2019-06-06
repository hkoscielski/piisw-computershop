package com.piisw.computershop.payload.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piisw.computershop.payload.AttributeDTO;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponseDTO {

	@NotNull
	private Long id;

	@NotBlank
	private String name;

	@NotNull
	private BigDecimal price;

	@NotNull
	private String categoryName;

	@JsonIgnore
	@NotNull
	private Long imageId;

	@NotNull
	private List<AttributeDTO> mainAttributes;

	@NotNull
	private List<AttributeDTO> additionalAttributes;

	@NotNull
	private String description;
}
