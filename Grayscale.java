import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
  
public class Grayscale 
{ 
    public static void main(String args[])throws IOException 
    { 
        BufferedImage img = null; 
        File f = null; 
  
        try
        { 
            f = new File("C:\\Users\\harry\\Desktop\\Captcha.png"); 
            img = ImageIO.read(f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
       
        int width = img.getWidth(); 
        int height = img.getHeight(); 
  
       
        for (int y = 0; y < height; y++) 
        { 
            for (int x = 0; x < width; x++) 
            { 
               
                int p = img.getRGB(x,y); 
  
                int a = (p>>24)&0xff; 
                int r = (p>>16)&0xff; 
                int g = (p>>8)&0xff; 
                int b = p&0xff; 
  
                if(b > 90 || r > 45 || g > 45){
                	a = 0;
                	r = 255;
                	g = 255;
                	b = 255;
                }if(b < 240 || r < 240 || g < 240){
                	a = 0;
                	r = 0;
                	g = 0;
                	b = 0;
                }
                if (x == 0 || x == 229|| y == 49 || y == 0){
                	r = 255;
                	g = 255;
                	b = 255;
                	a = 0;
                	
                }
               
                p = (a<<24) | (r<<16) | (g<<8) | b; 
                img.setRGB(x, y, p); 
            } 
        } 

        try
        { 
            f = new File("C:\\Users\\harry\\Desktop\\Captcha2.png"); 
            ImageIO.write(img, "png", f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
    } 
} 