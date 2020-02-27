package test;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperDto {

    MapperDto MAPPER = Mappers.getMapper(MapperDto.class);

    Dto2 map(Dto dto);
}
