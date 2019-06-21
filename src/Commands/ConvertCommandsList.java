package TelegramBot.Commands;

import java.util.HashMap;

public class ConvertCommandsList {
	private static HashMap<String, IConvertAction> commands;
	
	public static HashMap<String, IConvertAction> getCommands() {
		commands = new HashMap<String, IConvertAction>();
		commands.put("BMP to JPG", new BmpToJpg());
		commands.put("BMP to PNG", new BmpToPng());
		commands.put("PNG to BMP", new PngToBmp());
		commands.put("PNG to JPG", new PngToJpg());
		commands.put("JPG to BMP", new JpgToBmp());
		commands.put("JPG to PNG", new JpgToPng());
		return commands;
	}
}
