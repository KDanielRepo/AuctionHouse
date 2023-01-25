package pl.zsbd.kucd.interfaces;

import org.mapstruct.Mapper;
import pl.zsbd.kucd.abstracts.AbstractDTO;
import pl.zsbd.kucd.abstracts.AbstractEntity;
import pl.zsbd.kucd.config.BaseMapperConfig;

import java.util.List;

public interface BaseMapper<T extends AbstractEntity, T2 extends AbstractDTO> {
    T2 toDTO(T entity);
    T toEntity(T2 dto);
    List<T2> toDTOs(List<T> entities);
    List<T> toEntities(List<T2> dtos);
}
