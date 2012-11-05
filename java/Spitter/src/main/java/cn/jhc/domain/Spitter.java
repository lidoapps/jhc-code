package cn.jhc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Spitter
 *
 */
@Entity
@Table(name="spitter",uniqueConstraints= {@UniqueConstraint(columnNames="username")})
public class Spitter implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@TableGenerator(
			name="spitter_gen",
			valueColumnName="spitter_id",
			initialValue=50
			)
	@Id @GeneratedValue(strategy=GenerationType.TABLE, generator="spitter_gen")
	private long id;
	
	private String username;
	private String password;
	private String fullname;
	private String email;
	private boolean updatedByEmail;
	
	@OneToMany(mappedBy="spitter")
	private Collection<Spittle> spittles = new ArrayList<Spittle>();
	
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
   
}
