package com.example.services;

import com.example.model.Announce;
import com.example.repository.AnnounceRepository;
import com.example.services.coverter.AnnounceConverter;
import com.example.services.coverter.EntityDtoConverter;
import com.example.services.dto.AnnounceDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AnnounceService extends GenericCrudService<Announce,AnnounceDTO,Integer> {
    public AnnounceService(AnnounceRepository repository, AnnounceConverter converter) {
        super(repository, converter);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AnnounceDTO update(AnnounceDTO announceDTO, Integer id) {
        Announce announce = this.repository.getById(id);
        if(Objects.equals(announce.getId(),id)) {
            announce = this.converter.dtoToEntity(announceDTO);
            announce = this.repository.save(announce);
            return this.converter.entityToDto(announce);
        }
        return null;
    }

    public List<AnnounceDTO> findAnnounces() {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAll());
    }
    public List<AnnounceDTO> findAnnouncesByStartAndEndDate(String title,Date startDate, Date endDate) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndDate(title,startDate, endDate));
    }
    public List<AnnounceDTO> findAnnouncesByTitle(String title) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLike(title));
    }
    public List<AnnounceDTO> findAnnouncesByCapacity(String title,Integer capacity) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndCapacity(title,capacity));
    }
    public List<AnnounceDTO> findAnnouncesByPostalCode(String title, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndPostalCode(title,postalCode));
    }
    public List<AnnounceDTO> findAnnouncesByCity(String title, String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndCity(title,city));
    }
    public List<AnnounceDTO> findAnnouncesByDateAndCapacity(String title,Date startDate, Date endDate,Integer capacity) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndDateAndCapacity(title,startDate, endDate,capacity));
    }
    public List<AnnounceDTO> findAnnouncesByDateAndPostalCode(String title,Date startDate, Date endDate,String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndPostalCodeAndDate(title,postalCode, startDate,endDate));
    }
    public List<AnnounceDTO> findAnnouncesByDateAndCity(String title,Date startDate, Date endDate,String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndCityAndDate(title,city, startDate,endDate));
    }
    public List<AnnounceDTO> findAnnouncesByDateAndCapacityAndPostalCode(String title,Date startDate, Date endDate,Integer capacity,String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndCapacityAndDateAndPostalCode(title,capacity, startDate,endDate,postalCode));
    }
    public List<AnnounceDTO> findAnnouncesByCapacityAndPostalCode(String title, Integer capacity, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndCapacityAndPostalCode(title,capacity, postalCode));
    }

    public List<AnnounceDTO> findAnnouncesByCapacityAndCity(String title, Integer capacity, String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndCapacityAndCity(title,capacity, city));
    }

    public List<AnnounceDTO> findAnnouncesByDateAndPostalCodeAndCity(String title, Date startDate, Date endDate, String postalCode, String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByDateAndPostalCodeAndCity(title,startDate, endDate,postalCode, city));
    }

    public List<AnnounceDTO> findAnnouncesByPostalCodeAndCity(String title, String postalCode, String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndPostalCodeAndCity(title,postalCode, city));
    }

    public List<AnnounceDTO> findAnnouncesByCapacityAndPrice(String title, Integer capacity, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndCapacityAndPrice(title,capacity, price));
    }

    public List<AnnounceDTO> findAnnouncesByPrice(String title, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndPrice(title,price));
    }

    public List<AnnounceDTO> findAnnouncesByPriceAndPostalCode(String title, Double price, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByPriceAndPostalCode(title,price, postalCode));
    }

    public List<AnnounceDTO> findAnnouncesByPriceAndCity(String title, Double price, String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByPriceAndCity(title,price, city));
    }

    public List<AnnounceDTO> findAnnouncesByDateAndPostalCodeAndCityAndCapacity(String title, Date startDate, Date endDate, String postalCode, String city, Integer capacity) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByDateAndCapacityAndPostalCodeAndCity(title,startDate, endDate,capacity, postalCode,city));
    }

    public List<AnnounceDTO> findAnnouncesByDateAndPostalCodeAndCapacityAndPrice(String title, Date parse, Date parse1, String postalCode, Integer capacity, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByDateAndCapacityAndPriceAndPostalCode(title,parse, parse1,capacity, price, postalCode));
    }

    public List<AnnounceDTO> getAnnouncesByCity(String title,String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleAndCity(title,city));
    }
}
