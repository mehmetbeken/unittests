package com.springaop.aspect.service.impl;

import com.springaop.aspect.dto.AccountDTO;
import com.springaop.aspect.mapper.EntityMapper;
import com.springaop.aspect.repository.AccountRepository;
import com.springaop.aspect.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final EntityMapper entityMapper;

    @Override
    public List<AccountDTO> getAccountList() {
        return entityMapper.convertAccountDTOList(accountRepository.findAll());
    }

    @Override
    public AccountDTO getAccount(Long id) {
        return entityMapper.convertAccountDTO(accountRepository.findById(id).orElse(null));
    }

    @Override
    public AccountDTO saveAccount(AccountDTO accountDTO) {
        return entityMapper.convertAccountDTO(accountRepository.save(entityMapper.convertAccount(accountDTO)));
    }

    @Override
    public void deleteAccount(Long id) {

        accountRepository.deleteById(id);
    }
}
