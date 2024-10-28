package com.oss_att.accounts.service.impl;

import com.oss_att.accounts.dto.CustomerDto;
import com.oss_att.accounts.entity.Customer;

public class CustomerMapper {
    public CustomerDto mapToCustomerDto(Customer customer, CustomerDto customerDto) {
    customerDto.setName(customerDto.getName());
    customerDto.setEmail(customerDto.getEmail());
    customerDto.setMobileNumber(customer.getMobileNumber() );
    return customerDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
