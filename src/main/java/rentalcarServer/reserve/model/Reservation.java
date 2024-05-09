package rentalcarServer.reserve.model;

import java.sql.Timestamp;

public class Reservation {
	private String id;
	private int car_num;
	private String rent_start;
	private String rent_end;
	private int rent_period;
	private String status;
	private Timestamp reg_date;
	private Timestamp mod_date;
	
	public Reservation(String id, int car_num, String rent_start, String rent_end, int rent_period, String status, Timestamp reg_date, Timestamp mod_date) {
		super();
		
		this.id =id;
		this.car_num = car_num;
		this.rent_start = rent_start;
		this.rent_end = rent_end;
		this.status = status;
		this.reg_date = reg_date;
		this.mod_date = mod_date;
	}

	public Reservation(String id, int car_num, String rent_start, String rent_end, int rent_period, String status) {
		super();
		
		this.id =id;
		this.car_num = car_num;
		this.rent_start = rent_start;
		this.rent_end = rent_end;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}

	public int getCar_num() {
		return car_num;
	}

	public String getRent_start() {
		return rent_start;
	}

	public String getRent_end() {
		return rent_end;
	}

	public int getRent_period() {
		return rent_period;
	}

	public String getStatus() {
		return status;
	}
	
	public Timestamp getReg_date() {
		return reg_date;
	}

	public Timestamp getMod_date() {
		return mod_date;
	}
	
	
}
