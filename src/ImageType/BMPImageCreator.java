package TelegramBot.ImageType;

public class BMPImageCreator extends ImageTypeCreator{

	@Override
	public IType factoryMethod() {
		return new BMPImage();
	}

}
