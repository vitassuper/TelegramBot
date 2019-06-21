package TelegramBot.ConvertCommands;

import TelegramBot.ConvertCommands.ConvertTypeCreator;

public class JpgToPngCreator extends ConvertTypeCreator{

	@Override
	public IConvertAction factoryMethod() {
		return new JpgToPng();
	}

}
