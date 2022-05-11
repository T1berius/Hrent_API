package com.example.services.coverter;

import com.example.model.Announce;
import com.example.services.dto.AnnounceDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;

@Component
public class AnnounceConverter implements EntityDtoConverter<Announce, AnnounceDTO> {
    @Override
    public Announce dtoToEntity(AnnounceDTO announceDTO) {
        return new Announce(announceDTO.getId(), announceDTO.getTitle(), announceDTO.getDescription(), announceDTO.getPostalCode(), announceDTO.getCity(), announceDTO.getPrice(),announceDTO.getCaution(), announceDTO.getCapacity(),announceDTO.getStartDate(),announceDTO.getEndDate(),announceDTO.getIdTypeLogement(),announceDTO.getIsIdCardRequired(),announceDTO.getIsSmokingAllowed(),announceDTO.getIsPetsAllowed(),announceDTO.getIsPassportRequired(),announceDTO.getIsProofOfAddressRequired(),announceDTO.getArrivalTime(),announceDTO.getDepartureTime(),announceDTO.getTelephoneNumber(),announceDTO.getCreatedDate(),announceDTO.getLocationPrimaryPicture(),announceDTO.getLocationSecondaryPicture(),announceDTO.getLocationThirdPicture(),announceDTO.getLocationFourthPicture(),announceDTO.getLocationFifthPicture(), announceDTO.getIdUser());
    }

    @Override
    public AnnounceDTO entityToDto(Announce announce) {
        AnnounceDTO announceDTO = new AnnounceDTO();
        BeanUtils.copyProperties(announce, announceDTO);
        return announceDTO;
    }

    @Override
    public List<AnnounceDTO> listEntityToListDto(List<Announce> announces) {
        List<AnnounceDTO> announceDTOS = new ArrayList<>();
        for (Announce announce : announces) {
            announceDTOS.add(entityToDto(announce));
        }
        return announceDTOS;
    }

    @Override
    public List<Announce> listDtoToListEntity(List<AnnounceDTO> announceDTOS) {
        List<Announce> announces = new ArrayList<>();
        for (AnnounceDTO announceDTO : announceDTOS) {
            announces.add(dtoToEntity(announceDTO));
        }
        return announces;
    }
}
