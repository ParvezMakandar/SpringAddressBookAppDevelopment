package com.example.demo.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import com.example.demo.dto.AddressBookDTO;
import lombok.Data;

@Entity
@Data
public class AddressBook {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private String city;
    private String state;
    private Integer zip;

    public AddressBook() {
        super();
    }

    public AddressBook(AddressBookDTO addressBookDTO) {

        this.firstName=addressBookDTO.getFirstName();
        this.lastName=addressBookDTO.getLastName();
        this.email=addressBookDTO.getEmail();
        this.phoneNumber=addressBookDTO.getPhoneNumber();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zip=addressBookDTO.getZip();
    }
    public AddressBook(Integer id,AddressBookDTO addressBookDTO) {
        this.id = id;
        this.firstName=addressBookDTO.getFirstName();
        this.lastName=addressBookDTO.getLastName();
        this.email=addressBookDTO.getEmail();
        this.phoneNumber=addressBookDTO.getPhoneNumber();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zip=addressBookDTO.getZip();
    }
}