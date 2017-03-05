package com.taskmanager.web;

import java.util.List;

import com.taskmanager.entities.Account;
import com.taskmanager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

  @Autowired
  private AccountService accountService;

  @PostMapping
  public List<Account> list() {
    return accountService.getAccounts();
  }

  @PostMapping(value = "/{accountId}")
  public Account getById(@PathVariable Long accountId) {
    return accountService.get(accountId);
  }

}
