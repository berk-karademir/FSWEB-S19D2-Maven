package com.workintech.s18d4.controller;


import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;
    private CustomerService customerService;

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable("id") Long id) {
        return accountService.findById(id);
    }

    @PostMapping("/{customerId}")
    public AccountResponse save(@PathVariable("customerId") Long customerId, @RequestBody Account account) {
        Customer foundCustomer = customerService.findById(customerId);
        if(foundCustomer != null) {
            foundCustomer.getAccounts().add(account);
            account.setCustomer(foundCustomer);
            accountService.save(account);
        } else {
            throw new RuntimeException("Customer can not found!");
        }
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(foundCustomer.getId(), foundCustomer.getEmail(), foundCustomer.getSalary()));
    }

    @PutMapping("/{customerId}")
    public AccountResponse update(@RequestBody Account account, @PathVariable long customerId) {
        Customer customer = customerService.findById(customerId);
        Account toBeUpdatedAccount = null;
        for (Account account1 : customer.getAccounts()) {
            if (account.getId() == account1.getId()) {
                toBeUpdatedAccount = account1;
            }
        }
        if (toBeUpdatedAccount == null) {
            throw new RuntimeException("Account(" + account.getId() + ") not found for this customer: " + customerId);
        }

        int indexOfFound = customer.getAccounts().indexOf(toBeUpdatedAccount);
        customer.getAccounts().set(indexOfFound, account);
        account.setCustomer(customer);
        accountService.save(account);
        return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
                new CustomerResponse(customer.getId(), customer.getEmail(), customer.getSalary()));
    }
    @DeleteMapping("/{id}")
    public AccountResponse remove(@PathVariable("id") Long id) {
        Account foundAccount = accountService.findById(id);
        if(foundAccount == null) {
            throw new RuntimeException("Can not find account with id: " + id);
        }
        accountService.delete(id);
        return new AccountResponse((foundAccount.getId()), foundAccount.getAccountName(), foundAccount.getMoneyAmount(),
                new CustomerResponse(foundAccount.getId(),
                        foundAccount.getCustomer().getEmail(), foundAccount.getCustomer().getSalary()));
    }





}
