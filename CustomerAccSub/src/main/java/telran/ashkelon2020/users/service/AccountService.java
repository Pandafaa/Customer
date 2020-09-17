package telran.ashkelon2020.users.service;

import telran.ashkelon2020.users.dto.AccountDto;

public interface AccountService {

	AccountDto addAccount(AccountDto account);
	AccountDto findAccountById(long accountId);
	AccountDto updateAccount(long id, String topic);
	AccountDto deleteAccount(long accountId);

	//find account by customer id and containing topic
	Iterable<AccountDto> findAccountsInCustomer(Long id, String topic);
	
	Iterable<AccountDto> findAllCustomerAccounts(Long id);

}
