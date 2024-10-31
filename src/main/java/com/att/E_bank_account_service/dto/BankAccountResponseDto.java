package com.att.E_bank_account_service.dto;

import com.att.E_bank_account_service.enums.AccountType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountResponseDto {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType type;
}
