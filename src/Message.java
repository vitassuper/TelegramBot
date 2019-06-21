package TelegramBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Message {
	public static void Send(SendMessage message, Bot bot) {
		try {
			bot.execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
