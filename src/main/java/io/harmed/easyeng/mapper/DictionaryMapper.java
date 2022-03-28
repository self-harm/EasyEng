package io.harmed.easyeng.mapper;

import io.harmed.easyeng.dto.DictionaryDTO;
import io.harmed.easyeng.model.Dictionary;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserMapper.class})
public interface DictionaryMapper extends EntityMapper<DictionaryDTO, Dictionary> {

    @Mapping(source = "userId", target = "user")
    @Override
    Dictionary toEntity(final DictionaryDTO dto);

    @Mapping(source = "user", target = "userId")
    @Override
    DictionaryDTO toDto(final Dictionary entity);
}