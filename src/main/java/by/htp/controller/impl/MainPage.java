package by.htp.controller.impl;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.controller.command.Command;
import by.htp.controller.page_path.PagePath;

public class MainPage implements Command{
	
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.MAIN_PAGE);
				dispatcher.forward(request, response);
			

	}

}
