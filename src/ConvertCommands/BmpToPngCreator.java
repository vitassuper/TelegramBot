package TelegramBot.ConvertCommands;

import TelegramBot.ConvertCommands.ConvertTypeCreator;

public class BmpToPngCreator extends ConvertTypeCreator{

	@Override
	public IConvertAction factoryMethod() {
		return new BmpToPng();
	}

}
