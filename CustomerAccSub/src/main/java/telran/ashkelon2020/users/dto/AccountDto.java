package telran.ashkelon2020.users.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {
	Long accountId;
	String topic;
	Long customerId;
//	@JsonIgnoreProperties("accounts")
//	CustomerDto customer;
//	Set<SubscriberDto> subscribers;

}
