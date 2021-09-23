package com.qyfou.bazaar.controller;

import com.qyfou.bazaar.model.Address;
import com.qyfou.bazaar.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressBase addressBase;

    @Autowired
    private AddressServiceImpl addressServiceImpl;

    @PostMapping("/add")
    public Object addAddress(Address address) {
        addressBase.save(address);
        return "OK";
    }

    @PutMapping("/update")
    public Object updateAddress(Long id, String tname, String location, String phone) {
        return addressServiceImpl.updateAddress(id, tname, location, phone);
    }

}
