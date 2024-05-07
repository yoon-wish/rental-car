package rentalcarServer.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.board.model.BoardDao;
import rentalcarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class NoticeAllFormAction
 */
@WebServlet("/NoticeAllFormAction")
public class NoticeAllFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeAllFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BoardDao dao = new BoardDao();
        
        List<BoardResponseDto> boardList = dao.findNoticeAll();
        
		// userList를 request 객체에 attribute로 설정하여 HTML 페이지로 전달
        request.setAttribute("boardList", boardList);
        
		// 해당 데이터를 JSP 페이지로 포워딩
        request.getRequestDispatcher("/notice").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
