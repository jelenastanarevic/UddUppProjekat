package UddUpp.NaucnaCentrala.DTO;

public class RegisterDTO {
	
	private String first_name;
	private String last_name;
	private String email;
	private String country;
	private String city;
	
	
	public RegisterDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public RegisterDTO(String first_name, String last_name, String email, String country, String city) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.country = country;
		this.city = city;
	}
	
	

}
