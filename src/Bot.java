package TelegramBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import TelegramBot.Exaptions.UnknownCommand;

public class Bot extends TelegramLongPollingBot {

	@Override
	public void onUpdateReceived(Update update) {
		Handler handler = new Handler();
		SendMessage message = new SendMessage();
		try {
			handler.processMessage(update, this);
		} catch (UnknownCommand e) {
			Message.Send(message.setChatId(update.getMessage().getChatId()).setText(e.getMessage()), this);
			e.printStackTrace();
		}

	}

	@Override
	public String getBotUsername() {
		return "Imagebot";
	}

	@Override
	public String getBotToken() {
		return "805151464:AAG2MWu3zmV8usbUf8bo-EAnD4DMDcNSPjk";
	}

}
