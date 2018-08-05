package by.htp.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.controller.command.Command;
import by.htp.controller.command_name.CommandName;
import by.htp.controller.impl.AboutUs;
import by.htp.controller.impl.AddVehicle;
import by.htp.controller.impl.Delete;
import by.htp.controller.impl.Localization;
import by.htp.controller.impl.MainPage;
import by.htp.controller.impl.SalesPage;
import by.htp.controller.impl.SignIn;
import by.htp.controller.impl.SignOut;
import by.htp.controller.impl.SignUp;
import by.htp.controller.impl.ToAddVehiclePage;
import by.htp.controller.impl.ToSignPage;
import by.htp.controller.impl.ToSignUpPage;

public class CommandProvider {
	
	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();
	
	
	

	public CommandProvider() {
		commands.put(CommandName.MAIN_PAGE, new MainPage());
		commands.put(CommandName.TO_SIGN_IN_PAGE, new ToSignPage());
		commands.put(CommandName.TO_SIGN_UP_PAGE, new ToSignUpPage());
		commands.put(CommandName.TO_ADD_VEHICLE_PAGE, new ToAddVehiclePage());
		
		commands.put(CommandName.LOCALIZATION, new Localization());
		commands.put(CommandName.SIGN_IN, new SignIn());
		commands.put(CommandName.SIGN_UP, new SignUp());
		commands.put(CommandName.SIGN_OUT, new SignOut());
		commands.put(CommandName.DELETE, new Delete());
		
		commands.put(CommandName.SALES_PAGE, new SalesPage());
		commands.put(CommandName.ABOUT_US, new AboutUs());
		commands.put(CommandName.ADD_VEHICLE, new AddVehicle());
	}
	
	
	
	
	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(CommandName.valueOf(commandName.toUpperCase()));
		return command;
		
		
	}
	

}
