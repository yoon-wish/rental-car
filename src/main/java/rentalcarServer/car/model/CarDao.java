package rentalcarServer.car.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.board.model.Board;
import rentalcarServer.board.model.BoardResponseDto;
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

					CarResponseDto car = new CarResponseDto(car_num, car_name, car_brand, car_img, size, price,
							country, year, fuel, limit_age, limit_period);
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
			
			if(rs.next()) {
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
				
				car = new Car(car_num, car_name, car_brand, car_img, size, price, country, year, fuel, limit_age, limit_period);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return car;
	}
}
