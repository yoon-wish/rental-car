package rentalcarServer.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.util.PasswordCrypto;
import rentalcarServer.util.DBManager;

public class UserDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UserDao() {
	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	public boolean userExists(String id) {
		return findUserById(id) != null;
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
				String license = rs.getString(7);
				String license_date = rs.getString(8);
				boolean agree = rs.getBoolean(9);
				String admin = rs.getString(10);

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
				String license = rs.getString(7);
				String license_date = rs.getString(8);
				boolean agree = rs.getBoolean(9);
				String admin = rs.getString(10);
				String encyptedPassword = rs.getString(11);

				if (PasswordCrypto.decrypt(password, encyptedPassword))
					user = new UserResponseDto(id, email, name, birth, telecom, phone, license, license_date, agree, admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}
	
	
	public User findUserById(String id) {
		User user = null;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "SELECT id, email, name, birth, telecom, phone, license, license_date, agree, admin, reg_date, mod_date FROM user WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String email = rs.getString(2);
				String name = rs.getString(3);
				String birth = rs.getString(4);
				String telecom = rs.getString(5);
				String phone = rs.getString(6);
				String license = rs.getString(7);
				String license_date = rs.getString(8);
				boolean agree = rs.getBoolean(9);
				String admin = rs.getString(10);
				Timestamp regDate = rs.getTimestamp(11);
				Timestamp modDate = rs.getTimestamp(12);
				
				user = new User(id, email, name, birth, telecom, phone, license, license_date, agree, admin, regDate, modDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
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
			pstmt.setString(8, userDto.getLicense());

			String license_date = userDto.getLicense_date().equals("") ? null : userDto.getLicense_date();
			pstmt.setString(9, license_date);
			pstmt.setBoolean(10, userDto.isAgree());
			pstmt.setString(11, userDto.getAdmin());

			pstmt.execute();

			return findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}
	
	public UserResponseDto updateUserEmail(UserRequestDto userDto) {
		UserResponseDto user = null;
		
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null)
			return user;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE user SET email=? WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getEmail());
			pstmt.setString(2, userDto.getId());
			
			pstmt.execute();
			
			user = findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}
	
	public UserResponseDto updateUserPhone(UserRequestDto userDto) {
		UserResponseDto user = null;
		
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null)
			return user;

		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE user SET telecom=?, phone=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getTelecom());
			pstmt.setString(2, userDto.getPhone());
			pstmt.setString(3, userDto.getId());
			
			pstmt.execute();
			
			user = findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}
	
	public UserResponseDto updateUserPassword(UserRequestDto userDto, String newPassword) {
		UserResponseDto user = null;
		
		if(newPassword == null || newPassword.equals("")) {
			return user;
		}
		
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null)
			return user;

		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE user SET password=? WHERE id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, PasswordCrypto.encrypt(newPassword));
			pstmt.setString(2, userDto.getId());
			
			pstmt.execute();
			
			User userVo = findUserById(userDto.getId());
			user = new UserResponseDto(userVo);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}

	public UserResponseDto updateUserLicense(UserRequestDto userDto) {
		UserResponseDto user = null;
		
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null)
			return user;

		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE user SET license=?, license_date=? WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userDto.getLicense());
			pstmt.setString(2, userDto.getLicense_date());
			pstmt.setString(3, userDto.getId());
			
			pstmt.execute();
			
			user = findUserByIdAndPassword(userDto.getId(), userDto.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return user;
	}
	
	public boolean deleteUser(UserRequestDto userDto) {
		if(findUserByIdAndPassword(userDto.getId(), userDto.getPassword()) == null)
			return false;
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "DELETE FROM user WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userDto.getId());
			
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
