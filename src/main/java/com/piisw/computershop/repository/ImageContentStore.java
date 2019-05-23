package com.piisw.computershop.repository;

import com.piisw.computershop.domain.Image;
import org.springframework.content.commons.repository.ContentStore;

public interface ImageContentStore extends ContentStore<Image, String> {
}
