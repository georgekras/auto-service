package by.htp.controller.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.htp.controller.command.Command;
import by.htp.controller.page_path.PagePath;

public class SignOut implements Command{

	
	private final static Logger LOGGER = Logger.getLogger(SalesPage.class);
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.getSession().invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.MAIN_PAGE);
		try {
			dispatcher.forward(request, response);
			
		} catch (ServletException e) {
			LOGGER.warn("ServletException in Controller", e);
			response.sendRedirect(PagePath.ERROR_PAGE);
			
		} catch (IOException e) {
			LOGGER.warn("ServletException in Controller", e);
			response.sendRedirect(PagePath.ERROR_PAGE);
			
		}

	}

}
