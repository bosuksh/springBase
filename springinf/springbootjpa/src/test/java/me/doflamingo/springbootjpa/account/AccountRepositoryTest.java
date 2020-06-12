package me.doflamingo.springbootjpa.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
//@SpringBootTest
class AccountRepositoryTest {


    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void di() throws SQLException {
        try(Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }

    @Test
    public void repositoryTest() {
        Account account = new Account();
        account.setUsername("doflamingo");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);

        assertThat(newAccount).isNotNull();

        Optional<Account> existingAccount = accountRepository.findByUsername("doflamingo");
        assertThat(existingAccount).isNotEmpty();
        Optional<Account> nonExistingAccount = accountRepository.findByUsername("bosuksh");
        assertThat(nonExistingAccount).isEmpty();

    }
}