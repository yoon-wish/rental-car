package rentalcarServer.user.model;

import java.sql.Timestamp;

public class User {
	private String id;
	private String email;
	private String name;
	private String birth;
	private String telecom;
	private String phone;
	private String license;
	private String license_date;
	private boolean agree;
	private String admin;
	private Timestamp regDate;
	private Timestamp modDate;

	public User(String id, String email, String name, String birth, String telecom, String phone, String license,
			String license_date, boolean agree, String admin, Timestamp regDate, Timestamp modDate) {
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
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getTelecom() {
		return telecom;
	}

	public String getPhone() {
		return phone;
	}

	public String isLicense() {
		return license;
	}
	
	public String getLicenseDate() {
		return license_date;
	}

	public boolean isAgree() {
		return agree;
	}

	public String isAdmin() {
		return admin;
	}
	
	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

}
