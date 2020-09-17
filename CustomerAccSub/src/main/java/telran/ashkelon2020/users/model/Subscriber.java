package telran.ashkelon2020.users.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "subscriberId" })
@Entity
public class Subscriber {
	@Id
	Long  subscriberId;
	String subscriberName;
	
//	@ManyToMany
//	@JoinTable(name = "SUBSCRIBER_ACCOUNTS",
//			joinColumns = @JoinColumn(name = "SUBSCRIBER_ID"),
//			inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ID")
//	)
	
	@ManyToOne
	
Account account;

	

}
