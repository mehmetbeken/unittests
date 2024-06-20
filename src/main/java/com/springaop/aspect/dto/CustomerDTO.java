package com.springaop.aspect.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDTO {

    private Long id;
    private String customerName;
    private List<AccountDTO> accountList;
}
