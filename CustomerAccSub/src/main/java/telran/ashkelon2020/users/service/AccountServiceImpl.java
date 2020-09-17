package telran.ashkelon2020.users.service;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.ashkelon2020.users.dao.AccountRepository;
import telran.ashkelon2020.users.dao.CustomerRepository;
import telran.ashkelon2020.users.dao.SubscriberRepository;
import telran.ashkelon2020.users.dto.AccountDto;
import telran.ashkelon2020.users.exceptions.DocumentExistsException;
import telran.ashkelon2020.users.exceptions.DocumentNotFoundException;
import telran.ashkelon2020.users.model.Account;
import telran.ashkelon2020.users.model.Customer;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	SubscriberRepository subscriberRepository;

	@Autowired
	ModelMapper modelMapper;
	@Override
	@Transactional
	public AccountDto addAccount(AccountDto accountDto) {
		if (accountRepository.existsById(accountDto.getAccountId())) {
			throw new DocumentExistsException();
		}

		Customer customer = customerRepository.findById(accountDto.getCustomerId())
				.orElseThrow(() -> new DocumentNotFoundException());
		Account account = new Account(accountDto.getAccountId(), accountDto.getTopic());
		account.setCustomer(customer);
//		customer.

		accountRepository.save(account);
		return accountDto;
	}

	@Override
	@Transactional(readOnly = true)
	public AccountDto findAccountById(long accountId) {
		Account account = accountRepository.findById(accountId).orElseThrow(() -> new DocumentNotFoundException());
		return modelMapper.map(account, AccountDto.class);
	}
	
	@Override
	@Transactional
	public AccountDto updateAccount(long id, String topic) {
		Account account = accountRepository.findById(id).orElseThrow(() -> new DocumentNotFoundException());
account.setTopic(topic);
		return modelMapper.map(account, AccountDto.class);
	}
	@Override
	@Transactional
	public AccountDto deleteAccount(long accountId) {
		Account account = accountRepository.findById(accountId).orElseThrow(() -> new DocumentNotFoundException());
//		account.getSubscribers().forEach(s->s.getAccounts().remove(account));
		accountRepository.delete(account);
		return modelMapper.map(account, AccountDto.class);
	}
	
	

	@Override
	@Transactional(readOnly = true)
	public Iterable<AccountDto> findAccountsInCustomer(Long id, String topic) {
		return	accountRepository.findAccountsInCustomer(id, topic).map(a->modelMapper.map(a, AccountDto.class))
				.collect(Collectors.toList());
				
		 
	}



}
