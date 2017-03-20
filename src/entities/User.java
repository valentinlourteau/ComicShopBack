package entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class User extends Personne implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String pwd;
	
	@Column(name = "EMAIL")
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
