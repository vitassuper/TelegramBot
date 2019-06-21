package TelegramBot.ImageType;

public class PNGImageCreator extends ImageTypeCreator{

	@Override
	public IType factoryMethod() {
		
		return new PNGImage();
	}

}
