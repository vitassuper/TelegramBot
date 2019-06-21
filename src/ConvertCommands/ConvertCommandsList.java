package TelegramBot.ConvertCommands;

import java.util.HashMap;

public class ConvertCommandsList {
	private static HashMap<String, ConvertTypeCreator> commands;
	
	public static HashMap<String, ConvertTypeCreator> getCommands() {
		commands = new HashMap<String, ConvertTypeCreator>();
		commands.put("BMP to JPG", new BmpToJpgCreator());
		commands.put("BMP to PNG", new BmpToPngCreator());
		commands.put("PNG to BMP", new PngToBmpCreator());
		commands.put("PNG to JPG", new PngToJpgCreator());
		commands.put("JPG to BMP", new JpgToBmpCreator());
		commands.put("JPG to PNG", new JpgToPngCreator());
		return commands;
	}
}
