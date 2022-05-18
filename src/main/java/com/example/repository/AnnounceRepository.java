package com.example.repository;

import com.example.model.Announce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AnnounceRepository extends JpaRepository<Announce,Integer> {
    List<Announce> findByTitle(String title);

    @Query(value = "FROM Announce")
    List<Announce> findAll();

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%')")
    List<Announce> findByTitleLike(@Param("title") String title);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findByTitleLikeAndDate(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.capacity >= :capacity")
    List<Announce> findByTitleLikeAndCapacity(@Param("title") String title, @Param("capacity") Integer capacity);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.postalCode = :postalCode")
    List<Announce> findByTitleLikeAndPostalCode(@Param("title") String title, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.city = :city")
    List<Announce> findByTitleLikeAndCity(@Param("title") String title, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.price <= :price")
    List<Announce> findByTitleLikeAndPrice(@Param("title") String title, @Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.capacity >= :capacity AND a.price <= :price")
    List<Announce> findByTitleLikeAndCapacityAndPrice(@Param("title") String title, @Param("capacity") Integer capacity, @Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.price <= :price")
    List<Announce> findByTitleLikeAndDateAndPrice(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.price <= :price AND a.price <= :price AND a.postalCode = :postalCode")
    List<Announce> findByTitleLikeAndDateAndPriceAndPostalCode(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("price") Double price, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.price <= :price AND a.price <= :price AND a.postalCode = :postalCode AND a.capacity >= :capacity")
    List<Announce> findByTitleLikeAndDateAndPriceAndPostalCodeAndCapacity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("price") Double price, @Param("postalCode") String postalCode, @Param("capacity") Integer capacity);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.price <= :price AND a.price <= :price AND a.city = :city AND a.capacity >= :capacity")
    List<Announce> findByTitleLikeAndDateAndPriceAndCityAndCapacity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("price") Double price, @Param("city") String city, @Param("capacity") Integer capacity);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.price <= :price AND a.price <= :price AND a.capacity >= :capacity")
    List<Announce> findByTitleLikeAndDateAndPriceAndCapacity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("price") Double price, @Param("capacity") Integer capacity);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.capacity >= :capacity")
    List<Announce> findByTitleLikeAndDateAndCapacity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("capacity") Integer capacity);

    @Query(value = "FROM Announce  a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.capacity >= :capacity AND a.city = :city")
    List<Announce> findByTitleLikeAndDateAndCapacityAndCity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("capacity") Integer capacity, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.price <= :price AND a.price <= :price AND a.city = :city")
    List<Announce> findByTitleLikeAndDateAndPriceAndCity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("price") Double price, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.capacity >= :capacity AND a.postalCode = :postalCode")
    List<Announce> findByTitleLikeAndCapacityAndPostalCode(@Param("title") String title, @Param("capacity") Integer capacity, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.postalCode = :postalCode AND a.price <= :price")
    List<Announce> findByTitleLikeAndPostalCodeAndPrice(@Param("title") String title, @Param("postalCode") String postalCode, @Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.postalCode = :postalCode AND a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findByTitleLikeAndPostalCodeAndDate(@Param("title") String title, @Param("postalCode") String postalCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.city = :city AND a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findByTitleLikeAndCityAndDate(@Param("title") String title, @Param("city") String city, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.capacity >= :capacity AND :startDate <= a.startDate AND :endDate <= a.endDate AND postalCode = :postalCode")
    List<Announce> findByTitleLikeAndCapacityAndDateAndPostalCode(@Param("title") String title, @Param("capacity") Integer capacity, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.capacity >= :capacity AND a.postalCode = :postalCode")
    List<Announce> findAnnouncesByCapacityAndPostalCode(@Param("title") String title, @Param("capacity") Integer capacity, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.capacity >= :capacity AND a.city = :city")
    List<Announce> findByTitleLikeAndCapacityAndCity(@Param("title") String title, @Param("capacity") Integer capacity, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.postalCode = :postCode AND a.city = :city")
    List<Announce> findByDateAndPostalCodeAndCity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("postCode") String postCode, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.postalCode = :postalCode AND a.city = :city")
    List<Announce> findByTitleLikeAndPostalCodeAndCity(@Param("title") String title, @Param("postalCode") String postalCode, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.price <= :price AND a.postalCode = :postalCode")
    List<Announce> findByPriceAndPostalCode(@Param("title") String title, @Param("price") Double price, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.price <= :price AND a.city = :city")
    List<Announce> findByPriceAndCity(@Param("title") String title, @Param("price") Double price, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.capacity >= :capacity AND a.postalCode = :postalCode AND a.city = :city")
    List<Announce> findByDateAndCapacityAndPostalCodeAndCity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("capacity") Integer capacity, @Param("postalCode") String postalCode, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.price <= :price AND a.city = :city AND a.postalCode = :postalCode")
    List<Announce> findByDateAndPriceAndCityAndPostalCode(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("price") Double price, @Param("city") String city, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.price <= :price AND a.postalCode = :postalCode AND capacity >= :capacity AND city = :city")
    List<Announce> findByDateAndPriceAndPostalCodeAndCapacityAndCity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("price") Double price, @Param("postalCode") String postalCode, @Param("capacity") Integer capacity, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.capacity >= :capacity AND a.price <= :price AND a.postalCode = :postalCode")
    List<Announce> findByDateAndCapacityAndPriceAndPostalCode(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("capacity") Integer capacity, @Param("price") Double price, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.city = :city")
    List<Announce> findByTitleAndCity(@Param("title") String title, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.postalCode = :postalCode")
    List<Announce> findByTitleAndPostalCode(@Param("title") String title, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.price <= :price")
    List<Announce> findByTitleAndPrice(@Param("title") String title, @Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND capacity >= :capacity")
    List<Announce> findByTitleAndDateAndCapacity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("capacity") Integer capacity);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND capacity >= :capacity AND city = :city")
    List<Announce> findByTitleAndDateAndCapacityAndCity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("capacity") Integer capacity, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND price <= :price")
    List<Announce> findByTitleAndDateAndPrice(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("price") Double price);


    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND price <= :price AND city = :city AND capacity >= :capacity")
    List<Announce> findByTitleLikeAndDateAndCapacityAndPriceAndCity(@Param("title") String title, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("price") Double price, @Param("city") String city, @Param("capacity") Integer capacity);

    @Query(value = "FROM Announce a WHERE city = :city")
    List<Announce> findByCity(@Param("city") String city);

    @Query(value = "FROM Announce a WHERE postalCode = :postalCode")
    List<Announce> findByPostalCode(@Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE a.price <= :price")
    List<Announce> findByPriceOrLess(@Param("price") Double price);

    @Query(value = "FROM Announce a WHERE capacity >= :capacity")
    List<Announce> findByCapacity(@Param("capacity") Integer capacity);

    @Query(value = "FROM Announce a WHERE a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.price <= :price")
    List<Announce> findByCapacityAndPrice(@Param("capacity") Integer capacity, @Param("price") Double price);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.postalCode = :postalCode")
    List<Announce> findByCapacityAndPostalCode(@Param("capacity") Integer capacity, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.city = :city")
    List<Announce> findByCapacityAndCity(@Param("capacity") Integer capacity, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findByCapacityAndDate(@Param("capacity") Integer capacity, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.postalCode = :postalCode")
    List<Announce> findByCapacityAndDateAndPostalCode(@Param("capacity") Integer capacity, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.price <= :price AND a.postalCode = :postalCode")
    List<Announce> findByCapacityAndPriceAndPostalCode(@Param("capacity") Integer capacity, @Param("price") Double price, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.price <= :price AND a.city = :city")
    List<Announce> findByCapacityAndPriceAndCity(@Param("capacity") Integer capacity, @Param("price") Double price, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND :city = a.city AND a.postalCode = :postalCode")
    List<Announce> findByCapacityAndCityAndPostalCode(@Param("capacity") Integer capacity, @Param("city") String city, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.endDate >= :endDate AND a.startDate <= :startDate AND a.city = :city")
    List<Announce> findByCapacityAndDateAndCity(@Param("capacity") Integer capacity, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.price <= :price AND a.city = :city AND a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findByCapacityAndDateAndPriceAndCity(@Param("capacity") Integer capacity, @Param("price") Double price, @Param("city") String city, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.price <= :price AND a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findByCapacityAndDateAndPrice(@Param("capacity") Integer capacity, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("price") Double price);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.price <= :price AND a.postalCode = :postalCode AND a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findByCapacityAndPriceAndPostalCodeAndDate(@Param("capacity") Integer capacity, @Param("price") Double price, @Param("postalCode") String postalCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "FROM Announce a WHERE a.capacity >= :capacity AND a.price <= :price AND a.postalCode = :postalCode AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.city = :city")
    List<Announce> findByCapacityAndPriceAndPostalCodeAndDateAndCity(@Param("capacity") Integer capacity, @Param("price") Double price, @Param("postalCode") String postalCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE a.price <= :price AND a.postalCode = :postalCode AND a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findByPriceAndPostalCodeAndDate(@Param("price") Double price, @Param("postalCode") String postalCode, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "FROM Announce a WHERE a.price <= :price AND a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findByPriceAndDate(@Param("price") Double price, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.price <= :price AND a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findByTitleAndPriceAndDate(@Param("title") String title, @Param("price") Double price, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query(value = "FROM Announce a WHERE a.startDate <= :startDate AND a.endDate >= :endDate AND a.city = :city")
    List<Announce> findByDateAndCity(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE a.startDate <= :startDate AND a.endDate >= :endDate AND a.postalCode = :postalCode")
    List<Announce> findByDateAndPostalCode(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE a.price <= :price AND a.city = :city")
    List<Announce> findWithoutTitleByPriceAndCity(@Param("price") Double price, @Param("city") String city);

    @Query(value = "FROM Announce a WHERE a.price <= :price AND a.postalCode = :postalCode")
    List<Announce> findWithoutTitleByPriceAndPostalCode(@Param("price") Double price, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE a.city = :city AND a.postalCode = :postalCode")
    List<Announce> findWithoutTitleByCityAndPostalCode(@Param("city") String city, @Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE a.price <= :price AND a.city = :city AND a.startDate <= :startDate AND a.endDate >= :endDate")
    List<Announce> findWithoutTitleByPriceAndCityAndDate(@Param("price") Double price,@Param("city") String city,@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    @Query(value = "FROM Announce a WHERE a.price <= :price AND a.city = :city AND a.postalCode = :postalCode")
    List<Announce> findWithoutTitleByPriceAndCityAndPostalCode(@Param("price") Double price,@Param("city") String city,@Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE a.price <= :price AND a.city = :city AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.postalCode = :postalCode")
    List<Announce> findWithoutTitleByPriceAndCityAndDateAndPostalCode(@Param("price") Double price,@Param("city") String city,@Param("postalCode") String postalCode,@Param("startDate") Date startDate,@Param("endDate") Date endDate);

    @Query(value = "FROM Announce a WHERE a.city = :city AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.postalCode = :postalCode AND a.capacity >= :capacity")
    List<Announce> findWithoutTitleByCityAndDateAndPostalCodeAndCapacity(@Param("city") String city,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("postalCode") String postalCode,@Param("capacity") Integer capacity);

    @Query(value = "FROM Announce a WHERE a.price <= :price AND a.city = :city AND a.capacity >= :capacity AND a.postalCode = :postalCode")
    List<Announce> findWithoutTitleByPriceAndCityAndCapacityAndPostalCode(@Param("price") Double price,@Param("city") String city,@Param("capacity") Integer capacity,@Param("postalCode") String postalCode);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.capacity >= :capacity AND a.price <= :price")
    List<Announce> findAnnouncesByDateAndCapacityAndPrice(@Param("title") String title,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("capacity") Integer capacity,@Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.postalCode = :postalCode AND a.capacity >= :capacity")
    List<Announce> findAnnouncesByDateAndPostalCodeAndCapacity(@Param("title") String title,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("postalCode") String postalCode,@Param("capacity") Integer capacity);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.city = :city AND a.price <= :price")
    List<Announce> findAnnouncesByDateAndCityAndPrice(@Param("title") String title,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("city") String city,@Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.postalCode = :postalCode AND a.price <= :price")
    List<Announce> findAnnouncesByDateAndPostalCodeAndPrice(@Param("title") String title,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("postalCode") String postalCode,@Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.city = :city AND a.capacity >= :capacity AND a.price <= :price")
    List<Announce> findAnnouncesByCityAndCapacityAndPrice(@Param("title") String title,@Param("city") String city,@Param("capacity") Integer capacity,@Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.postalCode = :postalCode AND a.capacity >= :capacity AND a.price <= :price")
    List<Announce> findAnnouncesByPostalCodeAndCapacityAndPrice(@Param("title") String title,@Param("postalCode") String postalCode,@Param("capacity") Integer capacity,@Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.postalCode = :postalCode AND a.city = :city AND a.capacity >= :capacity")
    List<Announce> findAnnouncesByPostalCodeAndCityAndCapacity(@Param("title") String title,@Param("postalCode") String postalCode,@Param("city") String city,@Param("capacity") Integer capacity);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.postalCode = :postalCode AND a.city = :city AND a.price <= :price")
    List<Announce> findAnnouncesByPostalCodeAndCityAndPrice(@Param("title") String title,@Param("postalCode") String postalCode,@Param("city") String city,@Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.postalCode = :postalCode AND a.city = :city AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.price <= :price")
    List<Announce> findAnnouncesByPostalCodeAndCityAndDateAndPrice(@Param("title") String title,@Param("postalCode") String postalCode,@Param("city") String city,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.postalCode = :postalCode AND a.city = :city AND a.capacity >= :capacity AND a.price <= :price")
    List<Announce> findAnnouncesByPostalCodeAndCityAndCapacityAndPrice(@Param("title") String title,@Param("postalCode") String postalCode,@Param("city") String city,@Param("capacity") Integer capacity,@Param("price") Double price);

    @Query(value = "FROM Announce a WHERE title LIKE CONCAT('%',:title,'%') AND a.postalCode = :postalCode AND a.city = :city AND a.startDate <= :startDate AND a.endDate >= :endDate AND a.capacity >= :capacity AND a.price <= :price")
    List<Announce> findAnnouncesByPostalCodeAndCityAndDateAndCapacityAndPrice(@Param("title") String title,@Param("postalCode") String postalCode,@Param("city") String city,@Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("capacity") Integer capacity,@Param("price") Double price);
}
