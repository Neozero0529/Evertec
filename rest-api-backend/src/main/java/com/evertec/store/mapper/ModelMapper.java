package com.evertec.store.mapper;

public interface ModelMapper<DTO, Entity> {

	DTO mapper(Entity entity);
}
