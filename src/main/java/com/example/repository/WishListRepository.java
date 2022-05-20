package com.example.repository;

import com.example.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Integer> {
    List<WishList> findAll();

    List<WishList> findByUserId(Integer id);

    //@Query(value = "FROM WishList w ORDER BY DESC LIMIT 1")
    //Integer getLastId();
}
