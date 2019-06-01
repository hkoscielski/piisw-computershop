package com.piisw.computershop.repository;

import com.piisw.computershop.domain.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	Page<ProductEntity> findAllByCategoryId(Long categoryId, Pageable pageable);
}
