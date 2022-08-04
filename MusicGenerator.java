import processing.core.PApplet;
import processing.sound.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MusicGenerator {
	int mode=0;
	int interval;
	public float numberAssigned;
	public Vector<Float>sequence=new Vector<Float>();
	public void playMusic(Vector<Float> numbers) {
		Random rand= new Random();
		sequence= new Vector<Float>(128);
		if(mode == 0) {//play arpeg numbers
			for (int j= 0; j<128/numbers.size();j++){
				for(int i = 0; i<numbers.size();i++) {
					sequence.add(numbers.get(i)*110.0f);
				}
			}
			
			
		}
		if(mode == 1) {//play note exp low frequency number
			int f = 64+rand.nextInt(128)+1;
			sequence= new Vector<Float>(f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((rand.nextInt(numbers.size())))*(55f/numberAssigned);
				sequence.add((float) Math.pow(c, numberAssigned));
			}	
		}
		if(mode == 2) {//play note multiplicative scale number
			int f = 64+rand.nextInt(128)+1;
			sequence= new Vector<Float>(f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((rand.nextInt(numbers.size())))*((float)8500.0f/numberAssigned);
				sequence.add((float)c);
			}	
		}
		if(mode == 3) {//play note randoms number
			int f= 64+rand.nextInt(128)+1;
			sequence= new Vector<Float>(f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((rand.nextInt(numbers.size())))*110.0f;
				sequence.add(c);
			}	
		}
		if(mode == 4) {//play note exp low frequency number(more likely)
			int f = 64+rand.nextInt(128)+1;
			sequence= new Vector<Float>(f);
			for(int i = 0; i<f;i++) {
				float c = numbers.get((rand.nextInt(numbers.size())))*(55f/numberAssigned);
				sequence.add((float) Math.pow(c, numberAssigned));
			}	
		}
		mode = rand.nextInt(5);
	}
}