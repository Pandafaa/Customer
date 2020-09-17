package telran.ashkelon2020.users.dao;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.ashkelon2020.users.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	
	@Query("select a from Account a where a.customer.id = ?1 and a.topic like %?2%")
	Stream<Account> findAccountsInCustomer(Long id,String topic);

}
