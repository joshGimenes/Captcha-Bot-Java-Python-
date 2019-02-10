import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
public class getRidOfExtra {
	public static void main(String[] args) {
	
	
	int counter = 0;
	
		  BufferedImage img = null; 
	        File f = null; 
	  
	        // read image 
	        try
	        { 
	            f = new File("C:\\Users\\harry\\Desktop\\Captcha4.png"); 
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
	               
	            	counter = 0;
	            	// Here (x,y)denotes the coordinate of image  
	                // for modifying the pixel value. 
	                int p = img.getRGB(x,y); 
	  
	                int a = (p>>24)&0xff; 
	                int r = (p>>16)&0xff; 
	                int g = (p>>8)&0xff; 
	                int b = p&0xff; 
	              
	                
	                
    				
	            	int[] arrayListX = new int[8];
	            	int[] arrayListY = new int[8];
	            	
	            	
	            	
	            	if(r==0||g==0||b==0) {
	            		if(x > 3 && x < 227 && y > 3 && y < 47) {
	            			
	            		
	            		for(int i = 0; i < 8; i++){
		            		
		            		if(i == 0){
		            			arrayListX[i] = x+1;
		            			arrayListY[i] = y;
		            		}else if(i == 1){
		            			arrayListX[i] = x-1;
		            			arrayListY[i] = y;
		            		}else if(i == 2){
		            			arrayListX[i] = x+1;
		            			arrayListY[i] = y+1;
		            		}else if(i == 3){
		            			arrayListX[i] = x;
		            			arrayListY[i] = y+1;
		            		}else if(i == 4){
		            			arrayListX[i] = x-1;
		            			arrayListY[i] = y+1;
		            		}else if(i == 5){
		            			arrayListX[i] = x+1;
		            			arrayListY[i] = y-1;
		            		}else if(i == 6){
		            			arrayListX[i] = x;
		            			arrayListY[i] = y-1;
		            		}else if(i == 7){
		            			arrayListX[i] = x-1;
		            			arrayListY[i] = y-1;
	            	}
		            		
	            		}
	            	
	            	int[][] listsXY = {arrayListX,arrayListY};
	            		
	            		for(int u = 0; u < 8; u++ ){
	            			int theX = listsXY[0][u];
	            			int theY = listsXY[1][u];
	            			
	            			int p2 = img.getRGB(theX,theY); 
	            	        
	                        int a2 = (p2>>24)&0xff; 
	                        int r2 = (p2>>16)&0xff; 
	                        int g2 = (p2>>8)&0xff; 
	                        int b2 = p2&0xff; 
	                        
	                        if(r2 == 255 && g2 == 225 && b2 == 255) {
	                        	System.out.println("here");
	                        	counter = counter + 1;
	                        	System.out.println(counter);
	                        	if(counter == 6) {
	                        		r = 255;
	                        		b = 255;
	                        		g = 255;
	                        		  p = (a<<24) | (r<<16) | (g<<8) | b; 
	                      	        
	                                  img.setRGB(x, y, p); 
	                        	}
	                        	
	                        }
	                        }
	                        	
	                
	            		}
	            }
	        }
	
	
	
	
		
		
		
		
		/*
	        if(r == 17 && g == 224 && b == 76) {
            	r = 0;
            	g = 0;
            	b = 0;
            	
            	
            }
		
		*/
		
	
	}
	        
	        
	        
	        try
	        { 
	            f = new File("C:\\Users\\harry\\Desktop\\Captcha5.png"); 
	            ImageIO.write(img, "png", f); 
	        } 
	        catch(IOException e) 
	        { 
	            System.out.println(e); 
	        }  
	        
	        
	        
	        
}
}