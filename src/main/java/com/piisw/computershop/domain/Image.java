package com.piisw.computershop.domain;

import lombok.*;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;
import org.springframework.content.commons.annotations.MimeType;

import javax.persistence.*;

@Entity
@Table(name = "IMAGES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_generator")
	@SequenceGenerator(name = "image_generator", sequenceName = "image_seq", allocationSize = 1)
	private Long id;

	@ContentId
	@Column(length = 50, name = "content_id", nullable = false)
	private String contentId;

	@ContentLength
	@Column(length = 30, name = "content_length", nullable = false)
	private long contentLength;

	@MimeType
	@Column(length = 50, name = "mime_type", nullable = false)
	private String mimeType;
}
