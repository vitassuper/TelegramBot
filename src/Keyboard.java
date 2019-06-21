package TelegramBot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import TelegramBot.ImageType.ImageTypeCreator;
import TelegramBot.ImageType.TypesList;

public class Keyboard {

	public SendMessage CreateKeyboard(Update update, String type) {
		InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
		List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
		String currentType = new String();
		for (Map.Entry<String, ImageTypeCreator> entry : TypesList.getTypesList().entrySet()) {
			if (type.equals(entry.getKey()))
				currentType = entry.getValue().factoryMethod().getType();
		}
		for (Map.Entry<String, ImageTypeCreator> entry : TypesList.getTypesList().entrySet()) {
			if (!type.equals(entry.getKey())) {
				ImageTypeCreator ImageType = entry.getValue();
				keyboardButtonsRow1.add(
						new InlineKeyboardButton().setText(currentType + " TO " + ImageType.factoryMethod().getType())
								.setCallbackData(currentType + " TO " + ImageType.factoryMethod().getType()));
			}
		}
		List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
		rowList.add(keyboardButtonsRow1);
		inlineKeyboardMarkup.setKeyboard(rowList);
		return new SendMessage().setChatId(update.getMessage().getChatId()).setText("Выберите тип конвертации")
				.setReplyMarkup(inlineKeyboardMarkup);
	}
}
