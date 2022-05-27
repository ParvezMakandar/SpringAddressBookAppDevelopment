package com.example.demo.repository;

import com.example.demo.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {

    @Query(value = "select * from address_book order by city", nativeQuery = true)
    List<AddressBook> SortByCity();


    @Query(value = "select * from address_book order by state", nativeQuery = true)
    List<AddressBook> SortByState();

    @Query(value = "select * from address_book order by zip", nativeQuery = true)
    List<AddressBook> SortByZip();

}
