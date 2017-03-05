package com.taskmanager.service;

import java.util.List;

import com.taskmanager.entities.Account;
import com.taskmanager.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  @Autowired
  private AccountRepository accountRepository;

  public List<Account> getAccounts() {
    return accountRepository.findAll();
  }

  public Account get(Long accountId) {
    return accountRepository.findOne(accountId);
  }

}
