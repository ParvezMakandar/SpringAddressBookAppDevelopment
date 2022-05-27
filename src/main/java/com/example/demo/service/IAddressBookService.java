package com.example.demo.service;

import com.example.demo.dto.AddressBookDTO;
import com.example.demo.model.AddressBook;

import java.util.List;

public interface IAddressBookService {

    public String getWelcome();
    public String saveDataToRepo(AddressBookDTO addressBookDTO);
    public List<AddressBook> getAddressBookDataToken(String token);
    public AddressBook getRecordOfIdFromToken(String token);
    public AddressBook updateRecordByToken(String token, AddressBookDTO addressBookDTO);
    public AddressBook deleteRecordByToken(String token);
    public List<AddressBook> SortByCity();
    public List<AddressBook> SortByState();
    public List<AddressBook> SortByZip();

    //public List<Address> findProductsWithSorting(String Field);

//    public Address sortByCity(AddressBookDTO addressBookDTO);
}