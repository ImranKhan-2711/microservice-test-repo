package com.example.demo.repo;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	@Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
	public Account findByAccountNumber(@Param("accountNumber") BigInteger accountNumber );
	
	@Query("SELECT a FROM Account a WHERE a.name = :name")
	public Account findByName(@Param("name") String name );
	
	
	@Query("SELECT a FROM Account a WHERE a.userId = :userId")
	public Account findByUserId(@Param("userId") Integer userId );
	
}
