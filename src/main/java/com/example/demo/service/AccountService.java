package com.example.demo.service;

import com.example.demo.domain.Account;
import com.example.demo.domain.Admin;
import com.example.demo.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account getAccount(String username){
        return accountMapper.getAccountByUsername(username);
    }

    public Account getAccount(String username, String password){
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return accountMapper.getAccountByUsernameAndPassword(account);
    }

    public List<Account> getAccountList(){
        return accountMapper.getAccountList();
    }
    public List<Admin> getAdminList(){
        return accountMapper.getAdminList();
    }
    public Admin getAdminById(String admin){
        return accountMapper.getAdminById(admin);
    }

    /*
        声明式事务处理
     */
    @Transactional
    public void insertAccount(Account account){
        accountMapper.insertAccount(account);
        accountMapper.insertProfile(account);
        accountMapper.insertSignon(account);
    }

    public void updateAccount(Account account){
        accountMapper.updateAccount(account);
        accountMapper.updateProfile(account);

        if(account.getPassword() != null && account.getPassword().length() > 0){
            accountMapper.updateSignon(account);
        }
    }

    public void updateAdmin(Admin admin){
        accountMapper.updateAdmin(admin);
    }


}
