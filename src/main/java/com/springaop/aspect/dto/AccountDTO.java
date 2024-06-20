package com.springaop.aspect.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {

    private Long id;
    private String accountName;
    private String accountNumber;
    private CustomerDTO customer;
}
