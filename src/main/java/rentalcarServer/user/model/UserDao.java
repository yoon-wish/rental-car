package rentalcarServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.user.model.UserResponseDto;
import rentalcarServer.util.PasswordCrypto;
import rentalcarServer.util.DBManager;

public class UserDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private UserDao() {
	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	public List<UserResponseDto> findUserAll() {

		List<UserResponseDto> list = new ArrayList<UserResponseDto>();

		try {
			conn = DBManager.getConnection();

			// 쿼리할 준비
			String sql = "SELECT id, email, name, birth,telecom, phone, license, license_date, agree, admin FROM user";
			pstmt = conn.prepareStatement(sql);

			// 쿼리 실행
			rs = pstmt.executeQuery();

			// 튜플 읽기
			while (rs.next()) {
				// database의 column index는 1부터 시작!
				String id = rs.getString(1);
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String telecom = rs.getString(5);
				String phone = rs.getString(6);
				boolean license = rs.getBoolean(7);
				String license_date = rs.getString(8);
				boolean agree = rs.getBoolean(9);
				boolean admin = rs.getBoolean(10);

				UserResponseDto user = new UserResponseDto(id, email, name, birth, telecom, phone, license,
						license_date, agree, admin);
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public UserResponseDto findUserByIdAndPassword(String id, String password) {
		UserResponseDto user = null;

		try {
			conn = DBManager.getConnection();

			String sql = "SELECT id, email, name, birth, telecom, phone, license, license_date, agree, admin, password FROM user WHERE id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String telecom = rs.getString(5);
				String phone = rs.getString(6);
				boolean license = rs.getBoolean(7);
				String license_date = rs.getString(8);
				boolean agree = rs.getBoolean(9);
				boolean admin = rs.getBoolean(10);
				String encyptedPassword = rs.getString(11);

				if (PasswordCrypto.decrypt(password, encyptedPassword))
					user = new UserResponseDto(id, email, name, birth, telecom, phone, license, license_date, agree,
							admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}

	public UserResponseDto createUser(UserRequestDto userDto) {
		// sql 구문을 쿼리하고
		// 성공을 했다면 -> UserResponseDto 객체 생성하여
		// 반환
	    if (userDto == null) {
	        // userDto가 null인 경우 예외 처리 또는 적절한 로깅
	        System.err.println("UserRequestDto가 null입니다.");
	        return null;
	    }
	    
		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO user(id, password, email, name, birth, telecom, phone, license, license_date, agree, admin) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			// sql 구문에 맵핑할 값 설정
			pstmt.setString(1, userDto.getId());
			pstmt.setString(2, PasswordCrypto.encrypt(userDto.getPassword()));

//			String email = userDto.getEmail().equals("") ? null : userDto.getEmail();
			pstmt.setString(3, userDto.getEmail());
			pstmt.setString(4, userDto.getName());
			pstmt.setString(5, userDto.getBrith());
			pstmt.setString(6, userDto.getTelecom());
			pstmt.setString(7, userDto.getPhone());
			pstmt.setBoolean(8, userDto.isLicense());

//			String license_date = userDto.getLicenseDate().equals("") ? null : userDto.getLicenseDate();
			pstmt.setString(9, userDto.getLicenseDate());
			pstmt.setBoolean(10, userDto.isAgree());
			pstmt.setBoolean(11, userDto.isAdmin());

			pstmt.execute();

			return findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}

}
