package TelegramBot.ConvertCommands;

import TelegramBot.ConvertCommands.ConvertTypeCreator;

public class BmpToJpgCreator extends ConvertTypeCreator{

	@Override
	public IConvertAction factoryMethod() {
		return new BmpToJpg();
	}

}
