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

public class CarAllFormAction extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CarDao dao = new CarDao();

		String page = request.getParameter("page");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		
		List<CarResponseDto> carList = new ArrayList<CarResponseDto>();
		System.out.println("page:  " + page);
		System.out.println("start:  " + start);
		System.out.println("end:  " + end);
		int carSize = 0;
		if (start == null || end == null || start.equals("") || end.equals("")) {
			System.out.println("진입1");
			carSize = dao.carSize();
			carList = dao.findCarWithPageNumber(Integer.parseInt(page));
		} else {
			carSize = dao.SizeCarByDate(Integer.parseInt(page), start, end);
			carList = dao.findCarByDate(Integer.parseInt(page), start, end);
		}

		request.setAttribute("carSize", carSize);
		request.setAttribute("carList", carList);
		// 해당 데이터를 JSP 페이지로 포워딩
		request.getRequestDispatcher("/home").forward(request, response);
	}

}
