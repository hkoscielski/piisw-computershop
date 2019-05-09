package com.piisw.computershop.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionModelMapper {

	@Autowired
	private ModelMapper modelMapper;

	public <D, S> List<D> mapAll(final Collection<S> sourceCollection, Class<D> sourceClass) {
		return sourceCollection.stream()
				.map(obj -> map(obj, sourceClass))
				.collect(Collectors.toList());
	}

	public <D, S> Page<D> mapPage(final Page<S> sourceCollection, Class<D> sourceClass) {
		return sourceCollection.map(obj -> map(obj, sourceClass));
	}

	public <D, S> D map(final S source, Class<D> sourceClass) {
		return modelMapper.map(source, sourceClass);
	}
}
