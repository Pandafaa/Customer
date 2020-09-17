package telran.ashkelon2020.users.service;

import telran.ashkelon2020.users.dto.CustomerDto;

public interface CustomerService {
	CustomerDto addCustomer(CustomerDto customer);

	CustomerDto findCustomerById(long id);

	CustomerDto updateCustomer(long id, String name);

	CustomerDto deleteCustomer(long id);
	


}
