package by.htp.controller.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.htp.controller.command.Command;
import by.htp.controller.page_path.PagePath;
import by.htp.entity.User;
import by.htp.service.ServiceFactory;
import by.htp.service.UserService;
import by.htp.service.exception.ServiceException;
import by.htp.service.impl.validation.ValidationProvider;

public class SignUp implements Command {

	private static final Logger logger = Logger.getLogger(SignUp.class);
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter(ConstantParam.LOGIN);
		String password = request.getParameter(ConstantParam.PASSWORD);
		String email = request.getParameter(ConstantParam.EMAIL);
		User user = null;
		List<String> errorList = null;

		RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.SIGN_UP_PAGE);
		errorList = ValidationProvider.getErrorList();
		
		try {
			if(errorList.isEmpty()) {
				UserService userService = ServiceFactory.getInstance().getUserService();
				user = userService.signUp(login, password, email);
			
				if (user != null) {
					dispatcher = request.getRequestDispatcher(PagePath.MAIN_PAGE);
					request.getSession(true).setAttribute(ConstantParam.USER, user);
					request.setAttribute(ConstantParam.USER, user.getLogin());

				} else {
					dispatcher = request.getRequestDispatcher(PagePath.SIGN_UP_PAGE);
					request.setAttribute(ConstantParam.ERROR_MESSAGE, ConstantParam.INCORRECT_DATES);
				}
			}
			dispatcher.forward(request, response);
			
			}catch (ServiceException e) {
			logger.fatal("No connection to BD!");
			response.sendRedirect(PagePath.ERROR_PAGE);
		}

	}
	
	
//	try {
//		if(errorList.isEmpty()) {
//			UserService userService = ServiceFactory.getInstance().getUserService();
//			user = userService.signUp(login, password, email);
//		
//			if (user != null) {
//				dispatcher = request.getRequestDispatcher(PagePath.MAIN_PAGE);
//				request.getSession(true).setAttribute(ConstantParam.USER, user);
//				request.setAttribute(ConstantParam.USER, user.getLogin());
//
//			} else {
//				dispatcher = request.getRequestDispatcher(PagePath.SIGN_UP_PAGE);
//				request.setAttribute(ConstantParam.ERROR_MESSAGE, ConstantParam.INCORRECT_DATES);
//			}
//		}
//		dispatcher.forward(request, response);
//		
//		}catch (ServiceException e) {
//		logger.fatal("No connection to BD!");
//		response.sendRedirect(PagePath.ERROR_PAGE);
//	}

}
