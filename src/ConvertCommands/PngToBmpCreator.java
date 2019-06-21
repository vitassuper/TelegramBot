package TelegramBot.ConvertCommands;

import TelegramBot.ConvertCommands.ConvertTypeCreator;

public class PngToBmpCreator extends ConvertTypeCreator{

	@Override
	public IConvertAction factoryMethod() {
		return new PngToBmp();
	}

}
