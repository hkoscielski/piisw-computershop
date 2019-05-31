package com.piisw.computershop.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class AttributeDTO {

	@NotBlank
	private String name;

	@NotBlank
	private String value;
}
