package rentalcarServer.reserve.model;

public class ReservationResponseDto {
	private String id;
	private int car_num;
	private String rent_start;
	private String rent_end;
	private int rent_period;
	private String status;
	
	
	public ReservationResponseDto(String id, int car_num, String rent_start, String rent_end, int rent_period, String status) {
		super();
		
		this.id =id;
		this.car_num = car_num;
		this.rent_start = rent_start;
		this.rent_end = rent_end;
		this.rent_period = rent_period;
		this.status = status;
	}
	
	public ReservationResponseDto(String rent_start, String rent_end, int rent_period, String status) {
		super();
		
		this.rent_start = rent_start;
		this.rent_end = rent_end;
		this.rent_period = rent_period;
		this.status = status;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getCar_num() {
		return car_num;
	}


	public void setCar_num(int car_num) {
		this.car_num = car_num;
	}


	public String getRent_start() {
		return rent_start;
	}


	public void setRent_start(String rent_start) {
		this.rent_start = rent_start;
	}


	public String getRent_end() {
		return rent_end;
	}


	public void setRent_end(String rent_end) {
		this.rent_end = rent_end;
	}


	public int getRent_period() {
		return rent_period;
	}


	public void setRent_period(int rent_period) {
		this.rent_period = rent_period;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
}
