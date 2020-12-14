import processing.core.PApplet;
import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;
import java.util.Random;


public class Interpreter {
	Vector<GeometricObject_2d> objects = new Vector<GeometricObject_2d>();
	Vector<MusicGenerator> instruments = new Vector<MusicGenerator>();
	void interpret(Vector<Double> numbers) {
		Vector<Double> relevantNums = new Vector<Double>();
		Vector<Double> ascNums = new Vector<Double>();
		Vector<Double> descNums = new Vector<Double>();
		Vector<Double> polynomialAscNums = new Vector<Double>();
		Vector<Double> polynomialDescNums = new Vector<Double>();
		double netProduct;
		double average;
		
		//from highest
		
		
		//from lowest
		
		
		Random rand = new Random();
		for(int i = 0; i<numbers.size(); i++) {
			objects.add(new GeometricObject_2d());
			objects.get(i).numberAssigned = numbers.get(i);
			objects.get(i).mode = rand.nextInt(6);
			objects.get(i).interval = rand.nextInt(129);
			instruments.add(new MusicGenerator());
			instruments.get(i).numberAssigned = numbers.get(i);
			instruments.get(i).mode = rand.nextInt(5);
			instruments.get(i).interval = rand.nextInt(129);
		}
	}
}
