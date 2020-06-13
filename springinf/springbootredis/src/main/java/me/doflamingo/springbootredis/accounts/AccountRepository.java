package me.doflamingo.springbootredis.accounts;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,String > {
}
