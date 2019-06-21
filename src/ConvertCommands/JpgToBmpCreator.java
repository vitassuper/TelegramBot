package TelegramBot.ConvertCommands;

public class JpgToBmpCreator extends ConvertTypeCreator{

	@Override
	public IConvertAction factoryMethod() {
		return new JpgToBmp();
	}

}
