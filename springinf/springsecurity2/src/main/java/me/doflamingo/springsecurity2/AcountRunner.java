package me.doflamingo.springsecurity2;

import me.doflamingo.springsecurity2.account.Account;
import me.doflamingo.springsecurity2.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AcountRunner implements ApplicationRunner {

    @Autowired
    private AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = accountService.createAccount("doflamingo", "1234");
        System.out.println(account.getUsername()+" password: "+ account.getPassword());
    }
}
