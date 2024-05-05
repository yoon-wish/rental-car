package rentalcarServer.user.model;

import java.sql.Timestamp;

public class UserRequestDto {
	private String id;
	private String password;
	private String email;
	private String name;
	private String birth;
	private String telecom;
	private String phone;
	private boolean license;
	private String license_date;
	private boolean agree;
	private boolean admin;
	private Timestamp regDate;
	private Timestamp modDate;
	
	public UserRequestDto(String id, String password, String email, String name, String birth, String telecom, String phone, String license,
			String license_date, String agree, String admin) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.telecom = telecom;
		this.phone = phone;
		this.license  = license.equals("on") ? true : false;
		this.license_date = license_date;
		this.agree  = agree.equals("on") ? true : false;
		this.admin  = admin.equals("on") ? true : false;
	}

	public UserRequestDto(String id, String password, String email, String name, String birth, String telecom, String phone, String license,
			String agree, String admin) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.birth = birth;
		this.telecom = telecom;
		this.phone = phone;
		this.license  = license.equals("on") ? true : false;
		this.agree  = agree.equals("on") ? true : false;
		this.admin  = admin.equals("on") ? true : false;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrith() {
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
		this.license_date=license_date;
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


