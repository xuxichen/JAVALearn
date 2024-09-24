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
public class AccountServiceImpl_OLD implements AccountService {

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

//        return accountDao.findAllAccount();

        try {
            // 1、开启事物
            txManager.beginTransaction();
            // 2、执行操作
            List<Account> allAccount = accountDao.findAllAccount();
            // 3、提交事物
            txManager.commit();
            // 4、返回结果
            return allAccount;
        } catch (Exception e) {
            // 5、回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6、释放连接
            txManager.release();
        }

    }

    public Account findAccountById(Integer accountId) {
//        return accountDao.findAccountById(accountId);
        try {
            // 1、开启事物
            txManager.beginTransaction();
            // 2、执行操作
            Account account = accountDao.findAccountById(accountId);
            // 3、提交事物
            txManager.commit();
            // 4、返回结果
            return account;
        } catch (Exception e) {
            // 5、回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6、释放连接
            txManager.release();
        }
    }

    public void saveAccount(Account account) {
//        accountDao.saveAccount(account);

        try {
            // 1、开启事物
            txManager.beginTransaction();
            // 2、执行操作
            accountDao.saveAccount(account);
            // 3、提交事物
            txManager.commit();
            // 4、返回结果
        } catch (Exception e) {
            // 5、回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6、释放连接
            txManager.release();
        }

    }

    public void updateAccount(Account account) {
//        accountDao.updateAccount(account);
        try {
            // 1、开启事物
            txManager.beginTransaction();
            // 2、执行操作
            accountDao.updateAccount(account);
            // 3、提交事物
            txManager.commit();
            // 4、返回结果
        } catch (Exception e) {
            // 5、回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6、释放连接
            txManager.release();
        }
    }

    public void deleteAccount(Integer accountId) {
//        accountDao.deleteAccount(acccountId);
        try {
            // 1、开启事物
            txManager.beginTransaction();
            // 2、执行操作
            accountDao.deleteAccount(accountId);
            // 3、提交事物
            txManager.commit();
            // 4、返回结果
        } catch (Exception e) {
            // 5、回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6、释放连接
            txManager.release();
        }
    }

    public Account findAccountByName(String accountName) {
//        return accountDao.findAccountByName(accountName);
        try {
            // 1、开启事物
            txManager.beginTransaction();
            // 2、执行操作
            Account account = accountDao.findAccountByName(accountName);
            // 3、提交事物
            txManager.commit();
            // 4、返回结果
            return account;
        } catch (Exception e) {
            // 5、回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6、释放连接
            txManager.release();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {

//        System.out.println("transfer....");
//        // 根据姓名查询转出用户
//        Account source = accountDao.findAccountByName(sourceName);
//        // 根据姓名查询转入用户
//        Account target = accountDao.findAccountByName(targetName);
//        // 转出账户减钱
//        source.setBalance(source.getBalance()-money);
//        accountDao.updateAccount(source);
//
//        // 转入账户加钱
//        target.setBalance(target.getBalance()+money);
//        accountDao.updateAccount(target);

        try {
            // 1、开启事物
            txManager.beginTransaction();
            // 2、执行操作
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
            // 3、提交事物
            txManager.commit();
            // 4、返回结果
        } catch (Exception e) {
            // 5、回滚操作
            txManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6、释放连接
            txManager.release();
        }

    }
}
