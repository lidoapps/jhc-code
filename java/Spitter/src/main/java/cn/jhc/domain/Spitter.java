package cn.jhc.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Spitter
 *
 */
@Entity
@Table(name="spitter")
public class Spitter implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id 
	private long id;
	
	private String username;
	private String password;
	private String email;
	private boolean updatedByEmail;
	
	public Spitter() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUpdatedByEmail() {
		return updatedByEmail;
	}

	public void setUpdatedByEmail(boolean updatedByEmail) {
		this.updatedByEmail = updatedByEmail;
	}

	public long getId() {
		return id;
	}
   
}
