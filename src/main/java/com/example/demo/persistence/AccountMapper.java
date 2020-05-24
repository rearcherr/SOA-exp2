package com.example.demo.persistence;

import com.example.demo.domain.Account;
import com.example.demo.domain.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {

    Account getAccountByUsername(String username);

    Account getAccountByUsernameAndPassword(Account account);

    List<Account> getAccountList();

    void insertAccount(Account account);

    void insertProfile(Account account);

    void insertSignon(Account account);

    void updateAccount(Account account);

    void updateProfile(Account account);

    void updateSignon(Account account);
}
