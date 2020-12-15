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
		interval = 1.0f+((1.0f/(((Math.abs(((((((numberAssigned)))))))))+1.0f)));
		if(rand.nextInt(2)==1) {
			interval = 1.0f-((1.0f/(((Math.abs(((((((numberAssigned)))))))))+1.0f)));
		}
		if(mode == 0) {//play arpeg numbers multiplying each other
			int f =128+rand.nextInt(129);
			sequence= new Vector<Float>(f);
			for (int i= 0; i<(sequence.size());i++){
				sequence.add(i,(numbers.get(rand.nextInt(numbers.size()))*numbers.get(rand.nextInt(numbers.size())))*110.0f);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}
			
			
		}
		
		if(mode == 1) {//play note exp low frequency number
			int f = 128+rand.nextInt(129);
			sequence= new Vector<Float>(f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((rand.nextInt(numbers.size())))*(55.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 2) {//play note multiplicative scale number
			int f = 128+rand.nextInt(129);
			sequence= new Vector<Float>(f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((rand.nextInt(numbers.size())))*((float)8500.0f/numberAssigned);
				sequence.add(i,(float)c);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 3) {//play note randoms number
			int f= 128+rand.nextInt(129);
			sequence= new Vector<Float>(f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((rand.nextInt(numbers.size())))*110.0f;
				sequence.add(i,(float)c);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 4) {//play note exp low frequency number(more likely)
			int f = 128+rand.nextInt(129);
			sequence= new Vector<Float>(f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((rand.nextInt(numbers.size())))*(55.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 5) {//play arpeg numbers
			int f =128+rand.nextInt(129);
			sequence= new Vector<Float>(f);
			for (int i= 0; i<(sequence.size());i++){
				sequence.add(i,numbers.get(rand.nextInt(numbers.size()))*110.0f);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}
			
			
		}
		if(mode == 6) {//play note exp low frequency number
			int f = 128+rand.nextInt(129);
			sequence= new Vector<Float>(f);
			for(int i = 0; i<f;i++) {
				float c = (numbers.get(rand.nextInt(numbers.size()))*numbers.get(rand.nextInt(numbers.size())))*(55.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 7) {//play note exp low frequency number multiplied 3 nums
			int f = 128+rand.nextInt(129);
			sequence= new Vector<Float>(f);
			for(int i = 0; i<f;i++) {
				float c = (numbers.get(rand.nextInt(numbers.size()))*numbers.get(rand.nextInt(numbers.size()))*numbers.get(rand.nextInt(numbers.size())))*(55.0f/numberAssigned);
				sequence.add(i,(float) Math.pow(c, numberAssigned));
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}	
		}
		if(mode == 8) {//play arpeg numbers multiplying each other 3 nums
			int f =128+rand.nextInt(129);
			sequence= new Vector<Float>(f);
			for (int i= 0; i<(sequence.size());i++){
				sequence.add(i,numbers.get(rand.nextInt(numbers.size()))+(numbers.get(rand.nextInt(numbers.size()))*numbers.get(rand.nextInt(numbers.size()))*numbers.get(rand.nextInt(numbers.size())))*110.0f);
				if(sequence.get(i)==null) {
					System.out.println("\n"+sequence.get(i));
				}
			}
			
			
		}
		//System.out.println(sequence.get(0));
		mode = rand.nextInt(9);
	}
}