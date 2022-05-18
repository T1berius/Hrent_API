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
    public List<AnnounceDTO> getAnnouncesByDateAndCapacity(String title,Date startDate,Date endDate,Integer capacity) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleAndDateAndCapacity(title,startDate, endDate,capacity));
    }

    public List<AnnounceDTO> findAnnouncesByDateAndCityAndCapacity(String title, Date startDate, Date endDate, String city, Integer capacity) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndDateAndCapacityAndCity(title,startDate, endDate,capacity, city));
    }

    public List<AnnounceDTO> findAnnouncesByDateAndCityAndCapacityAndPrice(String title, Date startDate, Date endDate, String city, Integer capacity, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleLikeAndDateAndCapacityAndPriceAndCity(title,startDate, endDate,price, city, capacity));
    }

    public List<AnnounceDTO> findWithoutTitleByDate(Date startDate, Date endDate) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByDate(startDate, endDate));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacity(Integer capacity) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacity(capacity));
    }

    public List<AnnounceDTO> findWithoutTitleByPrice(Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByPriceOrLess(price));
    }

    public List<AnnounceDTO> findWithoutTitleByPostalCode(String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByPostalCode(postalCode));
    }

    public List<AnnounceDTO> findWithoutTitleByCity(String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCity(city));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndPrice(Integer capacity, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndPrice(capacity, price));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndPostalCode(Integer capacity, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndPostalCode(capacity, postalCode));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndDate(Integer capacity, Date startDate, Date endDate) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndDate(capacity, startDate, endDate));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndCity(Integer capacity, String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndCity(capacity, city));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndDateAndPostalCode(Integer capacity, Date startDate, Date endDate, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndDateAndPostalCode(capacity, startDate, endDate, postalCode));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndPriceAndPostalCode(Integer capacity, Double price, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndPriceAndPostalCode(capacity, price, postalCode));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndPriceAndCity(Integer capacity, Double price, String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndPriceAndCity(capacity, price, city));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndCityAndPostalCode(Integer capacity, String city, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndCityAndPostalCode(capacity, city, postalCode));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndDateAndCity(Integer capacity, Date startDate, Date endDate, String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndDateAndCity(capacity, startDate, endDate, city));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndDateAndPriceAndCity(Integer capacity, Date startDate, Date endDate, Double price, String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndDateAndPriceAndCity(capacity, price, city, startDate, endDate));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndPriceAndPostalCodeAndDate(Integer capacity, Double price, String postalCode, Date startDate, Date endDate) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndPriceAndPostalCodeAndDate(capacity, price, postalCode, startDate, endDate));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndDateAndPrice(Integer capacity, Date startDate, Date endDate, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndDateAndPrice(capacity, startDate, endDate, price));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndCityAndPrice(Integer capacity, String city, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndPriceAndCity(capacity, price, city));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndDateAndPriceAndPostalCode(Integer capacity, Date startDate, Date endDate, Double price, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndPriceAndPostalCodeAndDate(capacity, price, postalCode, startDate, endDate));
    }

    public List<AnnounceDTO> findWithoutTitleByCapacityAndDateAndPriceAndCityAndPostalCode(Integer capacity, Date startDate, Date endDate, Double price, String city, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByCapacityAndPriceAndPostalCodeAndDateAndCity(capacity, price,postalCode, startDate, endDate, city));
    }

    public List<AnnounceDTO> findWithoutTitleByDateAndPriceAndPostalCode(Date startDate, Date endDate, Double price, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByPriceAndPostalCodeAndDate(price, postalCode, startDate, endDate));
    }

    public List<AnnounceDTO> findWithoutTitleByDateAndPrice(Date startDate, Date endDate, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByPriceAndDate(price, startDate, endDate));
    }

    public List<AnnounceDTO> findAnnouncesByDateAndPrice(String title, Date startDate, Date endDate, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByTitleAndPriceAndDate(title, price, startDate, endDate));
    }

    public List<AnnounceDTO> findWithoutTitleByDateAndCity(Date startDate, Date endDate, String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByDateAndCity(startDate, endDate, city));
    }

    public List<AnnounceDTO> findWithoutTitleByDateAndPostalCode(Date startDate, Date endDate, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findByDateAndPostalCode(startDate, endDate, postalCode));
    }

    public List<AnnounceDTO> findWithoutTitleByPriceAndCity(Double price, String city) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findWithoutTitleByPriceAndCity(price, city));
    }

    public List<AnnounceDTO> findWithoutTitleByPriceAndPostalCode(Double price, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findWithoutTitleByPriceAndPostalCode(price, postalCode));
    }

    public List<AnnounceDTO> findWithoutTitleByCityAndPostalCode(String city, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findWithoutTitleByCityAndPostalCode(city, postalCode));
    }

    public List<AnnounceDTO> findWithoutTitleByPriceAndCityAndDate(Double price, String city, Date startDate, Date endDate) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findWithoutTitleByPriceAndCityAndDate(price, city, startDate, endDate));
    }

    public List<AnnounceDTO> findWithoutTitleByPriceAndCityAndPostalCode(Double price, String city, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findWithoutTitleByPriceAndCityAndPostalCode(price, city, postalCode));
    }

    public List<AnnounceDTO> findWithoutTitleByPriceAndCityAndDateAndPostalCode(Double price, String city, Date startDate, Date endDate, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findWithoutTitleByPriceAndCityAndDateAndPostalCode(price, city, postalCode, startDate, endDate));
    }

    public List<AnnounceDTO> findWithoutTitleByCityAndDateAndPostalCodeAndCapacity(String city, Date startDate, Date endDate, String postalCode, Integer capacity) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findWithoutTitleByCityAndDateAndPostalCodeAndCapacity(city, startDate, endDate, postalCode, capacity));
    }


    public List<AnnounceDTO> findWithoutTitleByPriceAndCityAndCapacityAndPostalCode(Double price, String city, Integer capacity, String postalCode) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findWithoutTitleByPriceAndCityAndCapacityAndPostalCode(price, city, capacity, postalCode));
    }

    public List<AnnounceDTO> findAnnouncesByDateAndCapacityAndPrice(String title, Date startDate, Date endDate, Integer capacity, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAnnouncesByDateAndCapacityAndPrice(title, startDate, endDate, capacity, price));
    }

    public List<AnnounceDTO> findAnnouncesByDateAndPostalCodeAndCapacity(String title, Date startDate, Date endDate, String postalCode, Integer capacity) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAnnouncesByDateAndPostalCodeAndCapacity(title, startDate, endDate, postalCode, capacity));
    }

    public List<AnnounceDTO> findAnnouncesByDateAndCityAndPrice(String title, Date startDate, Date endDate, String city, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAnnouncesByDateAndCityAndPrice(title,startDate, endDate, city, price));
    }

    public List<AnnounceDTO> findAnnouncesByDateAndPostalCodeAndPrice(String title, Date startDate, Date endDate, String postalCode, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAnnouncesByDateAndPostalCodeAndPrice(title, startDate, endDate, postalCode, price));
    }

    public List<AnnounceDTO> findAnnouncesByCityAndCapacityAndPrice(String title, String city, Integer capacity, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAnnouncesByCityAndCapacityAndPrice(title, city, capacity, price));
    }

    public List<AnnounceDTO> findAnnouncesByPostalCodeAndCapacityAndPrice(String title, String postalCode, Integer capacity, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAnnouncesByPostalCodeAndCapacityAndPrice(title, postalCode, capacity, price));
    }

    public List<AnnounceDTO> findAnnouncesByPostalCodeAndCityAndCapacity(String title, String postalCode, String city, Integer capacity) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAnnouncesByPostalCodeAndCityAndCapacity(title, postalCode, city, capacity));
    }

    public List<AnnounceDTO> findAnnouncesByPostalCodeAndCityAndPrice(String title, String postalCode, String city, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAnnouncesByPostalCodeAndCityAndPrice(title, postalCode, city, price));
    }

    public List<AnnounceDTO> findAnnouncesByPostalCodeAndCityAndDateAndPrice(String title, String postalCode, String city, Date startDate, Date endDate, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAnnouncesByPostalCodeAndCityAndDateAndPrice(title, postalCode, city, startDate, endDate, price));
    }

    public List<AnnounceDTO> findAnnouncesByPostalCodeAndCityAndCapacityAndPrice(String title, String postalCode, String city, Integer capacity, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAnnouncesByPostalCodeAndCityAndCapacityAndPrice(title, postalCode, city, capacity, price));
    }

    public List<AnnounceDTO> findAnnouncesByPostalCodeAndCityAndDateAndCapacityAndPrice(String title, String postalCode, String city, Date startDate, Date endDate, Integer capacity, Double price) {
        return this.converter.listEntityToListDto(((AnnounceRepository)this.repository).findAnnouncesByPostalCodeAndCityAndDateAndCapacityAndPrice(title, postalCode, city, startDate, endDate, capacity, price));
    }
}
