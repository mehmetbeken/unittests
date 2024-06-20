package com.springaop.aspect.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerName;

//    @OneToMany(mappedBy = "customer")
//    private List<Account> accountList;
}
