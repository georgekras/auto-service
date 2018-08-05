package by.htp.controller.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.htp.controller.command.Command;
import by.htp.controller.page_path.PagePath;
import by.htp.entity.Vehicle;
import by.htp.service.ServiceFactory;

public class SalesPage implements Command{

	
	private final static Logger LOGGER = Logger.getLogger(SalesPage.class);
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Map<Integer, Vehicle> cars;
		RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.SALES_PAGE);
		cars = ServiceFactory.getInstance().getAppService().getPortianCars();
		request.getSession().setAttribute(ConstantParam.CARS, cars);
		
		for(Map.Entry<Integer, Vehicle> pair : cars.entrySet()){
			System.out.println(pair.toString());
		}
		
		try {
			dispatcher.forward(request, response);
			
		} catch (ServletException | IOException e) {
			LOGGER.warn("ServletException in Controller", e);
			response.sendRedirect(PagePath.ERROR_PAGE);
			
		} 
		
	}

}
