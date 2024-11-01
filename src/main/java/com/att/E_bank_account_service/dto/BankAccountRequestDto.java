package com.att.E_bank_account_service.dto;

import com.att.E_bank_account_service.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountRequestDto {
    private Double balance;
    private String currency;
    private AccountType type;
}
