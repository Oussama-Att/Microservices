package com.att.E_bank_account_service.service;

import com.att.E_bank_account_service.dto.BankAccountRequestDto;
import com.att.E_bank_account_service.dto.BankAccountResponseDto;
import com.att.E_bank_account_service.entities.BankAccount;
import com.att.E_bank_account_service.mappers.AccountMapper;
import com.att.E_bank_account_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    AccountMapper accountMapper;
    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto) {
        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDto.getBalance())
                .type(bankAccountDto.getType())
                .currency(bankAccountDto.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDto bankAccountResponseDto = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDto;
    }
}
