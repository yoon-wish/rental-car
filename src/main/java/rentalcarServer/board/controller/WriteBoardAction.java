package rentalcarServer.board.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.board.model.BoardDao;
import rentalcarServer.board.model.BoardResponseDto;
import rentalcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class WriteBoardAction
 */
public class WriteBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteBoardAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);

		UserResponseDto userDto = (UserResponseDto) session.getAttribute("user");
		
		String id = userDto.getId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String notice = userDto.getAdmin();

		// Backend 에서 전달받은 데이터에 대한 유효성 검증
		boolean isValid = true;

		if (title == null || title.equals(""))
			isValid = false;
		else if (content == null || content.equals(""))
			isValid = false;

		System.out.println(id);
		if (isValid) {
			BoardResponseDto boardDto = new BoardResponseDto(id, title, content, notice);
			
			BoardDao boardDao = new BoardDao();
			BoardResponseDto board = boardDao.createBoard(boardDto);

			if (board == null) {
				// 실패
				System.out.println("게시글 생성에 실패했습니다.");
				response.sendRedirect("/board");
			} else {
				// 성공
//				session.setAttribute("board" + board.getNum(), board);
				System.out.println("게시글이 성공적으로 생성되었습니다.");
				response.sendRedirect("/boardAction");
			}
		} else
			response.sendRedirect("/board");
	}

}
