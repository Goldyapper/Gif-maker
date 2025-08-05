import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageLoader {
    public static ArrayList<BufferedImage> loadImages(String folderPath) throws IOException {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        ArrayList<BufferedImage> images = new ArrayList<>();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".jpg")) {
                BufferedImage img = ImageIO.read(file);
                images.add(img);
            }
        }
        return images;
    }
}
