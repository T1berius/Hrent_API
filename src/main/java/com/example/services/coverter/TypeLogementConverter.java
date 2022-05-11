package com.example.services.coverter;

import com.example.model.TypeLogement;
import com.example.services.dto.TypeLogementDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TypeLogementConverter implements EntityDtoConverter<TypeLogement, TypeLogementDTO>{
    @Override
    public TypeLogement dtoToEntity(TypeLogementDTO typeLogementDTO) {
        return new TypeLogement(typeLogementDTO.getId(), typeLogementDTO.getLibelle());
    }

    @Override
    public TypeLogementDTO entityToDto(TypeLogement typeLogement) {
        TypeLogementDTO typeLogementDTO = new TypeLogementDTO();
        BeanUtils.copyProperties(typeLogement, typeLogementDTO);
        return typeLogementDTO;
    }

    @Override
    public List<TypeLogementDTO> listEntityToListDto(List<TypeLogement> typeLogements) {
        List<TypeLogementDTO> typeLogementDTOS = new ArrayList<>();
        for (TypeLogement typeLogement : typeLogements) {
            typeLogementDTOS.add(entityToDto(typeLogement));
        }
        return typeLogementDTOS;
    }

    @Override
    public List<TypeLogement> listDtoToListEntity(List<TypeLogementDTO> typeLogementDTOS) {
        List<TypeLogement> typeLogements = new ArrayList<>();
        for (TypeLogementDTO typeLogementDTO : typeLogementDTOS) {
            typeLogements.add(dtoToEntity(typeLogementDTO));
        }
        return typeLogements;
    }
}
