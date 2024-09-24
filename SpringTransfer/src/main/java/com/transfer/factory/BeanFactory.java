package com.transfer.factory;

import com.transfer.service.AccountService;
import com.transfer.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {

    private AccountService accountService;

    private TransactionManager txManager;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public TransactionManager getTxManager() {
        return txManager;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     *  获取代理对象
     * @param t1
     * @param <T>
     * @return
     */
//    public <T> T getBean(final T t1) {
//        return (T) Proxy.newProxyInstance(t1.getClass().getClassLoader(), t1.getClass().getInterfaces(), new InvocationHandler() {
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Object rtValue = null;
//                try {
//                    //1.开启事务
//                    txManager.beginTransaction();
//                    //2.执行操作
//                    rtValue = method.invoke(t1, args);
//                    //3.提交事务
//                    txManager.commit();
//                    //4.返回结果
//                    return rtValue;
//                } catch (Exception e) {
//                    //5.回滚操作
//                    txManager.rollback();
//                    throw new RuntimeException(e);
//                } finally {
//                    //6.释放连接
//                    txManager.release();
//                }
//            }
//        });
//    }

    /**
     * 获取Service代理对象
     * @return
     */
    public AccountService getAccountService() {
        return (AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try {
                            //1.开启事务
                            txManager.beginTransaction();
                            //2.执行操作
                            rtValue = method.invoke(accountService, args);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //5.回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            txManager.release();
                        }
                    }
                });

    }
}
