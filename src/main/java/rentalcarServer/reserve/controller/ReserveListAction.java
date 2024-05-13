package rentalcarServer.reserve.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.car.model.CarDao;
import rentalcarServer.car.model.CarResponseDto;
import rentalcarServer.reserve.model.ReservationDao;
import rentalcarServer.reserve.model.ReservationResponseDto;

public class ReserveListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String id = request.getParameter("id");
		
		System.out.println("id" + id);
		CarDao carDao = new CarDao();
		List<CarResponseDto> carList = carDao.findReservedCarById(id);
		
		ReservationDao reserveDao = new ReservationDao();
		List<ReservationResponseDto> reservationList = reserveDao.findReservedCarListById(id);
		
		HttpSession session = request.getSession();

		session.setAttribute("id", id);
		request.setAttribute("carList", carList);
		request.setAttribute("reservationList", reservationList);
        request.getRequestDispatcher("/reserveList").forward(request, response);

		
	
	}



}
