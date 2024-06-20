package com.springaop.aspect.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.springaop.aspect.dto.CustomerDTO;
import com.springaop.aspect.mapper.EntityMapper;
import com.springaop.aspect.model.Customer;
import com.springaop.aspect.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private EntityMapper entityMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    void getCustomerList() {
        // Given
        List<Customer> customerEntities = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1L);
        customerEntities.add(customer);

        List<CustomerDTO> customerDTOs = new ArrayList<>();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        customerDTOs.add(customerDTO);

        // When
        Mockito.when(customerRepository.findAll()).thenReturn(customerEntities);
        Mockito.when(entityMapper.convertCustomerDTOList(customerEntities)).thenReturn(customerDTOs);

        // Then
        List<CustomerDTO> result = customerService.getCustomerList();
        Assertions.assertEquals(customerDTOs, result);
    }

    @Test
    void saveCustomer() {
        // Given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1L);
        Customer customer = new Customer();
        customer.setId(1L);

        // When
        Mockito.when(entityMapper.convertCustomer(customerDTO)).thenReturn(customer);
        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
        Mockito.when(entityMapper.convertCustomerDTO(customer)).thenReturn(customerDTO);

        // Then
        CustomerDTO result = customerService.saveCustomer(customerDTO);
        Assertions.assertEquals(customerDTO, result);
    }

    @Test
    void deleteCustomer() {
        // Given
        Long id = 1L;

        // When
        Mockito.doNothing().when(customerRepository).deleteById(id);

        // Then
        customerService.deleteCustomer(id);
        Mockito.verify(customerRepository, Mockito.times(1)).deleteById(id);
    }
}
