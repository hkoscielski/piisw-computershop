package com.piisw.computershop.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_generator")
	@SequenceGenerator(name = "category_generator", sequenceName = "category_seq", allocationSize = 1)
	private Long id;

	@Column(length = 100, nullable = false, unique = true)
	private String name;
}
