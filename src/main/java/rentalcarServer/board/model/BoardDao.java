package rentalcarServer.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import rentalcarServer.user.model.User;
import rentalcarServer.user.model.UserDao;
import rentalcarServer.user.model.UserRequestDto;
import rentalcarServer.user.model.UserResponseDto;
import rentalcarServer.util.DBManager;
import rentalcarServer.util.PasswordCrypto;

public class BoardDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDao() {
		
	}
	
	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}
	
	public List<BoardResponseDto> findBoardAll(){
        List<BoardResponseDto> list = new ArrayList<BoardResponseDto>();
        conn = DBManager.getConnection();
        String sql = "SELECT id, num, title, content, notice, reg_date FROM board WHERE notice = 'N' ORDER BY reg_date DESC";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
            	String id = rs.getString(1);
                int num = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String notice = rs.getString(5);
                Timestamp reg_date = rs.getTimestamp(6);
                BoardResponseDto board = new BoardResponseDto(id, num, title, content, notice, reg_date);
                list.add(board);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }

        return list;

    }
	
	public List<BoardResponseDto> findNoticeAll(){
        List<BoardResponseDto> list = new ArrayList<BoardResponseDto>();
        conn = DBManager.getConnection();
        String sql = "SELECT id, num, title, content, notice, reg_date FROM board WHERE notice = 'Y' ORDER BY reg_date DESC";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
            	String id = rs.getString(1);
                int num = rs.getInt(2);
                String title = rs.getString(3);
                String content = rs.getString(4);
                String notice = rs.getString(5);
                Timestamp reg_date = rs.getTimestamp(6);
                BoardResponseDto board = new BoardResponseDto(id, num, title, content, notice, reg_date);
                list.add(board);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt, rs);
        }

        return list;

    }
	
	public Board findBoardByNum(int num) {
		Board board = null;
		
		try {
			conn = DBManager.getConnection();		

			String sql = "SELECT id, num, title, content, notice, reg_date FROM board WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				num = rs.getInt(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String notice = rs.getString(5);
				Timestamp reg_date = rs.getTimestamp(6);
				
				board = new Board(id, num, title, content, notice, reg_date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return board;
	}
	
	public BoardResponseDto findBoardDtoByNum(int num) {
		BoardResponseDto board = null;
		
		try {
			conn = DBManager.getConnection();		

			String sql = "SELECT id, num, title, content, notice, reg_date FROM board WHERE num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				num = rs.getInt(2);
				String title = rs.getString(3);
				String content = rs.getString(4);
				String notice = rs.getString(5);
				Timestamp reg_date = rs.getTimestamp(6);
				
				board = new BoardResponseDto(id, num, title, content, notice, reg_date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return board;
	}
	
	public BoardResponseDto createBoard(BoardResponseDto boardDto) {
	    if (boardDto == null) {
	        // userDto가 null인 경우 예외 처리 또는 적절한 로깅
	        System.err.println("BoardRequestDto가 null입니다.");
	        return null;
	    }
	    
		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO board (id, title, content, notice) VALUES(?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			// sql 구문에 맵핑할 값 설정
			pstmt.setString(1, boardDto.getId());
			pstmt.setString(2, boardDto.getTitle());
			pstmt.setString(3, boardDto.getContent());
			pstmt.setString(4, boardDto.getNotice());
			
			pstmt.execute();

			return boardDto;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}
	
	
	public BoardResponseDto updateBoardTitle(BoardRequestDto board) {
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE board SET title=? WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setInt(2, board.getNum());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}
	
	public BoardResponseDto updateBoardContent(BoardRequestDto board) {
		try {
			conn = DBManager.getConnection();
			
			String sql = "UPDATE board SET content=? WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			System.out.println("Content: " + board.getContent());
			pstmt.setString(1, board.getContent());
			pstmt.setInt(2, board.getNum());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return null;
	}
	
	public boolean deleteBoard(Board board) {
		
		try {
			conn = DBManager.getConnection();
			
			String sql = "DELETE FROM board WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board.getNum());
			
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
