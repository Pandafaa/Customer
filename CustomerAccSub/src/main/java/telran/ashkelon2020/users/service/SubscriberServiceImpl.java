package telran.ashkelon2020.users.service;

import java.util.Set;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import telran.ashkelon2020.users.dao.AccountRepository;
import telran.ashkelon2020.users.dao.CustomerRepository;
import telran.ashkelon2020.users.dao.SubscriberRepository;
import telran.ashkelon2020.users.dto.CustomerDto;
import telran.ashkelon2020.users.dto.SubscriberDto;
import telran.ashkelon2020.users.dto.SubscriberResponseDto;
import telran.ashkelon2020.users.exceptions.DocumentExistsException;
import telran.ashkelon2020.users.exceptions.DocumentNotFoundException;
import telran.ashkelon2020.users.model.Account;
import telran.ashkelon2020.users.model.Customer;
import telran.ashkelon2020.users.model.Subscriber;

@Service
public class SubscriberServiceImpl implements SubscriberService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	SubscriberRepository subscriberRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	@Transactional
	public SubscriberResponseDto addSubscriber(SubscriberDto subsciberDto) {
		if (subscriberRepository.existsById(subsciberDto.getSubscriberId())) { // subscriber can't exist without account
			throw new DocumentExistsException();
		}
		Account account = accountRepository.findById(subsciberDto.getAccountId()).orElseThrow(()->new DocumentNotFoundException());
		Subscriber subscriber = new Subscriber(subsciberDto.getSubscriberId(), subsciberDto.getSubscriberName(),
				account);
		subscriberRepository.save(subscriber);

		return modelMapper.map(subscriber, SubscriberResponseDto.class);
	}

	@Override
	@Transactional(readOnly = true)
	public SubscriberResponseDto findSubscriberById(long subsciberId) {
		Subscriber subscriber = subscriberRepository.findById(subsciberId)
				.orElseThrow(() -> new DocumentNotFoundException());
		return modelMapper.map(subscriber, SubscriberResponseDto.class);
	}

	@Override
	@Transactional
	public SubscriberResponseDto updateSubscriber(long id, String subscriberName) {
		Subscriber subscriber = subscriberRepository.findById(id).orElseThrow(() -> new DocumentNotFoundException());
		subscriber.setSubscriberName(subscriberName);
		return modelMapper.map(subscriber, SubscriberResponseDto.class);
	}

	@Override
	@Transactional
	public SubscriberResponseDto deleteSubscriber(long subsciberId) {
		Subscriber subscriber = subscriberRepository.findById(subsciberId)
				.orElseThrow(() -> new DocumentNotFoundException());
		subscriberRepository.delete(subscriber);
		return modelMapper.map(subscriber, SubscriberResponseDto.class);
	}

	//finds subscribers with name like
	@Override
	@Transactional(readOnly = true)
	public Iterable<SubscriberResponseDto> findSubscribersByName(String name) {

		return subscriberRepository.findBySubscriberNameLike("%" + name + "%")
				.map(s -> modelMapper.map(s, SubscriberResponseDto.class)).collect(Collectors.toList());

	}

}
