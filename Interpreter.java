import processing.core.PApplet;
import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;
import java.util.Random;


public class Interpreter {
	public Vector<GeometricObject> objects = new Vector<GeometricObject>();
	public Vector<MusicGenerator> instruments = new Vector<MusicGenerator>();
	public void interpret(Vector<Float> numbers) {
		instruments = new Vector<MusicGenerator>(numbers.size());
		objects = new Vector<GeometricObject>(numbers.size());
		Vector<Double> relevantNums = new Vector<Double>();
		Vector<Double> ascNums = new Vector<Double>();
		Vector<Double> descNums = new Vector<Double>();
		Vector<Double> polynomialAscNums = new Vector<Double>();
		Vector<Double> polynomialDescNums = new Vector<Double>();
		Vector<Double> polynomialNums = new Vector<Double>();
		double netProduct;
		double average;
		
		//from highest
		
		
		//from lowest
		
		
		Random rand = new Random();
		for(int i = 0; i<numbers.size(); i++) {
			objects.add(i,new GeometricObject());
			objects.get(i).numberAssigned = numbers.get(i);
			objects.get(i).mode = rand.nextInt(12);
			objects.get(i).interval = numbers.get(rand.nextInt(numbers.size()));
			objects.get(i).assignOffset();
			instruments.add(i,new MusicGenerator());
			instruments.get(i).numberAssigned = numbers.get(i);
			instruments.get(i).mode = rand.nextInt(18);
			instruments.get(i).interval = 1.0f+((1.0f/(((Math.abs(((((((numbers.get(i))))))))))+1.0f)));
			if(rand.nextInt(2)==1) {
				instruments.get(i).interval = 1.0f-((1.0f/(((Math.abs(((((((numbers.get(i))))))))))+1.0f)));
			}
			instruments.get(i).playMusic(numbers);
		}
	}
}
