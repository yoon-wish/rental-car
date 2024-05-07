package rentalcarServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.board.model.Board;
import rentalcarServer.board.model.BoardDao;
import rentalcarServer.board.model.BoardRequestDto;
import rentalcarServer.board.model.BoardResponseDto;
import rentalcarServer.user.model.UserDao;

/**
 * Servlet implementation class UpdateBoardFormAction
 */
@WebServlet("/UpdateBoardFormAction")
public class UpdateBoardFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateBoardFormAction() {
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
		
		BoardRequestDto boardDto = new BoardRequestDto();
		
		BoardDao dao = new BoardDao();
		String num = request.getParameter("num");
		BoardResponseDto board = dao.findBoardDtoByNum(Integer.parseInt(num));
		
		String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        System.out.println("title: " + title);
        System.out.println("content: " + content);
        
        if(!title.equals("")) {
        	boardDto.setTitle(title);
        	boardDto.setNum(Integer.parseInt(num));
            board = dao.updateBoardTitle(boardDto);
         }
        
        System.out.println("num: " + boardDto.getNum());
        System.out.println("title2: " + boardDto.getTitle());
        
        if(!content.equals("")) {
        	boardDto.setContent(content);
        	board = dao.updateBoardContent(boardDto);
        }
        
        response.sendRedirect("/home");

	}

}
