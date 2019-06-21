package TelegramBot.Exaptions;

public class UnknownCommand extends Exception {

	private static final long serialVersionUID = 1L;

	public UnknownCommand(String string) {
		super(string);
	}
	
}
