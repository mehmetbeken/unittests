package com.springaop.aspect.controller;

import com.springaop.aspect.dto.CustomerDTO;
import com.springaop.aspect.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("customerController")
@RequestMapping("/api/customer/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("listing")
    public ResponseEntity<List<CustomerDTO>> getCustomerList() {

        return ResponseEntity.ok(customerService.getCustomerList());
    }

    @PostMapping("save")
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO) {

        return ResponseEntity.ok(customerService.saveCustomer(customerDTO));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
}
