package com.oss_att.accounts.service.impl;

import com.oss_att.accounts.dto.CustomerDto;
import com.oss_att.accounts.repository.AccountsRepository;
import com.oss_att.accounts.repository.CustomerRepository;
import com.oss_att.accounts.service.IAccountsService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
