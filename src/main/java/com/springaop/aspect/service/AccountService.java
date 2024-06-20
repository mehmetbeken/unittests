package com.springaop.aspect.service;

import com.springaop.aspect.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> getAccountList();
    AccountDTO getAccount(Long id);
    AccountDTO saveAccount(AccountDTO accountDTO);
    void deleteAccount(Long id);
}
