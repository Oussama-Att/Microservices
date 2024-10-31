package com.att.E_bank_account_service.service;

import com.att.E_bank_account_service.dto.BankAccountRequestDto;
import com.att.E_bank_account_service.dto.BankAccountResponseDto;
import com.att.E_bank_account_service.entities.BankAccount;

public interface AccountService {
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountDto);
}
