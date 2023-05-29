package me.alekseinovikov;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapstructMapper {
    MapstructMapper INSTANCE = Mappers.getMapper(MapstructMapper.class);
    Dto map(Entity entity);
}
