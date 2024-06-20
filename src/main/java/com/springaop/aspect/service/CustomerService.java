package com.springaop.aspect.service;

import com.springaop.aspect.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getCustomerList();
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void deleteCustomer(Long id);

}
