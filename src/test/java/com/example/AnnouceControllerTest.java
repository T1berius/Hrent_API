package com.example;

import com.example.services.AnnounceService;
import com.example.services.dto.AnnounceDTO;
import org.apache.tomcat.util.descriptor.web.FragmentJarScannerCallback;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AnnouceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AnnounceService announceService;
    @Test
    public void testCreateAndGetAnnounce() throws Exception {
        AnnounceDTO announceDTO = new AnnounceDTO();
        announceDTO.setTitle("Maison de campagne");
        announceDTO.setDescription("Maison réalisée via un test unitaire");
        announceDTO.setPrice(24.0);
        announceDTO.setCity("Clermont Ferrand");
        announceDTO.setIdUser(1);
        announceDTO.setCaution(100.0);
        announceDTO.setPostalCode("63000");
        announceDTO.setCapacity(2);
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse("05-05-2022");
        announceDTO.setStartDate(date);
        announceDTO.setEndDate(new Date());
        announceDTO.setIdTypeLogement(1);
        announceDTO.setIsIdCardRequired(true);
        announceDTO.setIsSmokingAllowed(true);
        announceDTO.setIsPetsAllowed(true);
        announceDTO.setIsPassportRequired(true);
        announceDTO.setIsProofOfAddressRequired(true);
        announceDTO.setArrivalTime(Time.valueOf("07:00:00"));
        announceDTO.setDepartureTime(Time.valueOf("12:00:00"));
        announceDTO.setTelephoneNumber("0604427895");
        announceDTO.setLocationPrimaryPicture(null);
        announceDTO.setLocationSecondaryPicture(null);
        announceDTO.setLocationThirdPicture(null);
        announceDTO.setLocationFourthPicture(null);
        announceDTO.setLocationFifthPicture(null);
        announceDTO=this.announceService.create(announceDTO);
        mockMvc.perform(get("/api/announce/?title=Maison de campagne")).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$[0].title",is("Maison de campagne")));
    }

    @Test
    public void testGetAnnounceWithError() throws Exception {
        mockMvc.perform(get("/api/announces")).andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$[0].title",is("Maison inexistante")));
    }
}
