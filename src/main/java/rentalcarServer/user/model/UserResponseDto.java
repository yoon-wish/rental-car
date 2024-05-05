package rentalcarServer.user.model;


public class UserResponseDto {
	private String id;
	private String email;
	private String name;
	private String birth;
	private String telecom;
	private String phone;
	private boolean license;
	private String license_date;
	private boolean admin;
	private boolean agree;
	
	public UserResponseDto(String id, String email, String name, String birth, String telecom, String phone, boolean license,
			String license_date, boolean agree, boolean admin) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.telecom = telecom;
		this.phone = phone;
		this.license = license;
		this.license_date = license_date;
		this.agree = agree;
		this.admin = admin;
	}

	public UserResponseDto(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.name = user.getName() ;
		this.birth = user.getBirth();
		this.telecom = user.getTelecom();
		this.phone = user.getPhone();
		this.license = user.isLicense();
		this.license_date = user.getLicenseDate();
		this.agree = user.isAgree();
		this.admin = user.isAdmin();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTelecom() {
		return telecom;
	}

	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isLicense() {
		return license;
	}

	public void setLicense(boolean license) {
		this.license = license;
	}

	public String getLicenseDate() {
		return license_date;
	}

	public void setLicenseDate(String license_date) {
		this.license_date = license_date;
	}
	
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	
	
}
