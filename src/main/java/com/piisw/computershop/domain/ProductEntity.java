package com.piisw.computershop.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, scale = 2)
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
	private CategoryEntity category;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id")
	private Image image;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productEntity")
	private List<ProductAttrEntity> productAttrEntities;

	@Lob
	private String description;
}
