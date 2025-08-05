import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            String folderPath = "Photos-to-Gif"; 
            String outputFilePath = "output.gif";  // Path to save your GIF

            ArrayList<BufferedImage> frames = ImageLoader.loadImages(folderPath);

            System.out.println("Images loaded: " + frames.size());

        } catch (IOException e) {
            System.err.println("Error loading images: " + e.getMessage());
        }
    }
}
