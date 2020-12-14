import processing.core.PApplet;
import processing.core.PShape;

import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;
import java.util.Random;

public class GeometricObject_2d {
	int mode;
	int interval;
	float numberAssigned;
	public PShape shape;
	Random rand= new Random();
	public void draw(Vector<Float> numbers) {
		double index;
		shape.beginShape();
		  // You can set fill and stroke
		shape.fill(128/(numberAssigned-numberAssigned*rand.nextFloat()),128/(numberAssigned-numberAssigned*rand.nextFloat()),128/(numberAssigned-numberAssigned*rand.nextFloat()));
		shape.stroke(128/(numberAssigned-numberAssigned*rand.nextFloat()));
		shape.strokeWeight(2);
		if(mode == 0) {//draw all numbers complex
			  
			 for(int i = 0; i<numbers.size();i++) {
				 shape.vertex(250*numbers.get(i),0-interpreter.instruments.get(i).sequence.get(note.get(i).intValue() )/20);
				 shape.vertex(0+interpreter.instruments.get(i).sequence.get(note.get(i).intValue() )/20,250*numbers.get(i));
				 shape.vertex(250*numbers.get(i),0-interpreter.instruments.get(i).sequence.get(note.get(i).intValue() )/20);
			 }
			 
			  
		}
		if(mode == 1) {//draw number shape ceil verts
			for(int i = 0; i<(int)Math.ceil((double)numberAssigned);i++) {
				 shape.vertex((float)Math.asin(((i+1.0f)/numberAssigned)*300),(float)Math.acos(((i+1.0f)/numberAssigned)*300));
				 
			 }
		}
		if(mode == 2) {//draw number shape floor verts
			for(int i = 0; i<(int)Math.floor((double)numberAssigned);i++) {
				 shape.vertex((float)Math.asin(((i+1.0f)/numberAssigned)*300),(float)Math.acos(((i+1.0f)/numberAssigned)*300));
				 
			 }
		}
		if(mode == 3) {//draw all numbers randomize
			for(int i = 0; i<numbers.size();i++) {
				
				 shape.vertex(rand.nextInt(150)*numbers.get(i),rand.nextInt(150)*numbers.get(i));
				 shape.vertex(0,rand.nextInt(150)*numbers.get(i));
				 shape.vertex(rand.nextInt(150)*numbers.get(i),0);
			 }
			 
		}

	}
}
