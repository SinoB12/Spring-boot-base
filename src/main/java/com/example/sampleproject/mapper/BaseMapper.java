package com.example.sampleproject.mapper;

import java.util.List;

public interface BaseMapper <E,D>{

    E toEntity(D dto);

    D toDTO(E entity);

    List<E> toListEntity(List<D> listDTO);

    List<D> toListDTO(List<E> listEntity);
}
