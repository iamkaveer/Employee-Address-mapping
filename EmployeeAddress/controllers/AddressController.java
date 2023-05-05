package com.mapping.EmployeeAddress.controllers;

import com.mapping.EmployeeAddress.entity.Address;
import com.mapping.EmployeeAddress.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressRepo addressRepo;

    @PostMapping("/address/create")
    public ResponseEntity<Address> addAddress(@RequestBody Address newAddress){
        return new ResponseEntity<>(addressRepo.save((newAddress)), HttpStatus.CREATED);
    }

    @GetMapping("/get-all-address")
    public ResponseEntity<List<Address>> getAll(){
        return ResponseEntity.ok(addressRepo.findAll());
    }

    @GetMapping("/get-address/{id}")
    public ResponseEntity<Address> getById(@PathVariable int id){
        return ResponseEntity.ok(addressRepo.findById(id).get());
    }

    @DeleteMapping("/delete-address/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id){
        Address address = addressRepo.findById(id).get();
        if(address!=null){
            addressRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("DELETED");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
        }
    }

    @PutMapping("/update-address/{id}")
    public ResponseEntity<String> updateAddress(@RequestBody Address newAddress, @PathVariable int id){
        Address existingAddress = addressRepo.findById(id).get();
        if(existingAddress!=null){
            existingAddress.setAddressId(newAddress.getAddressId());
            existingAddress.setStreet(newAddress.getStreet());
            existingAddress.setCity(newAddress.getCity());
            existingAddress.setState(newAddress.getState());
            existingAddress.setZipCode(newAddress.getZipCode());
            addressRepo.save(existingAddress);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("UPDATED");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
        }
    }

}
