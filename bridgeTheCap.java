import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO; 
public class bridgeTheCap {

	public static void main(String[] args) {

		
		findCandidates();
		
		
		
		
		
		
	}
	private static void findCandidates() {
		BufferedImage img = null; 
        File f = null; 
  

        try
        { 
            f = new File("C:\\Users\\harry\\Desktop\\Captcha2.png"); 
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
            	

            	
            	if(r < 30 && g < 30 && b < 30){
            		int foundX = x;
            		int foundY = y;
            	

            		int[][] listsXY = findNearPixels(foundX,foundY);
            		
            		for(int u = 0; u < 8; u++ ){
            			int theX = listsXY[0][u];
            			int theY = listsXY[1][u];
            			System.out.println("x: " + theX);
            			System.out.println("y: " + theY);
            			

            			if(theY < 49 && theY > 1 && theX > 1 && theX < 229){
            				
            			
            			int p2 = img.getRGB(theX,theY); 
        
                        int a2 = (p2>>24)&0xff; 
                        int r2 = (p2>>16)&0xff; 
                        int g2 = (p2>>8)&0xff; 
                        int b2 = p2&0xff; 
 
                        if(b2 == 255){

            				a2 = 1;
            				r2 = 17;
            				g2 = 224; 
            				b2 = 76;
            				System.out.println("Found white");
            				p2 = (a2<<24) | (r2<<16) | (g2<<8) | b2; 
            				  
            	            img.setRGB(theX, theY, p2); 
            			}
            			}
            			
            		}
            		
            	
            	}
            	
            	
           
        
            }
            }
        
        try
        { 
            f = new File("C:\\Users\\harry\\Desktop\\Captcha3.png"); 
            ImageIO.write(img, "png", f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
        
        
	}
public static int[][] findNearPixels(int px, int py){
	 
	
	
	
	int[] arrayListX = new int[8];
	int[] arrayListY = new int[8];
	
	
	
	
	
	
	for(int i = 0; i < 8; i++){
		
		if(i == 0){
			arrayListX[i] = px+1;
			arrayListY[i] = py;
		}else if(i == 1){
			arrayListX[i] = px-1;
			arrayListY[i] = py;
		}else if(i == 2){
			arrayListX[i] = px+1;
			arrayListY[i] = py+1;
		}else if(i == 3){
			arrayListX[i] = px;
			arrayListY[i] = py+1;
		}else if(i == 4){
			arrayListX[i] = px-1;
			arrayListY[i] = py+1;
		}else if(i == 5){
			arrayListX[i] = px+1;
			arrayListY[i] = py-1;
		}else if(i == 6){
			arrayListX[i] = px;
			arrayListY[i] = py-1;
		}else if(i == 7){
			arrayListX[i] = px-1;
			arrayListY[i] = py-1;
		
        
		}

	
	}
	int[][] listOfLists = {arrayListX,arrayListY};
	return listOfLists;
}

	
}

