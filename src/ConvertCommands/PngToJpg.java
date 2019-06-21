package TelegramBot.ConvertCommands;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PngToJpg implements IConvertAction{

	@Override
	public File Convert(File file) {
		File out = new File("out.jpg");
		try {
			BufferedImage image = ImageIO.read(file);
			BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
			result.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
			ImageIO.write(result, "jpg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

}
