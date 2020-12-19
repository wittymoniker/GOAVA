import processing.core.PApplet;
import processing.sound.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.io.Reader; 

public class MusicGenerator {
	int mode=0;
	float interval;
	public float numberAssigned;
	public float trigger=0;
	public Vector<Float>sequence=new Vector<Float>(0);
	public void playMusic(Vector<Float> numbers) {
		Random rand= new Random();
		interval = 4;
		if(rand.nextInt(2)==1) {
			interval = 1.0f-((1.0f/(((Math.abs(((((((numberAssigned)))))))))+1.0f)));
		}
		if(mode == 0) {//play arpeg numbers multiplying each other
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for (int i= 0; i<f;i++){
				sequence.add(i,(numbers.get( (int)( (rand.nextInt(numbers.size()))))*numbers.get((int)( (rand.nextInt(numbers.size())))))*110.0f);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}
			
			
		}
		
		if(mode == 1) {//play note exp low frequency number
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get(( (int)( (rand.nextInt(numbers.size())))))*(110.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 2) {//play note multiplicative scale number
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get(( (int)( (rand.nextInt(numbers.size())))))*((float)1760.0f*4.0f/numberAssigned);
				sequence.add(i,(float)c);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 3) {//play note randoms number
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get(( (int)( (rand.nextInt(numbers.size())))))*110.0f;
				sequence.add(i,(float)c);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 4) {//play note exp low frequency number(more likely)
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get(( (int)( (rand.nextInt(numbers.size())))))*(110.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 5) {//play arpeg numbers
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for (int i= 0; i<f;i++){
				sequence.add(i,numbers.get( (int)( (rand.nextInt(numbers.size()))))*110.0f);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}
			
			
		}
		if(mode == 6) {//play note exp low frequency number
			float f =   (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = (numbers.get( (int)( (rand.nextInt(numbers.size()))))*numbers.get((int)( (rand.nextInt(numbers.size())))))*(110.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 7) {//play note exp low frequency number multiplied 3 nums
			float f =   (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = (numbers.get((int)( ( rand.nextInt(numbers.size()))))*numbers.get((int)( (rand.nextInt(numbers.size()))))*numbers.get(numbers.size()-1-(int)( (rand.nextInt(numbers.size())))))*(110.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 8) {//play arpeg numbers multiplying each other 3 nums
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for (int i= 0; i<f;i++){
				sequence.add(i,numbers.get((int)(  (rand.nextInt(numbers.size()))))+(numbers.get((int)( (rand.nextInt(numbers.size()))))*numbers.get((int)( (rand.nextInt(numbers.size()))))*numbers.get(numbers.size()-1-(int)( (rand.nextInt(numbers.size())))))*110.0f);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}
			
			
		}
		if(mode == 9) {//play arpeg numbers multiplying each other
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for (int i= 0; i<f;i++){
				sequence.add(i,(numbers.get(numbers.size()-1-(int)( (rand.nextInt(numbers.size()))))*numbers.get((int)( (rand.nextInt(numbers.size())))))*110.0f);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}
			
			
		}
		
		if(mode == 10) {//play note exp low frequency number
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((numbers.size()-1-(int)( (rand.nextInt(numbers.size())))))*(110.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 11) {//play note multiplicative scale number
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((numbers.size()-1-(int)( (rand.nextInt(numbers.size())))))*((float)1760.0f*4.0f/numberAssigned);
				sequence.add(i,(float)c);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 12) {//play note randoms number
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((numbers.size()-1-(int)( (rand.nextInt(numbers.size())))))*110.0f;
				sequence.add(i,(float)c);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 13) {//play note exp low frequency number(more likely)
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((numbers.size()-1-(int)( (rand.nextInt(numbers.size())))))*(110.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 14) {//play arpeg numbers
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for (int i= 0; i<f;i++){
				sequence.add(i,numbers.get(numbers.size()-1-(int)( (rand.nextInt(numbers.size()))))*110.0f);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}
			
			
		}
		if(mode == 15) {//play note exp low frequency number
			float f =   (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = (numbers.get(numbers.size()-1-(int)( (rand.nextInt(numbers.size()))))*numbers.get((int)( (rand.nextInt(numbers.size())))))*(110.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 16) {//play note exp low frequency number multiplied 3 nums
			float f =   (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for(int i = 0; i<f;i++) {
				float c = (numbers.get(numbers.size()-1-(int)( (rand.nextInt(numbers.size()))))*numbers.get((int)( (rand.nextInt(numbers.size()))))*numbers.get( (int)( (rand.nextInt(numbers.size())))))*(110.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 17) {//play arpeg numbers multiplying each other 3 nums
			float f =  (float)numbers.size()*8f;
			sequence= new Vector<Float>((int)f);
			for (int i= 0; i<f;i++){
				sequence.add(i,numbers.get(numbers.size()-1-(int)( (rand.nextInt(numbers.size()))))+(numbers.get((int)( (rand.nextInt(numbers.size()))))*numbers.get((int)( (rand.nextInt(numbers.size()))))*numbers.get( (int)( (rand.nextInt(numbers.size())))))*110.0f);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}
			
			
		}
		//System.out.println(sequence.size()+","+mode+"\n");
		mode = rand.nextInt(18);
	}
}