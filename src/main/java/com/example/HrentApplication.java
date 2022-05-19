package com.example;

import com.example.property.FileStorageProperties;
import com.example.services.*;
import com.example.services.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class HrentApplication {

    @Autowired
    private AnnounceService announceService;

    @Autowired
    private UserService userService;

    @Autowired
    private DocumentTypeService documentTypeService;

    @Autowired
    private TypeLogementService typeLogementService;

    @Autowired
    private WishListService wishListService;

    public static void main(String[] args) {
        SpringApplication.run(HrentApplication.class);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void createDefaultData() throws ParseException {
        AnnounceDTO announceDTO = new AnnounceDTO();
        announceDTO.setTitle("Title");
        announceDTO.setDescription("Description");
        announceDTO.setPrice(400.0);
        announceDTO.setCity("City");
        announceDTO.setIdUser(1);
        announceDTO.setCaution(100.0);
        announceDTO.setPostalCode("63000");
        announceDTO.setCapacity(2);
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2020");
        announceDTO.setStartDate(date);
        announceDTO.setEndDate(new Date());
        announceDTO.setIdTypeLogement(1);
        announceDTO.setIsIdCardRequired(true);
        announceDTO.setIsSmokingAllowed(true);
        announceDTO.setIsPetsAllowed(true);
        announceDTO.setIsPassportRequired(true);
        announceDTO.setIsProofOfAddressRequired(true);
        announceDTO.setArrivalTime(Time.valueOf("03:00:00"));
        announceDTO.setDepartureTime(Time.valueOf("12:00:00"));
        announceDTO.setTelephoneNumber("0651434567");
        announceDTO.setLocationPrimaryPicture(null);
        announceDTO.setLocationSecondaryPicture(null);
        announceDTO.setLocationThirdPicture(null);
        announceDTO.setLocationFourthPicture(null);
        announceDTO.setLocationFifthPicture(null);
        announceDTO=this.announceService.create(announceDTO);

        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("FirstName");
        userDTO.setLastName("LastName");
        userDTO.setEmail("Email");
        userDTO.setCity("City");
        userDTO.setZipCode("PostalCode");
        userDTO.setPhone("Phone");
        userDTO.setRegisteredAt(new java.sql.Date(System.currentTimeMillis()));
        userDTO = this.userService.create(userDTO);

        DocumentTypeDTO documentTypeDTO = new DocumentTypeDTO();
        documentTypeDTO.setName("Carte Nationale d’identité");
        documentTypeDTO = this.documentTypeService.create(documentTypeDTO);

        DocumentTypeDTO documentTypeDTO2 = new DocumentTypeDTO();
        documentTypeDTO2.setName("Passeport");
        documentTypeDTO2 = this.documentTypeService.create(documentTypeDTO2);

        DocumentTypeDTO documentTypeDTO3 = new DocumentTypeDTO();
        documentTypeDTO3.setName("Justificatif de domicile");
        documentTypeDTO3 = this.documentTypeService.create(documentTypeDTO3);

        TypeLogementDTO typeLogementDTO = new TypeLogementDTO();
        typeLogementDTO.setId(1);
        typeLogementDTO.setLibelle("Appartement");
        typeLogementDTO = this.typeLogementService.create(typeLogementDTO);

        TypeLogementDTO typeLogementDTO2 = new TypeLogementDTO();
        typeLogementDTO2.setId(2);
        typeLogementDTO2.setLibelle("Maison");
        typeLogementDTO2 = this.typeLogementService.create(typeLogementDTO2);

        TypeLogementDTO typeLogementDTO3 = new TypeLogementDTO();
        typeLogementDTO3.setId(3);
        typeLogementDTO3.setLibelle("Studio");
        typeLogementDTO3 = this.typeLogementService.create(typeLogementDTO3);

        TypeLogementDTO typeLogementDTO4 = new TypeLogementDTO();
        typeLogementDTO4.setId(4);
        typeLogementDTO4.setLibelle("Chambre d'hôte");
        typeLogementDTO4 = this.typeLogementService.create(typeLogementDTO4);

        TypeLogementDTO typeLogementDTO5 = new TypeLogementDTO();
        typeLogementDTO5.setId(5);
        typeLogementDTO5.setLibelle("Autre");
        typeLogementDTO5 = this.typeLogementService.create(typeLogementDTO5);

        WishListDTO wishListDTO = new WishListDTO();
        wishListDTO.setId(1);
        wishListDTO.setAnnounceId(1);
        wishListDTO.setUserId(1);
        wishListDTO = this.wishListService.create(wishListDTO);
    }
}
