package com.springaop.aspect.service.impl;

import com.springaop.aspect.dto.AccountDTO;
import com.springaop.aspect.mapper.EntityMapper;
import com.springaop.aspect.model.Account;
import com.springaop.aspect.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private EntityMapper entityMapper;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    void getAccountList() {
        // Given
        List<Account> accountEntities = new ArrayList<>();
        Account account = new Account();
        account.setId(1L);
        accountEntities.add(account);

        List<AccountDTO> accountDTOs = new ArrayList<>();
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(1L);
        accountDTOs.add(accountDTO);

        // When
        Mockito.when(accountRepository.findAll()).thenReturn(accountEntities);
        Mockito.when(entityMapper.convertAccountDTOList(accountEntities)).thenReturn(accountDTOs);

        // Then
        List<AccountDTO> result = accountService.getAccountList();
        Assertions.assertEquals(accountDTOs, result);
    }

    @Test
    void getAccount() {
        // Given
        Long id = 1L;
        Account account = new Account();
        account.setId(id);
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(id);

        // When
        Mockito.when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        Mockito.when(entityMapper.convertAccountDTO(account)).thenReturn(accountDTO);

        // Then
        AccountDTO result = accountService.getAccount(id);
        Assertions.assertEquals(accountDTO, result);
    }

    @Test
    void saveAccount() {
        // Given
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setId(1L);
        Account account = new Account();
        account.setId(1L);

        // When
        Mockito.when(entityMapper.convertAccount(accountDTO)).thenReturn(account);
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        Mockito.when(entityMapper.convertAccountDTO(account)).thenReturn(accountDTO);

        // Then
        AccountDTO result = accountService.saveAccount(accountDTO);
        Assertions.assertEquals(accountDTO, result);
    }

    @Test
    void deleteAccount() {
        // Given
        Long id = 1L;

        // When
        Mockito.doNothing().when(accountRepository).deleteById(id);

        // Then
        accountService.deleteAccount(id);
        Mockito.verify(accountRepository, Mockito.times(1)).deleteById(id);
    }
}