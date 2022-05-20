package com.example.services;

import com.example.model.WishList;
import com.example.repository.WishListRepository;
import com.example.services.coverter.EntityDtoConverter;
import com.example.services.coverter.WishListConverter;
import com.example.services.dto.WishListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class WishListService extends GenericCrudService<WishList, WishListDTO,Integer> {

    public WishListService(WishListRepository repository, WishListConverter converter) {
        super(repository, converter);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    WishListDTO update(WishListDTO wishListDTO, Integer id) {
        WishList wishList = this.repository.getById(id);
        if(Objects.equals(wishList.getId(),id)) {
            wishList = this.converter.dtoToEntity(wishListDTO);
            wishList = this.repository.save(wishList);
            return this.converter.entityToDto(wishList);
        }
        return null;
    }

    public List<WishListDTO> getWishLists() {
        return converter.listEntityToListDto(((WishListRepository) this.repository).findAll());
    }

    public WishListDTO getWishList(Integer id) {
        return converter.entityToDto(this.repository.getById(id));
    }

    public void deleteWishList(Integer id) {
        this.repository.deleteById(id);
    }

    public List<WishListDTO> getWishListsByUserId(Integer id) {
        return converter.listEntityToListDto(((WishListRepository) this.repository).findByUserId(id));
    }

    public Integer getLastInsertedId() {
        //return ((WishListRepository) this.repository).getLastId();
        return 1;
    }
}
