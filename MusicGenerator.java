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
	double numberAssigned;
	double[]sequence;
	int note = 0; 
	void playMusic(Vector<Double> numbers) {
		Random rand= new Random();
		if(mode == 0) {//play arpeg numbers
			double[] sequence = new double[numbers.size()]; 
			for(int i = 0; i<numbers.size();i++) {
				sequence[i] = sequence[i]*110.0;
			}
			
		}
		if(mode == 1) {//play note exp frequency number
			double[] sequence= new double[rand.nextInt(129)];
			for(int i = 0; i<sequence.length;i++) {
				double c = rand.nextDouble()*(46.3/numberAssigned);
				sequence[i] =Math.pow(c, numberAssigned);
			}	
		}
		if(mode == 2) {//play note multiplicative scale number
			double[] sequence= new double[rand.nextInt(129)];
			for(int i = 0; i<sequence.length;i++) {
				double c = rand.nextDouble()*(24100/numberAssigned);
				sequence[i] =c*numberAssigned;
			}	
		}
		if(mode == 3) {//play note randoms number
			double[] sequence= new double[rand.nextInt(129)];
			for(int i = 0; i<sequence.length;i++) {
				double c = rand.nextDouble()*24100;
				sequence[i] =c;
			}	
		}
	}
}