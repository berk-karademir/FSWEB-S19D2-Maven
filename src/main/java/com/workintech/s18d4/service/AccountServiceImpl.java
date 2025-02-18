package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        Optional<Account> foundAccount = accountRepository.findById(id);
        if(foundAccount.isPresent()) {
            return foundAccount.get();
        }
        return null;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(Long id) {
        Optional<Account> foundAccount = accountRepository.findById(id);

        if(foundAccount.isEmpty()) {
            return null;
        }
        accountRepository.delete(foundAccount.get());
        return foundAccount.get();
    }
}
