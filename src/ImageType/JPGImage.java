package TelegramBot.ImageType;

public class JPGImage implements IType{
	private final String type = "JPG";
	public void PrintKeyboard(){
		
	}
	public String getType() {
		return type;
	}
	
	JPGImage createMethod(){
	return new JPGImage();
	}
}
