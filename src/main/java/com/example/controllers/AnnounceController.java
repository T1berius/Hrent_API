package com.example.controllers;

import com.example.model.Announce;
import com.example.payload.UploadFileResponse;
import com.example.repository.AnnounceRepository;
import com.example.services.AnnounceService;
import com.example.services.FileStorageService;
import com.example.services.coverter.AnnounceConverter;
import com.example.services.dto.AnnounceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.net.http.HttpResponse;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AnnounceController {
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private AnnounceService announceService;

    @Autowired
    private AnnounceConverter announceConverter;

    @Autowired
    private FileController fileController;

    @RequestMapping(value = "/api/announces", method = RequestMethod.GET)
    public List<Announce> getAnnounces() {
        return announceConverter.listDtoToListEntity(announceService.findAnnounces());
    }

    @RequestMapping(value = "/api/announce/{id}", method = RequestMethod.GET)
    public AnnounceDTO findAnnounceById(@PathVariable("id") Integer id) {
        return announceService.findOneById(id);
    }

    @RequestMapping(value = "/api/announce/delete/{id}", method = RequestMethod.DELETE)
    public void deleteAnnounceById(@PathVariable("id") Integer id) {
        announceService.deleteById(id);
    }

    @RequestMapping(value = "/api/announce/create", method = RequestMethod.POST)
    public HttpStatus createAnnounce(@Param("title") String title,
                                      @Param("description") String description,
                                      @Param("price") Double price,
                                      @Param("idUser") Integer idUser,
                                      @Param("caution") Double caution,
                                      @Param("postalCode") String postalCode,
                                      @Param("city") String city,
                                      @Param("capacity") Integer capacity,
                                      @Param("startDate") String startDate,
                                      @Param("endDate") String endDate,
                                      @Param("idTypeLogement") Integer idTypeLogement,
                                      @Param("isIdCardRequired") Boolean isIdCardRequired,
                                      @Param("isSmokingAllowed") Boolean isSmokingAllowed,
                                      @Param("isPetsAllowed") Boolean isPetsAllowed,
                                      @Param("isPassportRequired") Boolean isPassportRequired,
                                      @Param("isProofOfAddressRequired") Boolean isProofOfAddressRequired,
                                      @Param("arrivalTime") String arrivalTime,
                                      @Param("departureTime") String departureTime,
                                      @Param("telephoneNumber") String telephoneNumber,
                                      @Param("files") MultipartFile[] files) throws ParseException {
        AnnounceDTO announceDTO = new AnnounceDTO();
        if(title != null && description != null && price != null && idUser != null && caution != null && postalCode != null && city != null && capacity != null && startDate != null && endDate != null && idTypeLogement != null && isIdCardRequired != null && isSmokingAllowed != null && isPetsAllowed != null && isPassportRequired != null && isProofOfAddressRequired != null && arrivalTime != null && departureTime != null && telephoneNumber != null && files != null) {
            announceDTO.setTitle(title);
            announceDTO.setDescription(description);
            announceDTO.setPrice(price);
            announceDTO.setIdUser(idUser);
            announceDTO.setCaution(caution);
            announceDTO.setPostalCode(postalCode);
            announceDTO.setCapacity(capacity);
            Date dateS = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
            Date dateE = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
            announceDTO.setStartDate(dateS);
            announceDTO.setEndDate(dateE);
            announceDTO.setCity(city);
            announceDTO.setIdTypeLogement(idTypeLogement);
            announceDTO.setIsIdCardRequired(isIdCardRequired);
            announceDTO.setIsSmokingAllowed(isSmokingAllowed);
            announceDTO.setIsPetsAllowed(isPetsAllowed);
            announceDTO.setIsPassportRequired(isPassportRequired);
            announceDTO.setIsProofOfAddressRequired(isProofOfAddressRequired);
            announceDTO.setArrivalTime(Time.valueOf(arrivalTime));
            announceDTO.setDepartureTime(Time.valueOf(departureTime));
            announceDTO.setTelephoneNumber(telephoneNumber);
            announceDTO.setCreationDate(new Date());
            if(files != null) {
                List<UploadFileResponse> list = Arrays.asList(files)
                        .stream()
                        .map(file -> fileController.uploadFile(file))
                        .collect(Collectors.toList());
                List<String> listFileName = new ArrayList<>();
                list.forEach(file -> {
                    if(file.getFileName() != null) {
                        listFileName.add(file.getFileName());
                    }
                });
                if(listFileName.size() > 0) {
                    announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                    if(listFileName.get(0) != null) {
                        announceDTO.setLocationSecondaryPicture(listFileName.get(0));
                    } else {
                        announceDTO.setLocationSecondaryPicture(null);
                    }
                    if(listFileName.size() > 2) {
                        announceDTO.setLocationThirdPicture(listFileName.get(1));
                    }
                    else {
                        announceDTO.setLocationThirdPicture(null);
                    }
                    if(listFileName.size() > 3) {
                        announceDTO.setLocationFourthPicture(listFileName.get(2));
                    }
                    else {
                        announceDTO.setLocationFourthPicture(null);
                    }
                    if(listFileName.size() > 4) {
                        announceDTO.setLocationFifthPicture(listFileName.get(3));
                    }
                    else {
                        announceDTO.setLocationFifthPicture(null);
                    }
                }
            } else {
                return HttpStatus.BAD_REQUEST;
            }
            announceDTO.setCity(city);
            announceService.create(announceDTO);
            return HttpStatus.OK;
        }
        else {
            return HttpStatus.BAD_REQUEST;
        }
    }
    @RequestMapping(value = "/api/announce/update/{id}", method = RequestMethod.PUT)
    public HttpStatus update(@PathVariable("id") Integer id,
                             @Param("title") String title,
                             @Param("description") String description,
                             @Param("price") Double price,
                             @Param("idUser") Integer idUser,
                             @Param("caution") Double caution,
                             @Param("postalCode") String postalCode,
                             @Param("city") String city,
                             @Param("capacity") Integer capacity,
                             @Param("startDate") String startDate,
                             @Param("endDate") String endDate,
                             @Param("idTypeLogement") Integer idTypeLogement,
                             @Param("isIdCardRequired") Boolean isIdCardRequired,
                             @Param("isSmokingAllowed") Boolean isSmokingAllowed,
                             @Param("isPetsAllowed") Boolean isPetsAllowed,
                             @Param("isPassportRequired") Boolean isPassportRequired,
                             @Param("isProofOfAddressRequired") Boolean isProofOfAddressRequired,
                             @Param("arrivalTime") String arrivalTime,
                             @Param("departureTime") String departureTime,
                             @Param("telephoneNumber") String telephoneNumber,
                             @Param("files") MultipartFile[] files) throws ParseException {
        if(id != null && title != null && description != null && price != null && idUser != null && caution != null && postalCode != null && city != null && capacity != null && startDate != null && endDate != null && idTypeLogement != null && isIdCardRequired != null && isSmokingAllowed != null && isPetsAllowed != null && isPassportRequired != null && isProofOfAddressRequired != null && arrivalTime != null && departureTime != null && telephoneNumber != null && announceService.findOneById(id) != null) {
            AnnounceDTO announceDTO = new AnnounceDTO();
            announceDTO.setId(id);
            announceDTO.setTitle(title);
            announceDTO.setDescription(description);
            announceDTO.setPrice(price);
            announceDTO.setIdUser(idUser);
            announceDTO.setCaution(caution);
            announceDTO.setPostalCode(postalCode);
            announceDTO.setCapacity(capacity);
            Date dateS = new SimpleDateFormat("dd-MM-yyyy").parse(startDate);
            Date dateE = new SimpleDateFormat("dd-MM-yyyy").parse(endDate);
            announceDTO.setStartDate(dateS);
            announceDTO.setEndDate(dateE);
            announceDTO.setCity(city);
            announceDTO.setIdTypeLogement(idTypeLogement);
            announceDTO.setIsIdCardRequired(isIdCardRequired);
            announceDTO.setIsSmokingAllowed(isSmokingAllowed);
            announceDTO.setIsPetsAllowed(isPetsAllowed);
            announceDTO.setIsPassportRequired(isPassportRequired);
            announceDTO.setIsProofOfAddressRequired(isProofOfAddressRequired);
            announceDTO.setArrivalTime(Time.valueOf(arrivalTime));
            announceDTO.setDepartureTime(Time.valueOf(departureTime));
            announceDTO.setTelephoneNumber(telephoneNumber);
            announceDTO.setCreationDate(new Date());
            if (files != null) {
                List<UploadFileResponse> list = Arrays.asList(files)
                        .stream()
                        .map(file -> fileController.uploadFile(file))
                        .collect(Collectors.toList());
                List<String> listFileName = new ArrayList<>();
                list.forEach(file -> {
                    if (file.getFileName() != null) {
                        listFileName.add(file.getFileName());
                    }
                });
                if (listFileName.size() > 0) {
                    announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                    if (listFileName.get(1) != null) {
                        announceDTO.setLocationSecondaryPicture(listFileName.get(1));
                    } else {
                        announceDTO.setLocationSecondaryPicture(null);
                    }
                    if (listFileName.size() > 2) {
                        announceDTO.setLocationThirdPicture(listFileName.get(2));
                    } else {
                        announceDTO.setLocationThirdPicture(null);
                    }
                    if (listFileName.size() > 3) {
                        announceDTO.setLocationFourthPicture(listFileName.get(3));
                    } else {
                        announceDTO.setLocationFourthPicture(null);
                    }
                    if (listFileName.size() > 4) {
                        announceDTO.setLocationFifthPicture(listFileName.get(4));
                    } else {
                        announceDTO.setLocationFifthPicture(null);
                    }
                }
            } else {
                return HttpStatus.BAD_REQUEST;
            }
            announceDTO.setCity(city);
            announceService.create(announceDTO);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @GetMapping(value = "/api/announce/")
    @ResponseBody
    public List<Announce> getAnnouncesWithSearch(@RequestParam(value = "title",required = false) String title, @RequestParam(value = "city", required = false) String city, @RequestParam(value = "capacity", required = false) Integer capacity, @RequestParam(value = "startDate",required = false) String startDate, @RequestParam(value = "endDate",required = false) String endDate,@RequestParam(value = "postalCode",required = false) String postalCode, @RequestParam(value = "price",required = false)Double price) throws ParseException {
        if(startDate == null || endDate == null || startDate == "" || endDate == ""){
            startDate = null;
            endDate = null;
        }
        if(title == "") {
            title = null;
        }
        if(city == "") {
            city = null;
        }
        if(postalCode == "") {
            postalCode = null;
        }
        if(postalCode == null && city != null && startDate == null && capacity == null && price == null){
            return announceConverter.listDtoToListEntity(announceService.getAnnouncesByCity(title,city));
        }
        if(postalCode != null && city == null && startDate == null && capacity == null && price == null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPostalCode(title,postalCode));
        }
        if(postalCode == null && city == null && startDate != null && capacity == null && price == null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByStartAndEndDate(title,new SimpleDateFormat("dd-MM-yyyy").parse(startDate),new SimpleDateFormat("dd-MM-yyyy").parse(endDate)));
        }
        if(postalCode == null && city == null && startDate == null && capacity != null && price == null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByCapacity(title,capacity));
        }
        if(postalCode == null && city == null && startDate == null && capacity == null && price != null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPrice(title,price));
        }
        if(postalCode != null && city != null && startDate == null && capacity == null && price == null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPostalCodeAndCity(title,postalCode,city));
        }
        if(postalCode != null && city == null && startDate != null && capacity == null && price == null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndPostalCode(title,new SimpleDateFormat("dd-MM-yyyy").parse(startDate),new SimpleDateFormat("dd-MM-yyyy").parse(endDate),postalCode));
        }
        if(postalCode != null && city == null && startDate == null && capacity != null && price == null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByCapacityAndPostalCode(title,capacity,postalCode));
        }
        if(postalCode == null && city != null && startDate != null && capacity == null && price == null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndCity(title,new SimpleDateFormat("dd-MM-yyyy").parse(startDate),new SimpleDateFormat("dd-MM-yyyy").parse(endDate),city));
        }
        if(postalCode == null && city != null && startDate == null && capacity != null && price == null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByCapacityAndCity(title,capacity,city));
        }
        if(postalCode != null && city != null && startDate != null && capacity == null && price == null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndPostalCodeAndCity(title,new SimpleDateFormat("dd-MM-yyyy").parse(startDate),new SimpleDateFormat("dd-MM-yyyy").parse(endDate),postalCode,city));
        }
        if(postalCode == null && city == null && startDate == null && capacity != null && price != null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByCapacityAndPrice(title,capacity,price));
        }
        if(postalCode != null && city == null && startDate == null && capacity == null && price != null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPriceAndPostalCode(title,price,postalCode));
        }
        if(postalCode == null && city != null && startDate == null && capacity == null && price != null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPriceAndCity(title,price,city));
        }
        if(postalCode != null && city != null && startDate != null && capacity != null && price == null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndPostalCodeAndCityAndCapacity(title,new SimpleDateFormat("dd-MM-yyyy").parse(startDate),new SimpleDateFormat("dd-MM-yyyy").parse(endDate),postalCode,city,capacity));
        }
        if(postalCode != null && city == null && startDate != null && capacity != null && price != null){
            return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndPostalCodeAndCapacityAndPrice(title,new SimpleDateFormat("dd-MM-yyyy").parse(startDate),new SimpleDateFormat("dd-MM-yyyy").parse(endDate),postalCode,capacity,price));
        }
        return announceConverter.listDtoToListEntity(announceService.findAnnouncesByTitle(title));
    }
}
