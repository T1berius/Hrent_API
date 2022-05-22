package com.example.controllers;

import com.example.model.Reservation;
import com.example.repository.AnnounceRepository;
import com.example.repository.ReservationRepository;
import com.example.repository.UserRepository;
import com.example.services.AnnounceService;
import com.example.services.ReservationService;
import com.example.services.UserService;
import com.example.services.coverter.ReservationConverter;
import com.example.services.dto.AnnounceDTO;
import com.example.services.dto.ReservationDTO;
import com.example.services.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AnnounceService announceService;
    @Autowired
    private AnnounceRepository announceRepository;

    @RequestMapping(value = "/api/reservations", method = RequestMethod.GET)
    public List<ReservationDTO> getReservations() {
        return reservationService.findAll();
    }

    @RequestMapping(value = "/api/reservation/{id}", method = RequestMethod.GET)
    public ReservationDTO getReservation(@PathVariable("id") Integer id) {
        return reservationService.findOneById(id);
    }

    @RequestMapping(value = "/api/reservation/delete/{id}", method = RequestMethod.DELETE)
    public void deleteReservation(@PathVariable("id") Integer id) {
        reservationService.deleteById(id);
    }

    @RequestMapping(value = "/api/reservation/create", method = RequestMethod.POST)
    public ReservationDTO createReservation(@Param("idUser") Integer idUser,
                                            @Param("idAnnounce") Integer idAnnounce,
                                            @Param("startDate") String startDate,
                                            @Param("endDate") String endDate) throws ParseException {
        if(idUser != null && idAnnounce != null && startDate != null && endDate != null) {
            if(!userRepository.findById(idUser).isEmpty() && !announceRepository.findById(idAnnounce).isEmpty()) {
                ReservationDTO reservationDTO = new ReservationDTO();
                reservationDTO.setIdUser(idUser);
                reservationDTO.setIdAnnounce(idAnnounce);
                reservationDTO.setStartDate(new SimpleDateFormat("dd-MM-yyyy").parse(startDate));
                reservationDTO.setEndDate(new SimpleDateFormat("dd-MM-yyyy").parse(endDate));
                reservationDTO.setAcceptState(3);
                reservationService.create(reservationDTO);
                return reservationDTO;
           }
        }
        return null;
    }
    @RequestMapping(value = "/api/reservation/update/{id}", method = RequestMethod.PUT)
    public ReservationDTO updateReservation(@PathVariable("id") Integer id,
                                            @Param("idUser") Integer idUser,
                                            @Param("idAnnounce") Integer idAnnounce,
                                            @Param("startDate") String startDate,
                                            @Param("endDate") String endDate,
                                            @Param("acceptState") Integer acceptState) throws ParseException {
        if(idUser != null && idAnnounce != null && startDate != null && endDate != null && acceptState != null) {
            if(!userRepository.findById(idUser).isEmpty() && !announceRepository.findById(idAnnounce).isEmpty()) {
                ReservationDTO reservationDTO = new ReservationDTO();
                reservationDTO.setId(id);
                reservationDTO.setIdUser(idUser);
                reservationDTO.setIdAnnounce(idAnnounce);
                reservationDTO.setStartDate(new SimpleDateFormat("dd-MM-yyyy").parse(startDate));
                reservationDTO.setEndDate(new SimpleDateFormat("dd-MM-yyyy").parse(endDate));
                reservationDTO.setAcceptState(acceptState);
                reservationService.update(reservationDTO,id);
                return reservationDTO;
            }
        }
        return null;
    }
    @RequestMapping(value = "/api/reservation/accept/{id}", method = RequestMethod.PUT)
    public ReservationDTO acceptReservation(@PathVariable("id") Integer id) {
        if(!reservationRepository.findById(id).isEmpty()) {
            ReservationConverter reservationConverter = new ReservationConverter();
            ReservationDTO reservationDTO = reservationConverter.entityToDto(reservationRepository.findById(id).get());
            reservationDTO.setId(id);
            reservationDTO.setAcceptState(1);
            reservationService.update(reservationDTO,id);
            return reservationDTO;
        }
        return null;
    }
    @RequestMapping(value = "/api/reservation/decline/{id}", method = RequestMethod.PUT)
    public ReservationDTO declineReservation(@PathVariable("id") Integer id) {
        if(!reservationRepository.findById(id).isEmpty()) {
            ReservationConverter reservationConverter = new ReservationConverter();
            ReservationDTO reservationDTO = reservationConverter.entityToDto(reservationRepository.findById(id).get());
            reservationDTO.setId(id);
            reservationDTO.setAcceptState(2);
            reservationService.update(reservationDTO,id);
            return reservationDTO;
        }
        return null;
    }

    @RequestMapping(value = "/api/reservation/getAccepted/{idAnnounce}", method = RequestMethod.GET)
    public List<ReservationDTO> getAcceptedReservation(@PathVariable("idAnnounce") Integer idAnnounce) {
        if(!announceRepository.findById(idAnnounce).isEmpty()) {
            return reservationService.getAccepted(idAnnounce);
        }
        return null;
    }

    @RequestMapping(value = "/api/reservation/getByUser/{idUser}", method = RequestMethod.GET)
    public List<ReservationDTO> getReservationsByIdUser(@PathVariable("idUser") Integer idUser) {
        if(!userRepository.findById(idUser).isEmpty()) {
            return reservationService.getAllByIdUser(idUser);
        }
        return null;
    }

    @RequestMapping(value = "/api/reservation/getNonAcceptedByUser/{idUser}",method = RequestMethod.GET)
    public List<ReservationDTO> getReservationNonAcceptedByIdUser(@PathVariable("idUser") Integer idUser) {
        if (!userRepository.findById(idUser).isEmpty()) {
            return reservationService.getAllNonAcceptedByIdUser(idUser);
        }
        return null;
    }

    @RequestMapping(value = "/api/reservation/getNonRefusedByUser/{idUser}",method = RequestMethod.GET)
    public List<ReservationDTO> getReservationAcceptedByIdUser(@PathVariable("idUser") Integer idUser) {
        if (!userRepository.findById(idUser).isEmpty()) {
            return reservationService.getAllNotRefusedByIdUser(idUser);
        }
        return null;
    }

    @RequestMapping(value = "/api/reservation/getAwaitingByUser/{idUser}",method = RequestMethod.GET)
    public List<ReservationDTO> getReservationAwaitingByIdUser(@PathVariable("idUser") Integer idUser) {
        if (!userRepository.findById(idUser).isEmpty()) {
            return reservationService.getAllAwaitingByIdUser(idUser);
        }
        return null;
    }
}
