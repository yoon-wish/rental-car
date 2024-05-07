package rentalcarServer.car.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.board.model.Board;
import rentalcarServer.board.model.BoardDao;
import rentalcarServer.car.model.Car;
import rentalcarServer.car.model.CarDao;

/**
 * Servlet implementation class readCarAction
 */
public class ReadCarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadCarAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String car_num = request.getParameter("car_num");
		 
		 CarDao dao = new CarDao();
		 Car car= dao.findCarByNum(Integer.parseInt(car_num));
		 
		 request.setAttribute("car", car);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/carInfo");
		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
