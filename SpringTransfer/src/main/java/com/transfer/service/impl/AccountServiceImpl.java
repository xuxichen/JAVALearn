package com.transfer.service.impl;

import com.transfer.dao.AccountDao;
import com.transfer.domain.Account;
import com.transfer.service.AccountService;
import com.transfer.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 *
 * 事务控制应该都是在业务层
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    private TransactionManager txManager;

    public TransactionManager getTxManager() {
        return txManager;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public Account findAccountByName(String accountName) {
        return accountDao.findAccountByName(accountName);
    }

    public void transfer(String sourceName, String targetName, Float money) {

        System.out.println("transfer....");
        // 根据姓名查询转出用户
        Account source = accountDao.findAccountByName(sourceName);
        // 根据姓名查询转入用户
        Account target = accountDao.findAccountByName(targetName);
        // 转出账户减钱
        source.setBalance(source.getBalance()-money);
        accountDao.updateAccount(source);

        // 转入账户加钱
        target.setBalance(target.getBalance()+money);
        accountDao.updateAccount(target);
    }
}
