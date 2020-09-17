package telran.ashkelon2020.users.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"accountId"})
@Entity
@ToString
public class Account {
	@Id
	Long accountId;
	
	String topic;
	
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id" )
	Customer customer;
//	@ManyToMany(mappedBy = "accounts")  //subriber is a child of account
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL) 
	Set<Subscriber> subscribers; 

	public Account(Long accountId, String topic) {
	
		this.accountId = accountId;
		this.topic = topic;
	}
}
