package me.doflamingo.springbootredis;

import me.doflamingo.springbootredis.accounts.Account;
import me.doflamingo.springbootredis.accounts.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("doflamingo","bosuksh");
        values.set("Springboot","2.0");
        values.set("Hello","World") ;

        Account account = new Account();
        account.setEmail("doflamingo@example.com");
        account.setUsername("doflamingo");

        accountRepository.save(account);

        Optional<Account> byId = accountRepository.findById(account.getId());
        System.out.println(byId.get().getEmail());
        System.out.println(byId.get().getUsername());
    }
}
