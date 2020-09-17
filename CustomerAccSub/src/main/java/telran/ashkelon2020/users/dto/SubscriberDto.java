package telran.ashkelon2020.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import telran.ashkelon2020.users.model.Account;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubscriberDto {
	Long subscriberId;
	String subscriberName;
 Long accountId;


}
