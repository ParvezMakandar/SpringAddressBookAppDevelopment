package com.example.demo.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data

public class AddressBookDTO {

    @NotEmpty(message="First name cant be empty")
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee firstName is Invalid")
    private String firstName;


    @NotEmpty(message="Last name cant be empty")
    @Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee lastName is Invalid")
    private String lastName;

    @NotEmpty(message="Email cant be empty")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Please enter a valid email id")
    private String email;

    @NotNull(message="Phone number cant be empty")
//    @Pattern(regexp = "^\\d{10}$", message = "Please enter a valid phone number")
    private Long phoneNumber;

    @NotEmpty(message="city cant be empty")
    private String city;

    @NotEmpty(message="State cant be empty")
    private String state;

    @NotNull(message="Zip code cant be empty")
//    @Pattern(regexp = "^\\d{6}$", message = "Please enter a valid zip code")
    private Integer zip;

    public AddressBookDTO() {
        super();
    }
}