package rentalcarServer.reserve.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.car.model.CarResponseDto;
import rentalcarServer.util.DBManager;

public class ReservationDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ReservationDao() {

	}

	private static ReservationDao instance = new ReservationDao();

	public static ReservationDao getInstance() {
		return instance;
	}

	public ReservationResponseDto createReservation(ReservationResponseDto reserveDto) {
		if (reserveDto == null) {
			System.err.println("ReservationRequestDto가 null입니다.");
			return null;
		}

		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO reservation(id, car_num, rent_start, rent_end, rent_period, status) VALUES(?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reserveDto.getId());
			pstmt.setInt(2, reserveDto.getCar_num());
			pstmt.setString(3, reserveDto.getRent_start());
			pstmt.setString(4, reserveDto.getRent_end());

			LocalDate startDate = LocalDate.parse(reserveDto.getRent_start());
			LocalDate endDate = LocalDate.parse(reserveDto.getRent_end());
			long period = ChronoUnit.DAYS.between(startDate, endDate) + 1;

			pstmt.setLong(5, period);
			pstmt.setString(6, reserveDto.getStatus());

			pstmt.execute();

			return reserveDto;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}
	
	public List<ReservationResponseDto> findReservedCarById(String id) {
		List<ReservationResponseDto> list = new ArrayList<>();

		conn = DBManager.getConnection();
		String sql = "SELECT rent_start, rent_end, rent_period, status FROM reservation WHERE id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String rent_start = rs.getString(1);
				String rent_end = rs.getString(2);
				int rent_period = rs.getInt(3);
				String status = rs.getString(4);
				
				ReservationResponseDto reservation = new ReservationResponseDto(rent_start, rent_end, rent_period, status);
				list.add(reservation);
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
	
	

}
