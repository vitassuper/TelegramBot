package TelegramBot.ConvertCommands;

import TelegramBot.ConvertCommands.ConvertTypeCreator;

public class PngToJpgCreator extends ConvertTypeCreator{

	@Override
	public IConvertAction factoryMethod() {
		return new PngToJpg();
	}
	
}
