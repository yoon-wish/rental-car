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

public class ReadCarByBrandByAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String brand = request.getParameter("brand");
		
		CarDao dao = new CarDao();
		List<CarResponseDto> carList = new ArrayList<CarResponseDto>();
		int carSize = dao.SizeCarByBrand(brand);
		carList = dao.findCarByBrand(brand);
		
		request.setAttribute("carSize", carSize);
		request.setAttribute("carList", carList);
		
		request.getRequestDispatcher("/brandForm").forward(request, response);
	}


}
