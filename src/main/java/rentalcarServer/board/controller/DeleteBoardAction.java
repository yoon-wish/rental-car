package rentalcarServer.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.board.model.Board;
import rentalcarServer.board.model.BoardDao;

/**
 * Servlet implementation class DeleteBoardAction
 */
public class DeleteBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		BoardDao dao = new BoardDao();
		
		System.out.println("numnum: " + num);
		Board board = dao.findBoardByNum(Integer.parseInt(num));
		
		BoardDao boardDao = BoardDao.getInstance();
		
		boolean result = boardDao.deleteBoard(board);
		
		if(result) {
			System.out.println("삭제완료");
			response.sendRedirect("/home");
		} else {
			System.out.println("삭제실패");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('삭제실패.'); location.href='/myPage'; </script>");
			writer.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}
