package rentalcarServer.car.model;

import java.sql.Timestamp;

public class Car {
	private int car_num;
	private String car_name;
	private String car_brand;
	private String car_img;
	private String car_size;
	private int price;
	private String country;
	private int year;
	private String fuel;
	private int limit_age;
	private int limit_period;
	private Timestamp reg_date;
	private Timestamp mod_date;
	
	public Car(int car_num, String car_name, String car_brand, String car_img, String car_size,
			int price, String country, int year, String fuel, int limit_age, int limit_period,
			Timestamp reg_date, Timestamp mod_date) {
		super();
		
		this.car_num = car_num;
		this.car_name = car_name;
		this.car_brand = car_brand;
		this.car_img = car_img;
		this.car_size = car_size;
		this.price = price;
		this.country = country;
		this.year = year;
		this.fuel = fuel;
		this.limit_age = limit_age;
		this.limit_period = limit_period;
		this.reg_date = reg_date;
		this.mod_date = mod_date;
	}
	
	public Car(int car_num, String car_name, String car_brand, String car_img, String car_size,
			int price, String country, int year, String fuel, int limit_age, int limit_period) {
		super();
		
		this.car_num = car_num;
		this.car_name = car_name;
		this.car_brand = car_brand;
		this.car_img = car_img;
		this.car_size = car_size;
		this.price = price;
		this.country = country;
		this.year = year;
		this.fuel = fuel;
		this.limit_age = limit_age;
		this.limit_period = limit_period;
	}

	public int getCar_num() {
		return car_num;
	}

	public String getCar_name() {
		return car_name;
	}

	public String getCar_brand() {
		return car_brand;
	}

	public String getCar_img() {
		return car_img;
	}

	public String getCar_size() {
		return car_size;
	}

	public int getPrice() {
		return price;
	}

	public String getCountry() {
		return country;
	}

	public int getYear() {
		return year;
	}

	public String getFuel() {
		return fuel;
	}

	public int getLimit_age() {
		return limit_age;
	}

	public int getLimit_period() {
		return limit_period;
	}

	public Timestamp getReg_date() {
		return reg_date;
	}

	public Timestamp getMod_date() {
		return mod_date;
	}
	
	
}
