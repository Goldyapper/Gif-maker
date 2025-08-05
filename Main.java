import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            String folderPath = "Photos-to-Gif"; 
            String outputFilePath = "output.gif";  // Path to save your GIF

            ArrayList<BufferedImage> frames = ImageLoader.loadImages(folderPath);
            System.out.println("Images loaded: " + frames.size());
            
            if (frames.size() > 0) {
                // Create output stream for the gif file
                ImageOutputStream output = ImageIO.createImageOutputStream(new File(outputFilePath));

                // Create GifSequenceWriter
                GifSequenceWriter writer = new GifSequenceWriter(output,
                        frames.get(0).getType(), 500, true);  // 500 ms delay, loop forever

                // Write each frame
                for (BufferedImage frame : frames) {
                    writer.writeToSequence(frame);
                }

                writer.close();
                output.close();
                System.out.println("GIF created successfully: " + outputFilePath);
            } else {
                System.out.println("No frames to create GIF.");
            }
        } 
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());        
        }
    }
}
