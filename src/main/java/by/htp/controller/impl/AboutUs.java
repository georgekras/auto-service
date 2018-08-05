package by.htp.controller.impl;



import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.controller.command.Command;
import by.htp.controller.page_path.PagePath;

public class AboutUs implements Command{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.ABOUT_US);
			dispatcher.forward(request, response);
		
	}

}
