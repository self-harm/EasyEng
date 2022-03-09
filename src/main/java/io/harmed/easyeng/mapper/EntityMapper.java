package io.harmed.easyeng.mapper;

import java.util.List;

public interface EntityMapper<D, E> {
    E toEntity(final D dto);

    D toDto(final E entity);

    List<E> toEntity(final List<D> dtoList);

    List<D> toDto(final List<E> entityList);
}