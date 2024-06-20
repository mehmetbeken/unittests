package com.springaop.aspect.mapper;

import com.springaop.aspect.dto.AccountDTO;
import com.springaop.aspect.dto.CustomerDTO;
import com.springaop.aspect.model.Account;
import com.springaop.aspect.model.Customer;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class EntityMapper {

    private final ModelMapper modelMapper;

    public EntityMapper() {
        this.modelMapper = new ModelMapper();
    }

    public CustomerDTO convertCustomerDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    public List<CustomerDTO> convertCustomerDTOList(List<Customer> customerList) {
        return customerList.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .toList();
    }

    public Customer convertCustomer(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, Customer.class);
    }

    public AccountDTO convertAccountDTO(Account account) {
        return modelMapper.map(account, AccountDTO.class);
    }

    public List<AccountDTO> convertAccountDTOList(List<Account> accountList) {
        return accountList.stream()
                .map(account -> modelMapper.map(account, AccountDTO.class))
                .toList();
    }

    public Account convertAccount(AccountDTO accountDTO) {
        return modelMapper.map(accountDTO, Account.class);
    }
}
