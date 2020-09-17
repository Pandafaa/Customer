package telran.ashkelon2020.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.ashkelon2020.users.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,  Long> {
	

}
