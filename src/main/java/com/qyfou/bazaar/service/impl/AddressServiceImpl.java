package com.qyfou.bazaar.service.impl;

import com.qyfou.bazaar.dao.AddressDao;
import com.qyfou.bazaar.model.Address;
import com.qyfou.bazaar.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;


    public Object updateAddress(Long id, String tname, String location, String phone) {
        Address address1 = new Address(id, 0L, tname, location, phone);
        addressDao.updateAddress(address1);
        return "OK";
    }
}
