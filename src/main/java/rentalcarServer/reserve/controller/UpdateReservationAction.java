package rentalcarServer.reserve.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalcarServer.car.model.CarDao;
import rentalcarServer.car.model.CarResponseDto;
import rentalcarServer.reserve.model.ReservationDao;

public class UpdateReservationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String start_new = request.getParameter("start-new");
		String end_new = request.getParameter("end-new");
		String car_num = request.getParameter("car_num");

		System.out.println("%%%: " + car_num);
		
		ReservationDao dao = new ReservationDao();
		CarDao carDao = new CarDao();

		List<CarResponseDto> carList = new ArrayList<CarResponseDto>();
		carList = carDao.findCarByDate(start_new, end_new);

//		for(int i=0; i<carList.size(); i++) {
//			System.out.println("차: " + carList.get(i).getCar_num());
//		}
		
		boolean exist = false;

		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getCar_num() == Integer.parseInt(car_num)) {
				exist = true;
			}
		}

		if (!exist) {
			response.sendRedirect("/limitReserve");
		} else {
			dao.updateDate(id, start, end, start_new, end_new);
			response.sendRedirect("/reserveListAction?id=" + id);
		}
	}
}
