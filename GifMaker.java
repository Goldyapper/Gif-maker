import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GifMaker {
    public static void createGif(String outputPath, ArrayList<BufferedImage> frames, int delayMs) throws IOException {
        AnimatedGifEncoder gifEncoder = new AnimatedGifEncoder();
        gifEncoder.start(new FileOutputStream(outputPath));
        gifEncoder.setDelay(delayMs); // Delay between frames in ms
        gifEncoder.setRepeat(0); // Loop indefinitely

        for (BufferedImage frame : frames) {
            gifEncoder.addFrame(frame);
        }

        gifEncoder.finish();
        System.out.println("GIF created at: " + outputPath);
    }
}
