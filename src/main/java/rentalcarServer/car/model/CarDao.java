package rentalcarServer.car.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.util.DBManager;

public class CarDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public CarDao() {

	}

	private static CarDao instance = new CarDao();

	public static CarDao getInstance() {
		return instance;
	}
	
	public List<CarResponseDto> findReservedCarById(String id) {
		List<CarResponseDto> list = new ArrayList<>();

		conn = DBManager.getConnection();
		String sql = "SELECT c.car_num, c.car_name, c.car_brand, c.car_img, c.size, c.price, c.country, c.year, c.fuel, c.limit_age, c.limit_period FROM reservation r JOIN car c ON r.car_num=c.car_num WHERE r.id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int car_num = rs.getInt(1);
				String car_name = rs.getString(2);
				String car_brand = rs.getString(3);
				String car_img = rs.getString(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String country = rs.getString(7);
				int year = rs.getInt(8);
				String fuel = rs.getString(9);
				int limit_age = rs.getInt(10);
				int limit_period = rs.getInt(11);

				CarResponseDto car = new CarResponseDto(car_num, car_name, car_brand, car_img, size, price, country,
						year, fuel, limit_age, limit_period);
				list.add(car);
			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;

	}
	
	public List<CarResponseDto> findCarWithPageNumber(int page) {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();

		System.out.println("page: " + page);

		int carSize = carSize();

		int startNum = (page - 1) * 6 + 1;
		System.out.println("startNum: " + startNum);
		int endNum = page * 6;
		System.out.println("endNum: " + endNum);
		if (endNum > carSize) {
			endNum = carSize;
		}

		conn = DBManager.getConnection();
		String sql = "SELECT car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period FROM car";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			for (int i = 1; i < startNum && rs.next(); i++) {
				// 건너뜀
			}

			for (int i = startNum; i <= endNum && rs.next(); i++) {
				int car_num = rs.getInt(1);
				String car_name = rs.getString(2);
				String car_brand = rs.getString(3);
				String car_img = rs.getString(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String country = rs.getString(7);
				int year = rs.getInt(8);
				String fuel = rs.getString(9);
				int limit_age = rs.getInt(10);
				int limit_period = rs.getInt(11);

				CarResponseDto car = new CarResponseDto(car_num, car_name, car_brand, car_img, size, price, country,
						year, fuel, limit_age, limit_period);
				list.add(car);
			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;

	}

	public int carSize() {
		return findCarAll().size();
	}

	public List<CarResponseDto> findCarAll() {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();
		conn = DBManager.getConnection();
		String sql = "SELECT car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period FROM car";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int car_num = rs.getInt(1);
				String car_name = rs.getString(2);
				String car_brand = rs.getString(3);
				String car_img = rs.getString(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String country = rs.getString(7);
				int year = rs.getInt(8);
				String fuel = rs.getString(9);
				int limit_age = rs.getInt(10);
				int limit_period = rs.getInt(11);

				CarResponseDto car = new CarResponseDto(car_num, car_name, car_brand, car_img, size, price, country,
						year, fuel, limit_age, limit_period);
				list.add(car);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;

	}

	public Car findCarByNum(int car_num) {
		Car car = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period FROM car WHERE car_num=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, car_num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				car_num = rs.getInt(1);
				String car_name = rs.getString(2);
				String car_brand = rs.getString(3);
				String car_img = rs.getString(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String country = rs.getString(7);
				int year = rs.getInt(8);
				String fuel = rs.getString(9);
				int limit_age = rs.getInt(10);
				int limit_period = rs.getInt(11);

				car = new Car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age,
						limit_period);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return car;
	}

	
	public List<CarResponseDto> findCarByDate(int page, String start, String end) {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();

		int carSize = SizeCarByDate(page, start, end);

		int startNum = (page - 1) * 6 + 1;
		System.out.println("startNum: " + startNum);
		int endNum = page * 6;
		System.out.println("endNum: " + endNum);
		if (endNum > carSize) {
			endNum = carSize;
		}

		conn = DBManager.getConnection();
		String sql = "SELECT car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period FROM car WHERE car_num NOT IN ( SELECT car_num FROM reservation WHERE (rent_start <= ? AND rent_end >= ?))";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, end);
			pstmt.setString(2, start);
			rs = pstmt.executeQuery();
			
			for (int i = 1; i < startNum && rs.next(); i++) {
				// 건너뜀
			}

			for (int i = startNum; i <= endNum && rs.next(); i++) {
				int car_num = rs.getInt(1);
				String car_name = rs.getString(2);
				String car_brand = rs.getString(3);
				String car_img = rs.getString(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String country = rs.getString(7);
				int year = rs.getInt(8);
				String fuel = rs.getString(9);
				int limit_age = rs.getInt(10);
				int limit_period = rs.getInt(11);

				CarResponseDto car = new CarResponseDto(car_num, car_name, car_brand, car_img, size, price, country,
						year, fuel, limit_age, limit_period);
				list.add(car);
			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;

	}
	
	public List<CarResponseDto> findCarByDate(String start, String end) {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();


		conn = DBManager.getConnection();
		String sql = "SELECT car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period FROM car WHERE car_num NOT IN ( SELECT car_num FROM reservation WHERE (rent_start <= ? AND rent_end >= ?))";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, end);
			pstmt.setString(2, start);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int car_num = rs.getInt(1);
				String car_name = rs.getString(2);
				String car_brand = rs.getString(3);
				String car_img = rs.getString(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String country = rs.getString(7);
				int year = rs.getInt(8);
				String fuel = rs.getString(9);
				int limit_age = rs.getInt(10);
				int limit_period = rs.getInt(11);

				CarResponseDto car = new CarResponseDto(car_num, car_name, car_brand, car_img, size, price, country,
						year, fuel, limit_age, limit_period);
				list.add(car);
			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;

	}
	
	public int SizeCarByDate(int page, String start, String end) {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();

		conn = DBManager.getConnection();
		String sql = "SELECT car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period FROM car WHERE car_num NOT IN ( SELECT car_num FROM reservation WHERE (rent_start <= ? AND rent_end >= ?))";
		
//		LocalDate start_date = LocalDate.parse(start);
//		Date date1 = Date.valueOf(start_date);
//		LocalDate end_date = LocalDate.parse(end);
//		Date date2 = Date.valueOf(end_date);
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  end);
			pstmt.setString(2,  start);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int car_num = rs.getInt(1);
				String car_name = rs.getString(2);
				String car_brand = rs.getString(3);
				String car_img = rs.getString(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String country = rs.getString(7);
				int year = rs.getInt(8);
				String fuel = rs.getString(9);
				int limit_age = rs.getInt(10);
				int limit_period = rs.getInt(11);

				CarResponseDto car = new CarResponseDto(car_num, car_name, car_brand, car_img, size, price, country,
						year, fuel, limit_age, limit_period);
				list.add(car);

			}

		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list.size();

	}
	
	public List<CarResponseDto> findCarByBrand(String brand) {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();

		conn = DBManager.getConnection();
		String sql = "SELECT car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period FROM car WHERE car_brand=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brand);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int car_num = rs.getInt(1);
				String car_name = rs.getString(2);
				String car_brand = rs.getString(3);
				String car_img = rs.getString(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String country = rs.getString(7);
				int year = rs.getInt(8);
				String fuel = rs.getString(9);
				int limit_age = rs.getInt(10);
				int limit_period = rs.getInt(11);

				CarResponseDto car = new CarResponseDto(car_num, car_name, car_brand, car_img, size, price, country,
						year, fuel, limit_age, limit_period);
				list.add(car);
			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;

	}
	
	public int SizeCarByBrand(String brand) {
		List<CarResponseDto> list = new ArrayList<CarResponseDto>();

		conn = DBManager.getConnection();
		String sql = "SELECT car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period FROM car WHERE car_brand=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brand);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int car_num = rs.getInt(1);
				String car_name = rs.getString(2);
				String car_brand = rs.getString(3);
				String car_img = rs.getString(4);
				String size = rs.getString(5);
				int price = rs.getInt(6);
				String country = rs.getString(7);
				int year = rs.getInt(8);
				String fuel = rs.getString(9);
				int limit_age = rs.getInt(10);
				int limit_period = rs.getInt(11);

				CarResponseDto car = new CarResponseDto(car_num, car_name, car_brand, car_img, size, price, country,
						year, fuel, limit_age, limit_period);
				list.add(car);
			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list.size();

	}
}
