package com.piisw.computershop.repository;

import com.piisw.computershop.domain.Image;
import org.springframework.content.commons.repository.ContentStore;
import org.springframework.content.rest.StoreRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageContentStore extends ContentStore<Image, String> {
}
