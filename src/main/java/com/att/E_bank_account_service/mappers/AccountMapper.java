package com.att.E_bank_account_service.mappers;

import com.att.E_bank_account_service.dto.BankAccountResponseDto;
import com.att.E_bank_account_service.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDto fromBankAccount(BankAccount bankAccount) {
        BankAccountResponseDto bankAccountResponseDto = new BankAccountResponseDto();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDto);
        return bankAccountResponseDto;
    }
}
