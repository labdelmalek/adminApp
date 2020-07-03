package org.test.entity;


public class Agence  {
	
    @Override
	public String toString() {
		return "Agence [id=" + id + ", name=" + name + ", country=" + country + ", adresse=" + adresse + ", email="
				+ email + ", phone=" + phone + ", fax=" + fax + ", numagence=" + numagence + "]";
	}

	private Long id;
	
	
	
//	@NotNull(message = "name cannot be null.") 
	//@NotBlank(message = "name cannot be null.")
	private String name;
	
//	@NotNull(message = "country cannot be null.") 
	//@NotBlank(message = "country cannot be null.")
	private String country;
	
	//@Column(name="adresse" ,unique=true)
	//@NotNull(message = "adresse cannot be null.") 
	//@NotBlank(message = "adresse cannot be null.")
	private String adresse;
	
	//@Column(name="email" ,unique=true)
	//@NotNull(message = "email cannot be null.")
	//@NotBlank(message = "email cannot be null.")
	//@Email(message = "Enter a valid email address.") 
	private String email;
	
	//@Column(name="phone" ,unique=true)
	//@NotNull(message = "phone cannot be null.") 
	//@NotBlank(message = "phone cannot be null.")
	//@Size(min=10, max=10,message = "Phone must contains at least 9 characters.")
	private String phone;
	
	//@Column(name="fax" ,unique=true)
	//@NotNull(message = "fax cannot be null.") 
    //@NotBlank(message = "fax cannot be null.")
	//@Size(min=10, max=10,message = "Fax must contains at least 9 characters.")
	private String fax;
	

	//@Column(name="numagence" ,unique=true)
	//@Size(min=8, max=8,message = "num�ro d'agence must contains at least 8 characters.")
	private String numagence;
/*
	//@JsonManagedReference(value="messageagence")
	@OneToMany(mappedBy="contacts",fetch = FetchType.LAZY ,cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonBackReference(value="message")
	private List<message> message;
    
	public List<message> getMessage() {
		return message;
	}


	public void setMessage(List<message> message) {
		this.message = message;
	}
*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getNumagence() {
		return numagence;
	}

	public void setNumagence(String numagence) {
		this.numagence = numagence;
	}

	

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
   
    /*
    @OneToMany(mappedBy = "lagence", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	//@JsonManagedReference(value="comptesagence")
	private List<compte> clis;
    */
    

}











