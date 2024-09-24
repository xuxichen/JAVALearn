package com.transfer;

import com.transfer.domain.Account;
import com.transfer.service.AccountService;
import com.transfer.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Resource(name = "proxyAccountService")
    private AccountService as;

    @Test
    public void transfer() {
        as.transfer("zhangsan","lisi",100f);
//        List<Account> allAccount = as.findAllAccount();
//        System.out.println(allAccount);
    }

}
