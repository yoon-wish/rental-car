package rentalcarServer.reserve.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.board.model.Board;
import rentalcarServer.car.model.CarResponseDto;
import rentalcarServer.user.model.User;
import rentalcarServer.user.model.UserResponseDto;
import rentalcarServer.util.DBManager;
import rentalcarServer.util.PasswordCrypto;

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
	
	public List<ReservationResponseDto> findReservedCarListById(String id) {
		List<ReservationResponseDto> list = new ArrayList<>();

		conn = DBManager.getConnection();
		String sql = "SELECT car_num, rent_start, rent_end, rent_period, status FROM reservation WHERE id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int car_num = rs.getInt(1);
				String rent_start = rs.getString(2);
				String rent_end = rs.getString(3);
				int rent_period = rs.getInt(4);
				String status = rs.getString(5);
				
				ReservationResponseDto reservation = new ReservationResponseDto(car_num, rent_start, rent_end, rent_period, status);
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
	
	public Reservation findReservedCarById(String id) {
		Reservation reservation = null;

		conn = DBManager.getConnection();
		String sql = "SELECT rent_start, rent_end, rent_period, status FROM reservation WHERE id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				String rent_start = rs.getString(1);
				String rent_end = rs.getString(2);
				int rent_period = rs.getInt(3);
				String status = rs.getString(4);
				
				reservation = new Reservation(id, rent_start, rent_end, rent_period, status);
			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return reservation;

	}
	
	public ReservationResponseDto updateDate(String id, String start, String end, String start_new, String end_new) {
		ReservationResponseDto reservation = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE reservation SET rent_start=?, rent_end=?, rent_period=? WHERE id=? AND rent_start=? AND rent_end=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, start_new);
			pstmt.setString(2, end_new);
			pstmt.setString(4, id);
			pstmt.setString(5, start);
			pstmt.setString(6, end);
			
			LocalDate startDate = LocalDate.parse(start_new);
			LocalDate endDate = LocalDate.parse(end_new);
			long period = ChronoUnit.DAYS.between(startDate, endDate) + 1;
			
			pstmt.setInt(3, (int) period);
			
			pstmt.execute();
			
			reservation = new ReservationResponseDto(id, start_new, end_new, (int) period);
			
			return reservation;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return reservation;
	}
	
	public boolean cancelReservation(Reservation reservation) {
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "DELETE FROM reservation WHERE id=? AND car_num=? AND rent_start=? AND rent_end=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reservation.getId());
			pstmt.setInt(2, reservation.getCar_num());
			pstmt.setString(3, reservation.getRent_start());
			pstmt.setString(4, reservation.getRent_end());
			
			pstmt.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		return false;
	}
	

}
