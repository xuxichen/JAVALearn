package com.transfer.service;

import com.transfer.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    public List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    public Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    public void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    public void updateAccount(Account account);

    /**
     * 删除
     * @param acccountId
     */
    public void deleteAccount(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return  如果有唯一的一个结果就返回，如果没有结果就返回null
     *          如果结果集超过一个就抛异常
     */
    public Account findAccountByName(String accountName);

    /**
     * 转账
     * @param sourceName 转出用户
     * @param targetName 转入用户
     * @param money 转账金额
     */
    public void transfer(String sourceName, String targetName, Float money);
}
