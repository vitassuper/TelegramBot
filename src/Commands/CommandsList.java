package TelegramBot.Commands;

import java.util.HashMap;

public class CommandsList {
private static HashMap<String, CommandCreator> commands;
	
	public static HashMap<String, CommandCreator> getCommands() {
		commands = new HashMap<String, CommandCreator>();
		commands.put("/start", new HelloCommandCreator());
		return commands;
	}
}
