
// Java program to demonstrate colored to greyscale conversion 
import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
  
public class convertToBlack 
{ 
    public static void main(String args[])throws IOException 
    { 
        BufferedImage img = null; 
        File f = null; 
  
        // read image 
        try
        { 
            f = new File("C:\\Users\\jg020742\\Desktop\\Captcha4TEST.png"); 
            img = ImageIO.read(f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
  
        // get image's width and height 
        int width = img.getWidth(); 
        int height = img.getHeight(); 
  
        // convert to greyscale 
        for (int y = 0; y < height; y++) 
        { 
            for (int x = 0; x < width; x++) 
            { 
                // Here (x,y)denotes the coordinate of image  
                // for modifying the pixel value. 
                int p = img.getRGB(x,y); 
  
                int a = (p>>24)&0xff; 
                int r = (p>>16)&0xff; 
                int g = (p>>8)&0xff; 
                int b = p&0xff; 
               
                if(r == 17 && g == 224 && b == 76) {
                	
                	r = 0;
                	g = 0;
                	b = 0;
                	
                }
                
  
                
                p = (a<<24) | (r<<16) | (g<<8) | b; 
  
                img.setRGB(x, y, p); 
            } 
        } 
  
        // write image 
        try
        { 
            f = new File("C:\\Users\\jg020742\\Desktop\\CaptchaFINAL.png"); 
            ImageIO.write(img, "png", f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
        Process p = Runtime.getRuntime().exec("C:\\Users\\jg020742\\AppData\\Roaming\\JetBrains\\PyCharm Community Edition 2018.2.2\\bin\\pycharm64.exe C:\\Users\\jg020742\\PycharmProjects\\TheadingTesting\\tesseractTesting.py");
    } 
}