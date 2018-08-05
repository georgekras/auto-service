package by.htp.controller.impl;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.controller.command.Command;
import by.htp.controller.page_path.PagePath;

public class ToSignPage implements Command {
	
	
	private static final String command = "command";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String param = request.getParameter(command);
		String next = ConstantParam.COMMAND + param;
		request.getSession().setAttribute(ConstantParam.PREVIOUS_QUERY, next);
		
		
			RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.SIGN_IN_PAGE);
			dispatcher.forward(request, response);

	}

}
