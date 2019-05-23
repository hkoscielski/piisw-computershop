package com.piisw.computershop.repository;

import com.piisw.computershop.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "images", collectionResourceRel = "images")
public interface ImageRepository extends JpaRepository<Image, Long> {
}
