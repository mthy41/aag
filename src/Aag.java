import javax.imageio.ImageIO;
import java.awt.Color;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Aag{
    final static char[] chars = {' ', '.', '+', '*', '$', '#', '@'};
    final static Integer MAXSIZE = 200;

    public static void write(String absFilePath, String absOutputPath) throws IOException{
        BufferedImage img = ImageIO.read(new File(absFilePath));
        if(img.getWidth() > MAXSIZE || img.getHeight() > MAXSIZE){
            throw new IOException("error in parsing image: max size limit");
        }

        int imgWidth = img.getWidth();
        int imgHeight = img.getHeight();

        File txt = new File(absOutputPath+"output.txt");
        FileWriter fWriter = new FileWriter(txt);
        BufferedWriter bWriter = new BufferedWriter(fWriter);

        for(int x = 0; x < imgHeight; x++){
            for(int y = 0; y < imgWidth; y++){
                Color px = new Color(img.getRGB(y, x));
                // bWriter.write(" ");
                int median = (int)((px.getRed() + px.getGreen() + px.getBlue())/3);

                for (float i = 0.0f; i < chars.length; i++ ){
                    //warning: casting hell
                    float range = (i+1.0f)*(float)(Math.ceil(255.0f/(float)chars.length));
                    if(median < range){bWriter.write(chars[(int)i]); break;}
                }
            }
            bWriter.write("\n");
        }
        bWriter.close();
    }
}