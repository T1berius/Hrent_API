package com.example.controllers;

import com.example.Status;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.services.UserService;
import com.example.services.coverter.UserConverter;
import com.example.services.dto.UserDTO;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @RequestMapping(value = "/api/users",method = RequestMethod.GET)
    public List<UserDTO> getUsers(){
        return userService.findAll();
    }

    @RequestMapping(value = "/api/user/{id}",method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") Integer id){
        return userService.findOneById(id);
    }

    @RequestMapping(value = "/api/user/delete/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Integer id){
        userService.deleteById(id);
    }

    @RequestMapping(value = "/api/user/create",method = RequestMethod.POST)
    public HttpStatus createUser(@Param("firstName") String firstName,
                                 @Param("lastName") String lastName,
                                 @Param("email") String email,
                                 @Param("city") String city,
                                 @Param("country") String country,
                                 @Param("zipCode") String zipCode,
                                 @Param("street") String street,
                                 @Param("phone") String phone){

        if(firstName != null && lastName != null && email != null && city != null && country != null && zipCode != null && street != null && phone != null){
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(firstName);
            userDTO.setLastName(lastName);
            userDTO.setEmail(email);
            userDTO.setCity(city);
            userDTO.setZipCode(zipCode);
            userDTO.setPhone(phone);
            userDTO.setRegisteredAt(new Date());
            userService.create(userDTO);
            return HttpStatus.OK;
        }
        else {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @RequestMapping(value = "/api/user/login",method = RequestMethod.POST)
    public ResponseEntity<UserDTO> login(@Param("email") String email, @Param("password") String password) {
        List<User> users = userRepository.findAll();
        for (User other : users){
            if (other.getEmail().equals(email) && other.getPassword().equals(password)) {
                userRepository.save(other);
                UserDTO loggedUser = userConverter.entityToDto(other);
                loggedUser.setLoggedIn(true);
                UserDTO body = loggedUser;
                return new ResponseEntity<UserDTO>(body, HttpStatus.OK);
            }
        }
        UserDTO body = new UserDTO();
        return new ResponseEntity<UserDTO>(body, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/api/user/logout")
    public Status logUserOut(@Valid @RequestBody Integer id) {
        UserConverter userConverter = new UserConverter();
        UserDTO userDTO = userService.findOneById(id);
        if (userDTO == null) {
            System.out.println("User does not exist!");
        }
        else {
            userDTO.setLoggedIn(false);
            userRepository.save(userConverter.dtoToEntity(userDTO));
            return Status.SUCCESS;
        }
        return Status.FAILURE;
    }
}
