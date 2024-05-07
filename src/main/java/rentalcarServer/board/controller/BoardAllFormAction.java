package rentalcarServer.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.board.model.BoardDao;
import rentalcarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class BoardAllFormAction
 */
public class BoardAllFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardAllFormAction() throws ServletException, IOException {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoardDao dao = new BoardDao();
        
        List<BoardResponseDto> boardList = dao.findBoardAll();
        
		// userList를 request 객체에 attribute로 설정하여 HTML 페이지로 전달
        request.setAttribute("boardList", boardList);
        
		// 해당 데이터를 JSP 페이지로 포워딩
        request.getRequestDispatcher("/views/board/boardForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
	}

}
