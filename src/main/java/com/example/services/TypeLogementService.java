package com.example.services;

import com.example.model.TypeLogement;
import com.example.repository.TypeLogementRepository;
import com.example.services.coverter.TypeLogementConverter;
import com.example.services.dto.TypeLogementDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class TypeLogementService extends GenericCrudService<TypeLogement, TypeLogementDTO,Integer> {
    public TypeLogementService(TypeLogementRepository repository, TypeLogementConverter converter) {
        super(repository, converter);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TypeLogementDTO update(TypeLogementDTO dto,Integer id) {
        TypeLogement typeLogement = repository.getById(id);
        if (Objects.equals(typeLogement.getId(), id)) {
            typeLogement = this.converter.dtoToEntity(dto);
            typeLogement = this.repository.save(typeLogement);
            return this.converter.entityToDto(typeLogement);
        }
        return null;
    }
}
