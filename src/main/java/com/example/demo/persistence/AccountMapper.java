package com.example.demo.persistence;

import com.example.demo.domain.Account;
import com.example.demo.domain.Admin;
import com.example.demo.domain.Category;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {

    Account getAccountByUsername(String username);

    Account getAccountByUsernameAndPassword(Account account);

    Admin getAdminById(String AdminId);

    List<Account> getAccountList();

    List<Admin> getAdminList();

    void insertAccount(Account account);

    void insertProfile(Account account);

    void insertSignon(Account account);

    void updateAccount(Account account);

    void updateProfile(Account account);

    void updateSignon(Account account);

    void updateAdmin(Admin admin);
}
