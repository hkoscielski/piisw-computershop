package com.piisw.computershop.repository;

import com.piisw.computershop.domain.GraphicsCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicsCardRepository extends JpaRepository<GraphicsCardEntity, Long> {
}
