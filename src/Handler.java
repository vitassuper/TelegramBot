package TelegramBot;

import java.util.Map;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import TelegramBot.Commands.CommandCreator;
import TelegramBot.Commands.CommandsList;
import TelegramBot.ConvertCommands.ConvertCommandsList;
import TelegramBot.ConvertCommands.ConvertTypeCreator;
import TelegramBot.Exaptions.UnknownCommand;

public class Handler {
	private SendMessage message = new SendMessage();
	public void processMessage(Update update, Bot bot) throws UnknownCommand {
		java.io.File temp;
		if (update.hasMessage()) {
			if (update.getMessage().hasText()) {
				for (Map.Entry<String, CommandCreator> entry : CommandsList.getCommands().entrySet())
					if (update.getMessage().getText().equals(entry.getKey())) {
						entry.getValue().factoryMethod().Response(update, bot);
						return;
					}
				throw new UnknownCommand("Unkwown command");
			}
			if (update.getMessage().hasDocument()) {
				Image.isSupportedType(update.getMessage().getDocument().getMimeType());
				temp = Image.downloadImage(update, message, bot);
				Keyboard key = new Keyboard();
				Message.Send(key.CreateKeyboard(update, update.getMessage().getDocument().getMimeType()), bot);
				return;
			}
			throw new UnknownCommand("Attach photo as file");
		}
		if (update.hasCallbackQuery()) {
			final String button = update.getCallbackQuery().getData();
			for (Map.Entry<String, ConvertTypeCreator> entry : ConvertCommandsList.getCommands().entrySet()) {
				if (entry.getKey().equals(button)) {
					entry.getValue().factoryMethod().Convert(temp);
				}
			}
			Image.SendImage(update, temp, bot);
			return;
		}
	}
}

