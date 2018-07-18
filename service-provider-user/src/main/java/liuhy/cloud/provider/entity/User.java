package liuhy.cloud.provider.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User implements Serializable{

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public User(Long id, String username) {
    super();
    this.id = id;
    this.username = username;
  }
public User(Long id, String username, Short age) {
    super();
    this.id = id;
    this.username = username;
    this.age = age;
  }
  public User() {
    super();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String username;

  @Column
  private String name;

  @Column
  private Short age;

  @Column
  private BigDecimal balance;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Short getAge() {
    return this.age;
  }

  public void setAge(Short age) {
    this.age = age;
  }

  public BigDecimal getBalance() {
    return this.balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
@Override
public String toString() {
	return "User [id=" + id + ", username=" + username + "]";
}
  
  
}
