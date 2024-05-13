package rentalcarServer.reserve.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalcarServer.car.model.Car;
import rentalcarServer.car.model.CarDao;
import rentalcarServer.car.model.CarResponseDto;
import rentalcarServer.reserve.model.ReservationDao;
import rentalcarServer.reserve.model.ReservationResponseDto;
import rentalcarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class ReserveCarAction
 */
@WebServlet("/ReserveCarAction")
public class ReserveCarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveCarAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		UserResponseDto userDto = (UserResponseDto) session.getAttribute("user");

		String id = userDto.getId();
		String birth = userDto.getBirth();
		String license_date = userDto.getLicense_date();
		
		String car_num = request.getParameter("car_num");
		String rent_start = request.getParameter("start");
		String rent_end = request.getParameter("end");
		int rent_period = 0;
		String status = "예약완료";

		CarDao carDao = new CarDao();
		
		Car car = carDao.findCarByNum(Integer.parseInt(car_num));
		session.setAttribute("car", car);
		
		// 나이 구하기
		LocalDate birthDate = LocalDate.parse(birth);
		LocalDate currentDate = LocalDate.now();
		int age = calculateYear(birthDate, currentDate);
		
		if(license_date == null || license_date.equals("")) {
			response.sendRedirect("/limitLicense");
			return;
		}
		
		LocalDate licenseDate = LocalDate.parse(license_date);
		int license = calculateYear(licenseDate, currentDate);
		
		
		// 예약 완료 여부 확인
		List<CarResponseDto> carList = new ArrayList<CarResponseDto>();
		carList = carDao.findCarByDate(rent_start, rent_end);
		
		boolean exist = false;

		for (int i = 0; i < carList.size(); i++) {
			if (carList.get(i).getCar_num() == Integer.parseInt(car_num)) {
				exist = true;
			}
		}

		if (!exist) {
			response.sendRedirect("/limitReserve");
		} else {
			// 나이제한 확인
			if(age < car.getLimit_age()) {
				response.sendRedirect("/limitAge");
				return;
			}
			
			// 면허 취득년도 확인
			if(license < car.getLimit_period()) {
				response.sendRedirect("/limitLicense");
				return;
			}
			
			ReservationResponseDto reserveDto = new ReservationResponseDto(id, Integer.parseInt(car_num), rent_start,
					rent_end, rent_period, status);
			ReservationDao reserveDao = new ReservationDao();
			reserveDao.createReservation(reserveDto);

			response.sendRedirect("/myPageMain");
		}
	}
	
	public static int calculateYear(LocalDate birthDate, LocalDate currentDate) {
		Period period = Period.between(birthDate, currentDate);
		
		return period.getYears();
	}

}
