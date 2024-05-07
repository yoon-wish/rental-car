package rentalcarServer.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.board.model.Board;
import rentalcarServer.board.model.BoardDao;
import rentalcarServer.board.model.BoardResponseDto;
import rentalcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class ReadBoardAction
 */
public class ReadBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadBoardAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String num = request.getParameter("num");
		 
		 BoardDao dao = new BoardDao();
		 Board board = dao.findBoardByNum(Integer.parseInt(num));
		 System.out.println("num: " + num);
		 
		 request.setAttribute("board", board);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/detail");
		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


//		BoardResponseDto boardDto = (BoardResponseDto) session.getAttribute("board");
//		
//		String id = boardDto.getId();
//		String title = boardDto.getTitle();
//		String content = boardDto.getContent();
//		String notice = boardDto.getNotice();
		
	}

}
