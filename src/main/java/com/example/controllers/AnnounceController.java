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
@CrossOrigin
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
        if (title != null && description != null && price != null && idUser != null && caution != null && postalCode != null && city != null && capacity != null && startDate != null && endDate != null && idTypeLogement != null && isIdCardRequired != null && isSmokingAllowed != null && isPetsAllowed != null && isPassportRequired != null && isProofOfAddressRequired != null && arrivalTime != null && departureTime != null && telephoneNumber != null && files != null) {
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
            switch (listFileName.size()) {
                case 1:
                    announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                    break;
                case 2:
                    announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                    announceDTO.setLocationSecondaryPicture(listFileName.get(1));
                    break;
                case 3:
                    announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                    announceDTO.setLocationSecondaryPicture(listFileName.get(1));
                    announceDTO.setLocationThirdPicture(listFileName.get(2));
                    break;
                case 4:
                    announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                    announceDTO.setLocationSecondaryPicture(listFileName.get(1));
                    announceDTO.setLocationThirdPicture(listFileName.get(2));
                    announceDTO.setLocationFourthPicture(listFileName.get(3));
                    break;
                case 5:
                    announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                    announceDTO.setLocationSecondaryPicture(listFileName.get(1));
                    announceDTO.setLocationThirdPicture(listFileName.get(2));
                    announceDTO.setLocationFourthPicture(listFileName.get(3));
                    announceDTO.setLocationFifthPicture(listFileName.get(4));
                    break;
            }
            announceDTO.setCity(city);
            announceService.create(announceDTO);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
    @RequestMapping(value = "/api/announce/update/{id}", method = RequestMethod.PATCH)
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
                switch (listFileName.size()) {
                    case 1 :
                        announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                        break;
                    case 2 :
                        announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                        announceDTO.setLocationSecondaryPicture(listFileName.get(1));
                        break;
                    case 3 :
                        announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                        announceDTO.setLocationSecondaryPicture(listFileName.get(1));
                        announceDTO.setLocationThirdPicture(listFileName.get(2));
                        break;
                    case 4 :
                        announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                        announceDTO.setLocationSecondaryPicture(listFileName.get(1));
                        announceDTO.setLocationThirdPicture(listFileName.get(2));
                        announceDTO.setLocationFourthPicture(listFileName.get(3));
                        break;
                    case 5 :
                        announceDTO.setLocationPrimaryPicture(listFileName.get(0));
                        announceDTO.setLocationSecondaryPicture(listFileName.get(1));
                        announceDTO.setLocationThirdPicture(listFileName.get(2));
                        announceDTO.setLocationFourthPicture(listFileName.get(3));
                        announceDTO.setLocationFifthPicture(listFileName.get(4));
                        break;
                }
                announceDTO.setCity(city);
                announceService.create(announceDTO);
                return HttpStatus.OK;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping(value = "/api/announce/")
    @ResponseBody
    public List<Announce> getAnnouncesWithSearch(@RequestParam(value = "title",required = false) String title, @RequestParam(value = "city", required = false) String city, @RequestParam(value = "capacity", required = false) Integer capacity, @RequestParam(value = "startDate",required = false) String startDate, @RequestParam(value = "endDate",required = false) String endDate,@RequestParam(value = "postalCode",required = false) String postalCode, @RequestParam(value = "minPrice",required = false)Double minPrice, @RequestParam(value = "maxPrice",required = false)Double maxPrice) throws ParseException {
        Double price = null;
        if(startDate == null || endDate == null || startDate == "" || endDate == ""){
            startDate = null;
            endDate = null;
        }
        if(city == "") {
            city = null;
        }
        if(maxPrice != null || minPrice != null){
            price = 2.0;
            if(minPrice == null){
                minPrice = 0.0;
            } if (maxPrice == null){
                maxPrice = Double.MAX_VALUE;
            }
        }
        if(postalCode == "") {
            postalCode = null;
        }
        if(title != "" && title != null) {
            if (postalCode == null && city != null && startDate == null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.getAnnouncesByCity(title, city));
            }
            if (postalCode != null && city == null && startDate == null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPostalCode(title, postalCode));
            }
            if (postalCode == null && city == null && startDate != null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByStartAndEndDate(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate)));
            }
            if (postalCode == null && city == null && startDate == null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByCapacity(title, capacity));
            }
            if (postalCode == null && city == null && startDate == null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPrice(title, minPrice, maxPrice));
            }
            if (postalCode != null && city != null && startDate == null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPostalCodeAndCity(title, postalCode, city));
            }
            if (postalCode != null && city == null && startDate != null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndPostalCode(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), postalCode));
            }
            if (postalCode != null && city == null && startDate == null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByCapacityAndPostalCode(title, capacity, postalCode));
            }
            if (postalCode == null && city != null && startDate != null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndCity(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), city));
            }
            if (postalCode == null && city != null && startDate == null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByCapacityAndCity(title, capacity, city));
            }
            if (postalCode != null && city != null && startDate != null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndPostalCodeAndCity(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), postalCode, city));
            }
            if (postalCode == null && city == null && startDate == null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByCapacityAndPrice(title, capacity, minPrice, maxPrice));
            }
            if (postalCode != null && city == null && startDate == null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPriceAndPostalCode(title, minPrice, maxPrice, postalCode));
            }
            if (postalCode == null && city != null && startDate == null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPriceAndCity(title, minPrice, maxPrice, city));
            }
            if (postalCode != null && city != null && startDate != null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndPostalCodeAndCityAndCapacity(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), postalCode, city, capacity));
            }
            if (postalCode != null && city == null && startDate != null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndPostalCodeAndCapacityAndPrice(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), postalCode, capacity, minPrice, maxPrice));
            }
            if (postalCode == null && city == null && startDate != null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndCapacity(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), capacity));
            }
            if (postalCode == null && city != null && startDate != null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndCityAndCapacity(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), city, capacity));
            }
            if (postalCode == null && city != null && startDate != null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndCityAndCapacityAndPrice(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), city, capacity, minPrice, maxPrice));
            }
            if (postalCode == null && city == null && startDate != null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndPrice(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), minPrice, maxPrice));
            }
            if (postalCode == null && city == null && startDate != null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndCapacityAndPrice(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), capacity, minPrice, maxPrice));
            }
            if (postalCode != null && city == null && startDate != null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndPostalCodeAndCapacity(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), postalCode, capacity));
            }
            if (postalCode == null && city != null && startDate != null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndCityAndPrice(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), city, minPrice, maxPrice));
            }
            if (postalCode != null && city == null && startDate != null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByDateAndPostalCodeAndPrice(title, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), postalCode, minPrice, maxPrice));
            }
            if (postalCode == null && city != null && startDate == null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByCityAndCapacityAndPrice(title, city, capacity, minPrice, maxPrice));
            }
            if (postalCode != null && city == null && startDate == null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPostalCodeAndCapacityAndPrice(title, postalCode, capacity, minPrice, maxPrice));
            }
            if(postalCode != null && city != null && startDate == null && capacity != null && price == null){
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPostalCodeAndCityAndCapacity(title, postalCode, city, capacity));
            }
            if(postalCode != null && city != null && startDate == null && capacity == null && price != null){
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPostalCodeAndCityAndPrice(title, postalCode, city, minPrice, maxPrice));
            }
            if(postalCode != null && city != null && startDate != null && capacity == null && price != null){
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPostalCodeAndCityAndDateAndPrice(title, postalCode, city, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), minPrice, maxPrice));
            }
            if(postalCode != null && city != null && startDate == null && capacity != null && price != null){
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPostalCodeAndCityAndCapacityAndPrice(title, postalCode, city, capacity, minPrice, maxPrice));
            }
            if(postalCode != null && city != null && startDate != null && capacity != null && price != null){
                return announceConverter.listDtoToListEntity(announceService.findAnnouncesByPostalCodeAndCityAndDateAndCapacityAndPrice(title, postalCode, city, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), capacity, minPrice, maxPrice));
            }
        } else {
            if(postalCode == null && city == null && startDate == null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByPrice(minPrice, maxPrice));
            }
            if(postalCode == null && city == null && startDate == null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacity(capacity));
            }
            if(postalCode == null && city == null && startDate != null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByDate(new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate)));
            }
            if(postalCode == null && city != null && startDate == null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCity(city));
            }
            if(postalCode != null && city == null && startDate == null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByPostalCode(postalCode));
            }
            if(postalCode == null && city == null && startDate == null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndPrice(capacity, minPrice, maxPrice));
            }
            if(postalCode == null && city == null && startDate != null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndDate(capacity,new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate)));
            }
            if(postalCode == null && city != null && startDate == null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndCity(capacity, city));
            }
            if(postalCode != null && city == null && startDate == null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndPostalCode(capacity, postalCode));
            }
            if(postalCode != null && city == null && startDate != null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndDateAndPostalCode(capacity, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), postalCode));
            }
            if(postalCode != null && city == null && startDate == null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndPriceAndPostalCode(capacity, minPrice, maxPrice, postalCode));
            }
            if(postalCode == null && city == null && startDate != null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndDateAndPrice(capacity, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), minPrice, maxPrice));
            }
            if(postalCode == null && city != null && startDate == null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndCityAndPrice(capacity, city, minPrice, maxPrice));
            }
            if(postalCode != null && city != null && startDate == null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndCityAndPostalCode(capacity, city, postalCode));
            }
            if(postalCode == null && city != null && startDate != null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndDateAndCity(capacity, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), city));
            }
            if(postalCode == null && city != null && startDate != null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndDateAndPriceAndCity(capacity, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), minPrice, maxPrice, city));
            }
            if(postalCode != null && city == null && startDate != null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndDateAndPriceAndPostalCode(capacity, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), minPrice, maxPrice, postalCode));
            }
            if(postalCode != null && city != null && startDate != null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCapacityAndDateAndPriceAndCityAndPostalCode(capacity, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), minPrice, maxPrice, city, postalCode));
            }
            if(postalCode != null && city == null && startDate != null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByDateAndPriceAndPostalCode(new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), minPrice, maxPrice, postalCode));
            }
            if(postalCode == null && city == null && startDate != null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByDateAndPrice(new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), minPrice, maxPrice));
            }
            if(postalCode == null && city != null && startDate != null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByDateAndCity(new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), city));
            }
            if(postalCode != null && city == null && startDate != null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByDateAndPostalCode(new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), postalCode));
            }
            if(postalCode == null && city != null && startDate == null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByPriceAndCity(minPrice, maxPrice, city));
            }
            if(postalCode != null && city == null && startDate == null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByPriceAndPostalCode(minPrice, maxPrice, postalCode));
            }
            if(postalCode != null && city != null && startDate == null && capacity == null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCityAndPostalCode(city, postalCode));
            }
            if(postalCode == null && city != null && startDate != null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByPriceAndCityAndDate(minPrice, maxPrice, city, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate)));
            }
            if(postalCode != null && city != null && startDate == null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByPriceAndCityAndPostalCode(minPrice, maxPrice, city, postalCode));
            }
            if(postalCode != null && city != null && startDate != null && capacity == null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByPriceAndCityAndDateAndPostalCode(minPrice, maxPrice, city, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), postalCode));
            }
            if(postalCode != null && city != null && startDate != null && capacity != null && price == null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByCityAndDateAndPostalCodeAndCapacity(city, new SimpleDateFormat("dd-MM-yyyy").parse(startDate), new SimpleDateFormat("dd-MM-yyyy").parse(endDate), postalCode, capacity));
            }
            if(postalCode != null && city != null && startDate == null && capacity != null && price != null) {
                return announceConverter.listDtoToListEntity(announceService.findWithoutTitleByPriceAndCityAndCapacityAndPostalCode(minPrice,maxPrice, city, capacity, postalCode));
            }
        }
        return announceConverter.listDtoToListEntity(announceService.findAnnouncesByTitle(title));
    }
}
