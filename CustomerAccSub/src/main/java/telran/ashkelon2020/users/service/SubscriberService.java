package telran.ashkelon2020.users.service;

import telran.ashkelon2020.users.dto.SubscriberDto;
import telran.ashkelon2020.users.dto.SubscriberResponseDto;

public interface SubscriberService {

	SubscriberResponseDto addSubscriber(SubscriberDto subsciber);

	SubscriberResponseDto findSubscriberById(long subsciberId);

	SubscriberResponseDto updateSubscriber(long id, String subscriberName);

	SubscriberResponseDto deleteSubscriber(long subsciberId);

	// find subscribers
	Iterable<SubscriberResponseDto> findSubscribersByName(String name);

}
