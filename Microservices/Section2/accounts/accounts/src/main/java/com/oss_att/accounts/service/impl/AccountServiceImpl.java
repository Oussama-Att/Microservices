package com.oss_att.accounts.service.impl;

import com.oss_att.accounts.constans.AccountsConstants;
import com.oss_att.accounts.dto.CustomerDto;
import com.oss_att.accounts.entity.Accounts;
import com.oss_att.accounts.entity.Customer;
import com.oss_att.accounts.exception.CustomerAlreadyExistsException;
import com.oss_att.accounts.repository.AccountsRepository;
import com.oss_att.accounts.repository.CustomerRepository;
import com.oss_att.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    /**
     *
     * @param customerDto -CustomerDto Object
     */

    @Override
    public void createAccount(CustomerDto customerDto) {
    Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());
    Optional<Customer> optionalCustomer=customerRepository.findByMobileNumber(customerDto.getMobileNumber());
    if(optionalCustomer.isPresent()){
        throw new CustomerAlreadyExistsException("Customer already registered with this mobile" + customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("oussama");
        Customer savedCustomer = customerRepository.save(customer);
       //accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("oussama");
        return newAccount;
    }

}
