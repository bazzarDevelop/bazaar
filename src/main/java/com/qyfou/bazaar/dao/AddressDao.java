package com.qyfou.bazaar.dao;

import com.qyfou.bazaar.model.Address;
import org.apache.ibatis.annotations.Mapper;


public interface AddressDao {

    void updateAddress(Address address);
}
