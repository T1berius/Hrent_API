package com.example.repository;

import com.example.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> getAcceptedReservationsByIdAnnounce(Integer idAnnounce);
    /*@Query("from Reservation r where r.idUser = :id")
    Reservation findByUserId(@Param("id") Integer id);

    @Query("Reservation r where r.idAnnounce = :id")
    Reservation findByAnnounceId(@Param("id") Integer id);*/

    List<Reservation> findByIdUser(Integer idUser);

    @Query("FROM Reservation r where r.acceptState != 1 AND r.idUser = :idUser")
    List<Reservation> findNotAcceptedByIdUser(@Param("idUser") Integer idUser);

    @Query("FROM Reservation r where r.acceptState != 2 AND r.idUser = :idUser")
    List<Reservation> findNotRefusedByIdUser(@Param("idUser") Integer idUser);

    @Query("FROM Reservation r where r.acceptState = 3 AND r.idUser = :idUser")
    List<Reservation> findAwaitingByIdUser(@Param("idUser") Integer idUser);
}
