package TelegramBot.ImageType;

import java.util.HashMap;

public class TypesList {
	private static HashMap<String, ImageTypeCreator> types;
	
	public static HashMap<String, ImageTypeCreator> getTypesList(){
		types = new HashMap<String, ImageTypeCreator>();
		types.put("image/bmp", new BMPImageCreator());
		types.put("image/png", new PNGImageCreator());
		types.put("image/jpeg", new JPGImageCreator());
		return types;
	}
}