package com.oss_att.accounts.service;

import com.oss_att.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto - CustomerDto Object
     */

    void createAccount(CustomerDto customerDto);
}
