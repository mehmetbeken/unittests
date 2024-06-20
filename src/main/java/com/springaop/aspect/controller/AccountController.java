package com.springaop.aspect.controller;

import com.springaop.aspect.dto.AccountDTO;
import com.springaop.aspect.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("accountController")
@RequestMapping("/api/account/")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("listing")
    public ResponseEntity<List<AccountDTO>> getAccountList() {

        return ResponseEntity.ok(accountService.getAccountList());
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountDTO> getAccountList(@PathVariable Long id) {

        return ResponseEntity.ok(accountService.getAccount(id));
    }

    @PostMapping("save")
    public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO accountDTO) {

        return ResponseEntity.ok(accountService.saveAccount(accountDTO));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }
}
