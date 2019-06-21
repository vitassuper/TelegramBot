package TelegramBot.ImageType;

public class JPGImageCreator extends ImageTypeCreator{

	@Override
	public IType factoryMethod() {
		return new JPGImage();
	}

}
