package TelegramBot.Commands;

import org.telegram.telegrambots.meta.api.objects.Update;

import TelegramBot.Bot;

public interface IAction {
	public void Response(Update update, Bot bot);
}
