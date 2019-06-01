package com.piisw.computershop.payload.response;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoryResponseDTO {

	@NotNull
	private Long id;

	@NotBlank
	private String name;
}
