package TelegramBot;

import java.util.Map;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import TelegramBot.Commands.CommandCreator;
import TelegramBot.Commands.CommandsList;
import TelegramBot.Commands.ConvertCommandsList;

public class Bot extends TelegramLongPollingBot {
	private java.io.File temp;

	@Override
	public void onUpdateReceived(Update update) {

		if (update.hasMessage()) {
			SendMessage message = new SendMessage();
			if (update.getMessage().hasText()) {
				System.out.println(update.getMessage().getText());
				for (Map.Entry<String, CommandCreator> entry : CommandsList.getCommands().entrySet())
					if (update.getMessage().getText().equals(entry.getKey())) {
						entry.getValue().factoryMethod().Response(update, this);
					}
			}

			if (update.getMessage().hasDocument()) {
				Image.isSupportedType(update.getMessage().getDocument().getMimeType());
				this.temp = Image.downloadImage(update, message, this);
				Keyboard key = new Keyboard();
				Message.Send(key.CreateKeyboard(update, update.getMessage().getDocument().getMimeType()), this);
			} else
				Message.Send(message.setChatId(update.getMessage().getChatId()).setText("������������ ��� �����������"),
						this);
		} else
		/*
		 * Message.Send(message.setChatId(update.getMessage().getChatId())
		 * .setText("���������� ���� ���������� ��� ����"), this);
		 */

		if (update.hasCallbackQuery()) {
			final String button = update.getCallbackQuery().getData();
			for (String iter : ConvertCommandsList.getCommands().keySet()) {
				if (iter.equals(button)) {
					System.out.println("True");
				}
			}
			Image.SendImage(update, this.temp, this);
		}

	}

	@Override
	public String getBotUsername() {
		return "";
	}

	@Override
	public String getBotToken() {
		return "";
	}

}
