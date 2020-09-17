package telran.ashkelon2020.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2020.users.dto.AccountDto;
import telran.ashkelon2020.users.dto.CustomerDto;
import telran.ashkelon2020.users.dto.SubscriberDto;
import telran.ashkelon2020.users.dto.SubscriberResponseDto;
import telran.ashkelon2020.users.service.AccountService;
import telran.ashkelon2020.users.service.CustomerService;
import telran.ashkelon2020.users.service.SubscriberService;

@RestController

public class UsersController {

	@Autowired
CustomerService customerService;
	@Autowired
	AccountService accountService;
	@Autowired
	SubscriberService subsccriberService;
	
	@PostMapping("/customer")
	CustomerDto addCustomer(@RequestBody CustomerDto customer) {
		return customerService.addCustomer(customer);
	}

	@PostMapping("/account")
	AccountDto addAccount(@RequestBody AccountDto account) {
		return accountService.addAccount(account);
	}

	@PostMapping("/subscriber")
	SubscriberResponseDto addSubscriber(@RequestBody SubscriberDto subsciber) {
		return subsccriberService.addSubscriber(subsciber);

	}

	@GetMapping("/customer/{id}")
	CustomerDto findCustomerById(@PathVariable long id) {
		return customerService.findCustomerById(id);
	}

	@GetMapping("/account/{accountId}")
	AccountDto findAccountById(@PathVariable long accountId) {
		return accountService.findAccountById(accountId);
	}

	@GetMapping("/subscriber/{subsciberId}")
	SubscriberResponseDto findSubscriberById(@PathVariable long subsciberId) {
		return subsccriberService.findSubscriberById(subsciberId);
	}

	@PutMapping("/customer/{id}/{name}")
	CustomerDto udateCustomer(@PathVariable long id, @PathVariable String name) {
		return customerService.updateCustomer(id, name);
	}

	@PutMapping("/account/{id}/{topic}")
	AccountDto updateAccount(@PathVariable long id, @PathVariable String topic) {
		return accountService.updateAccount(id, topic);
	}

	@PutMapping("/subscriber/{id}/{name}")
	SubscriberResponseDto updateSubscriber(@PathVariable long id,@PathVariable String name) {
		return subsccriberService.updateSubscriber(id, name);

	}

	@DeleteMapping("/customer/{id}")
	CustomerDto deleteCustomer(@PathVariable  long id) {
		return customerService.deleteCustomer(id);
	}
	@DeleteMapping("/account/{accountId}")
	AccountDto deleteAccount(@PathVariable long accountId) {
		return accountService.deleteAccount(accountId);
	}
	@DeleteMapping	("/subscriber/{subsciberId}")
	SubscriberResponseDto deleteSubscriber(@PathVariable long subsciberId) {
		return subsccriberService.deleteSubscriber(subsciberId);
	}

	// find subscribers
	@GetMapping("/subscriber/find/{name}")
	Iterable<SubscriberResponseDto> findSubscribersByName(@PathVariable String name){
		return subsccriberService.findSubscribersByName(name);
		
	}

	// find account by customer id and topic like

	@GetMapping("/account/find/{id}/{topic}")
	Iterable<AccountDto> findAccountsInCustomer(@PathVariable long id,@PathVariable String topic){
		return accountService.findAccountsInCustomer(id, topic);
		
	}

}
