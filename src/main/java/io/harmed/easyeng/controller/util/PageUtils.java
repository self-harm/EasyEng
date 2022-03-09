package io.harmed.easyeng.controller.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageUtils {

    public static <D> Page<D> getPage(final List<D> DTOs, final Pageable pageable) {
        return new PageImpl<>(DTOs, pageable, DTOs.size());
    }
}