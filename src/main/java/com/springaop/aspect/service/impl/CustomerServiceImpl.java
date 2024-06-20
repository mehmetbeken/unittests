package com.springaop.aspect.service.impl;

import com.springaop.aspect.dto.CustomerDTO;
import com.springaop.aspect.mapper.EntityMapper;
import com.springaop.aspect.repository.CustomerRepository;
import com.springaop.aspect.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final EntityMapper entityMapper;

    @Override
    public List<CustomerDTO> getCustomerList() {
        return entityMapper.convertCustomerDTOList(customerRepository.findAll());
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return entityMapper.convertCustomerDTO(customerRepository.save(entityMapper.convertCustomer(customerDTO)));
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
