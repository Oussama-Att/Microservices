package com.oss_att.accounts.service;

import com.oss_att.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto - CustomerDto Object
     */

    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber -Input Mobile Number
     * @return Accounts Details on a given mobileNumber
     */

    CustomerDto fetchAccount(String mobileNumber);
}
