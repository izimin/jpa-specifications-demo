package ru.izimin.jpaspecificationsdemo.rest.mapper.common;

import org.springframework.data.domain.Page;
import ru.izimin.jpaspecificationsdemo.rest.dto.common.PageDto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Базовый интерфейс для мапперов, содержит методы для преобразования Entity в DTO и DTO в Entity
 *
 * @param <E> тип Entity
 * @param <D> тип DTO
 */
public interface WebMapper<E, D> {

    E toEntity(D dto);

    D toDto(E e);

    List<D> toDto(Collection<E> es);

    default PageDto<D> toPageDto(Page<E> page) {
        PageDto<D> pageDto = new PageDto<>();

        final List<D> dtoContent = toDto(page.getContent());

        pageDto.setContent(dtoContent == null ? Collections.emptyList() : dtoContent);

        pageDto.setTotalPages(page.getTotalPages());
        pageDto.setTotalElements(page.getTotalElements());
        pageDto.setHasNext(page.hasNext());
        pageDto.setHasPrevious(page.hasPrevious());
        pageDto.setCurrentPage(page.getNumber());
        pageDto.setSize(page.getSize());
        pageDto.setNumberOfElements(page.getNumberOfElements());

        return pageDto;
    }
}