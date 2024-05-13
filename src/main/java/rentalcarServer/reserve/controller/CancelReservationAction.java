package rentalcarServer.reserve.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.reserve.model.Reservation;
import rentalcarServer.reserve.model.ReservationDao;

public class CancelReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String car_num = request.getParameter("car_num");
		String rent_start = request.getParameter("start");
		String rent_end = request.getParameter("end");
		
		System.out.println("####: " + car_num);
		Reservation reservation = new Reservation(id, Integer.parseInt(car_num), rent_start, rent_end);
		
		ReservationDao dao = new ReservationDao();
		
		dao.cancelReservation(reservation);
		
		response.sendRedirect("/reserveListAction?id="+id);
	}

}
