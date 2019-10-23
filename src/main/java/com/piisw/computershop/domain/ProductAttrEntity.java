package com.piisw.computershop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(
		name = "PRODUCTS_ATTR",
		uniqueConstraints = @UniqueConstraint(columnNames = {"name", "value", "product_id"})
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ProductAttrEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(length = 50, nullable = false)
	private String code;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(nullable = false)
	private String value;

	@Column(length = 1, name = "is_main", nullable = false)
	private Boolean isMain;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private ProductEntity productEntity;
}
