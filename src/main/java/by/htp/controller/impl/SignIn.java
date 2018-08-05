package by.htp.controller.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.htp.controller.command.Command;
import by.htp.controller.page_path.PagePath;
import by.htp.entity.AdminUser;
import by.htp.entity.User;
import by.htp.service.ServiceFactory;
import by.htp.service.UserService;

public class SignIn implements Command {

	private final static Logger LOGGER = Logger.getLogger(SignIn.class);

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String login = request.getParameter(ConstantParam.LOGIN);
		String password = request.getParameter(ConstantParam.PASSWORD);
		String nextPage = PagePath.MAIN_PAGE;

		try {
			UserService userService = ServiceFactory.getInstance().getUserService();
			
			if (login.contains(ConstantParam.ADMIN_PREFIX)) {
				AdminUser admin = userService.signInAdmin(login, password);
				request.getSession(true).setAttribute("admin", admin);
				if (admin == null) {
					request.setAttribute(ConstantParam.ERROR_MESSAGE, ConstantParam.INCORRECT_DATES);
					nextPage = PagePath.SIGN_IN_PAGE;
				}
				
			} else {
				User user = userService.signIn(login, password);
				
				if(user != null) {
					request.getSession(true).setAttribute(ConstantParam.USER, user);
					request.setAttribute(ConstantParam.LOGIN, user.getLogin());
					
				}else {
					request.setAttribute(ConstantParam.ERROR_MESSAGE, ConstantParam.INCORRECT_DATES);
					nextPage = PagePath.SIGN_IN_PAGE;
				}
			}
				RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
				dispatcher.forward(request, response);
			
		} catch (ServletException e) {
			LOGGER.warn("ServletException in Controller", e);
			response.sendRedirect(PagePath.ERROR_PAGE);
			

		} catch (IOException e) {
			LOGGER.warn("IOException in Controller", e);
			response.sendRedirect(PagePath.ERROR_PAGE);
		}	

	}

}
