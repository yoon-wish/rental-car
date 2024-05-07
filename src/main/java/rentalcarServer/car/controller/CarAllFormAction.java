package rentalcarServer.car.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.car.model.CarDao;
import rentalcarServer.car.model.CarResponseDto;

/**
 * Servlet implementation class CarAllFormAction
 */
public class CarAllFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarAllFormAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CarDao dao = new CarDao();
        
        String page = request.getParameter("page");
        
        List<CarResponseDto> carList = new ArrayList<CarResponseDto>();
        int carSize = dao.carSize();
        
        if(page != null)
        	carList = dao.findCarWithPageNumber(Integer.parseInt(page));
        
        request.setAttribute("carSize", carSize);
        request.setAttribute("carList", carList);
        
		// 해당 데이터를 JSP 페이지로 포워딩
        request.getRequestDispatcher("/home").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
