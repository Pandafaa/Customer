package telran.ashkelon2020.users.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.ashkelon2020.users.dao.CustomerRepository;
import telran.ashkelon2020.users.dto.CustomerDto;
import telran.ashkelon2020.users.exceptions.DocumentExistsException;
import telran.ashkelon2020.users.exceptions.DocumentNotFoundException;
import telran.ashkelon2020.users.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public CustomerDto addCustomer(CustomerDto customerDto) {
		if (customerRepository.existsById(customerDto.getId())) {
			throw new DocumentExistsException();
		}
		Customer customer = modelMapper.map(customerDto, Customer.class);
		customerRepository.save(customer);
		return customerDto;
	}
	@Override
	@Transactional(readOnly = true)
	public CustomerDto findCustomerById(long id) {

		Customer customer = customerRepository.findById(id).orElseThrow(() -> new DocumentNotFoundException());

		return modelMapper.map(customer, CustomerDto.class);
	}
	@Override
	@Transactional
	public CustomerDto updateCustomer(long id, String name) {
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new DocumentNotFoundException());
		customer.setName(name);
		return modelMapper.map(customer, CustomerDto.class);
	}
	@Override
	@Transactional
	public CustomerDto deleteCustomer(long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(()->new DocumentNotFoundException());

		customerRepository.deleteById(id);
		return modelMapper.map(customer, CustomerDto.class);
	}
}
