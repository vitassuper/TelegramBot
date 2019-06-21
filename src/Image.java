package TelegramBot;

import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import TelegramBot.ImageType.TypesList;

public class Image {
	
	public static void isSupportedType(String type){
		for (String iter : TypesList.getTypesList().keySet()) {
			if (type.equals(iter)) return;
		}
		throw new RuntimeException("Неподдерживаемый тип");
	}
	
	public static void SendImage(Update update, java.io.File file, Bot bot) {
		SendDocument sendPhotoRequest = new SendDocument();
		sendPhotoRequest.setChatId(update.getCallbackQuery().getMessage().getChatId());
		sendPhotoRequest.setDocument(file);
		try {
			bot.execute(sendPhotoRequest.setChatId(update.getCallbackQuery().getMessage().getChatId()));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	public static java.io.File downloadImage(Update update, SendMessage message, Bot bot) {
		java.io.File temp = null;
		String uploadedFileId = update.getMessage().getDocument().getFileId();
		GetFile uploadedFile = new GetFile();
		uploadedFile.setFileId(uploadedFileId);
		try {
			File file = bot.execute(uploadedFile);
			temp = bot.downloadFile(file.getFilePath());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
		return temp;
	}
}
