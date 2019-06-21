package TelegramBot.Commands;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JpgToPng implements IConvertAction{

	@Override
	public File Convert(File file) {
		File out = new File("out.png");
		try {
			BufferedImage image = ImageIO.read(file);
			ImageIO.write(image, "png", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}
}
