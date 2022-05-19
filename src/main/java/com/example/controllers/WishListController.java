package com.example.controllers;

import com.example.services.AnnounceService;
import com.example.services.UserService;
import com.example.services.WishListService;
import com.example.services.coverter.WishListConverter;
import com.example.services.dto.WishListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class WishListController {
    @Autowired
    private WishListService wishListService;

    @Autowired
    private WishListConverter wishListConverter;

    @Autowired
    private AnnounceService announceService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/wishlists", method = RequestMethod.GET)
    public List<WishListDTO> getWishLists() {
        return wishListService.getWishLists();
    }

    @RequestMapping(value = "/api/wishlist/{id}", method = RequestMethod.GET)
    public WishListDTO getWishList(@PathVariable("id") Integer id) {
        return wishListService.getWishList(id);
    }

    @RequestMapping(value = "/api/wishlist/create", method = RequestMethod.POST)
    public String addWishList(@Param("announceId") Integer announceId, @Param("userId") Integer userId) {
        if(announceId == null || userId == null) {
            //return HttpStatus.BAD_REQUEST;
        }
        WishListDTO wishListDTO = new WishListDTO();
        wishListDTO.setAnnounceId(announceId);
        wishListDTO.setUserId(userId);
        wishListService.create(wishListDTO);
        //return HttpStatus.OK;
        return "OK";
    }

    @RequestMapping(value = "/api/wishlist/delete/{id}", method = RequestMethod.DELETE)
    public void deleteWishList(@PathVariable("id") Integer id) {
        wishListService.deleteWishList(id);
    }
}
