package trip_scheduling.project.entities;

import javax.persistence.*;

@Entity
@Table
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_admin;
	private String email;
	private String password;
	
	
	public Admin()
	{
		
	}
	public Admin(String email, String password) {
		
		this.email = email;
		this.password = password;
	}
	
	
	public String getEmail() {
		return email;
	}
	

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getIdAdmin() {
		return id_admin;
	}

	public void setIdAdmin(Long id_admin) {
		this.id_admin = id_admin;
	}

	
	
	

}