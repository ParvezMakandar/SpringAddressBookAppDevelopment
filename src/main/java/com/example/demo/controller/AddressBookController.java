package com.example.demo.controller;

import com.example.demo.dto.AddressBookDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.exception.AddressBookException;
import com.example.demo.model.AddressBook;
import com.example.demo.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
//Maps http request to method of mvc and rest controller
@RequestMapping("/addressbook")

public class AddressBookController {
    //Autowired IAddressBookService interface so we can inject its dependency here
    @Autowired
    IAddressBookService service;

    //Ability to get welcome message
    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcome() {
        String message = service.getWelcome();
        return new ResponseEntity(message, HttpStatus.OK);
    }

    //Ability to store  address  record to repository
    @PostMapping("/create")
    public ResponseEntity<String> saveDataToRepo(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        String newAddress = service.saveDataToRepo(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record created successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    //Ability to get all record from repository
    @GetMapping(value = "/getAll/{token}")
    public ResponseEntity<ResponseDTO> getAddressBookDataToken(@PathVariable String token) {
        List<AddressBook> entity = service.getAddressBookDataToken(token);
        ResponseDTO responseDTO = new ResponseDTO("Data retrived successfully :", entity);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }


    //Ability to get address  record by token
    @GetMapping("/get/{token}")
    public ResponseEntity<String> getRecordFromRepoByID(@PathVariable String token) throws AddressBookException {
        AddressBook entity = service.getRecordOfIdFromToken(token);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular id retrieved successfully", entity);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }


    //Ability to update addressbook record to repository
    @PutMapping("/update/{token}")
    public ResponseEntity<String> updateRecordById(@PathVariable String token, @Valid @RequestBody AddressBookDTO addressBookDTO)
            throws AddressBookException {
        AddressBook entity = service.updateRecordByToken(token, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record updated successfully", entity);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    //Ability to delete address book record to repository
    @DeleteMapping("/delete/{token}")
    public ResponseEntity<String> deleteRecordById(@PathVariable String token) throws AddressBookException {
        ResponseDTO dto = new ResponseDTO("Address Book Record deleted successfully", service.deleteRecordByToken(token));
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    @GetMapping("/sortByCity")
    public ResponseEntity<String> getDataBySortingCity() {
        List<AddressBook> newAddress = service.SortByCity();
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record Sorted by City successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/sortByState")
    public ResponseEntity<String> getDataBySortingState() {
        List<AddressBook> newAddress = service.SortByState();
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record Sorted in State successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/sortByZip")
    public ResponseEntity<String> getDataBySortingZip() {
        List<AddressBook> newAddress = service.SortByZip();
        ResponseDTO responseDTO = new ResponseDTO("Address Book Record Sorted in Zip successfully", newAddress);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }
}



//Ability to get Record Sorted in Ascending order from repository layer
//    @GetMapping("/{Field}")
//    public ResponseEntity getDateBySorting(@PathVariable String Field) {
//        List<Address> sortAddress = service.findProductsWithSorting(Field);
//        ResponseDTO responseDTO = new ResponseDTO("Address Book Record for particular id retrieved successfully", sortAddress);
//        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
//    }