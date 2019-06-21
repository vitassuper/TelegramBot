package TelegramBot.Commands;

public class HelloCommandCreator extends CommandCreator{

	@Override
	public IAction factoryMethod() {
		return new HelloCommand();
	}
	
}
