package telran.ashkelon2020.users.dao;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;

import telran.ashkelon2020.users.model.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
	Stream<Subscriber>  findBySubscriberNameLike(String subscriberName);
	

}
