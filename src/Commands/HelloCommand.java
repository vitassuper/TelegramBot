package TelegramBot.Commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import TelegramBot.Bot;
import TelegramBot.Message;

public class HelloCommand implements IAction{

	@Override
	public void Response(Update update, Bot bot) {
		SendMessage message = new SendMessage();
		User user = update.getMessage().getFrom();
		Message.Send(message.setChatId(update.getMessage().getChatId())
				.setText("Привет, " + user.getLastName() + " " + user.getFirstName()), bot);
	}
	
}
