package com.allianz.example.util;

import com.allianz.example.model.requestDTO.PageDTO;
import com.allianz.example.util.dbutil.BaseEntity;
import jakarta.persistence.MappedSuperclass;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@MappedSuperclass
public interface IBaseMapper<DTO extends BaseDTO, Entity extends BaseEntity, RequestDTO extends BaseDTO> {

    DTO entityToDTO(Entity entity);

    Entity dtoToEntity(DTO dto);

    List<DTO> entityListToDTOList(List<Entity> entityList);

    List<Entity> dtoListTOEntityList(List<DTO> dtoList);

    Entity requestDTOToEntity(RequestDTO requestDTO);

    List<Entity> requestDtoListTOEntityList(List<RequestDTO> dtoList);

    @Mapping(source = "id", target = "id")
    Entity requestDtoToExistEntity(@MappingTarget Entity entity, RequestDTO requestDTO);

    PageDTO<DTO> pageEntityToPageDTO(Page<Entity> entityPage);


}
