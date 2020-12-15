import processing.core.PApplet;
import processing.core.PShape;

import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;
import java.util.Random;

public class GeometricObject {
	int mode;
	float interval;
	float numberAssigned;
	public PShape shape;
	Random rand= new Random();
	public void draw(Vector<Float> numbers) {
		interval = 1.0f+((1.0f/(((Math.abs(((((((numberAssigned)))))))))+1.0f)));
		if(rand.nextInt(2)==1) {
			interval = 1.0f-((1.0f/(((Math.abs(((((((numberAssigned)))))))))+1.0f)));
		}
		double index;
		shape.beginShape();
		  // You can set fill and stroke
		shape.fill(128/(numberAssigned-numberAssigned*rand.nextFloat()),128/(numberAssigned-numberAssigned*rand.nextFloat()),128/(numberAssigned-numberAssigned*rand.nextFloat()));
		shape.stroke(128/(numberAssigned-numberAssigned*rand.nextFloat()));
		shape.strokeWeight(2);
		if(mode == 0) {//draw all numbers complex
			  
			 for(int i = 0; i<numbers.size();i++) {
				 shape.vertex(50*numbers.get(i)*(float)Math.sin(numbers.get(i)),-50*numbers.get(i)*(float)Math.cos(numbers.get(i)));
				 shape.vertex(50*numbers.get(i)*(float)Math.tan(numbers.get(i)*(float)Math.sin(numbers.get(i))),-50*numbers.get(i));
				 shape.vertex(50*numbers.get(i)*(float)Math.cos(numbers.get(i)),-50*numbers.get(i)*(float)Math.cos(numbers.get(i))*(float)Math.tan(numbers.get(i)));
			 }
			 
			  
		}
		if(mode == 1) {//draw number shape ceil verts
			for(int i = 0; i<(int)Math.ceil((double)numberAssigned);i++) {
				 shape.vertex((float)Math.asin(((i+1.0f)/numberAssigned))*50,(float)Math.acos(((i+1.0f)/numberAssigned))*50);
				 
			 }
		}
		if(mode == 2) {//draw number shape floor verts
			for(int i = 0; i<(int)Math.floor((double)numberAssigned);i++) {
				 shape.vertex((float)Math.asin(((i+1.0f)/numberAssigned))*50,(float)Math.acos(((i+1.0f)/numberAssigned))*50);
				 
			 }
		}
		if(mode == 3) {//draw all numbers randomize
			for(int i = 0; i<numbers.size();i++) {
				
				 shape.vertex((float)Math.cos(numbers.get(i))*numbers.get(i)*50,(float)Math.tan(numbers.get(i))*numbers.get(i)*50);
				 shape.vertex(0,(float)Math.tan(numbers.get(i))*numbers.get(i)*(float)Math.sin(numbers.get(i))*50);
				 shape.vertex((float)Math.sin(numbers.get(i))*numbers.get(i)*(float)Math.cos(numbers.get(i))*50,0);
			 }
			 
		}
		if(mode == 4) {//draw all numbers complex
			  
			 for(int i = 0; i<numbers.size();i++) {
				 shape.vertex(50*numbers.get(i)*(float)Math.sin(numbers.get(i)),-50*numbers.get(i)*(float)Math.cos(numbers.get(i)),50*numbers.get(i)*(float)Math.tan(numbers.get(i)*(float)Math.sin(numbers.get(i))));
				 shape.vertex(50*numbers.get(i)*(float)Math.tan(numbers.get(i)*(float)Math.sin(numbers.get(i))),-50*numbers.get(i)*(float)Math.sin(numbers.get(i)),50*numbers.get(i)*(float)Math.cos(numbers.get(i)));
				 shape.vertex(50*numbers.get(i)*(float)Math.cos(numbers.get(i)),-50*numbers.get(i)*(float)Math.cos(numbers.get(i))*(float)Math.tan(numbers.get(i)),50*numbers.get(i)*(float)Math.sin(numbers.get(i)));
			 }
			 
			  
		}
		if(mode == 5) {//draw number shape ceil verts
			for(int i = 0; i<(int)Math.ceil((double)numberAssigned);i++) {
				 shape.vertex((float)Math.asin(((i+1.0f)/numberAssigned))*50,(float)Math.acos(((i+1.0f)/numberAssigned))*50,(float)Math.tan(((i+1.0f)/numberAssigned))*numberAssigned*50*(float)Math.cos(((i+1.0f)/numberAssigned))*50);
				 
			 }
		}
		if(mode == 6) {//draw number shape floor verts
			for(int i = 0; i<(int)Math.floor((double)numberAssigned);i++) {
				 shape.vertex((float)Math.asin(((i+1.0f)/numberAssigned))*50,(float)Math.acos(((i+1.0f)/numberAssigned))*50,(float)Math.tan(((i+1.0f)/numberAssigned))*numberAssigned*50*(float)Math.sin(((i+1.0f)/numberAssigned))*50);
				 
			 }
		}
		if(mode == 7) {//draw all numbers randomize
			for(int i = 0; i<numbers.size();i++) {
				shape.vertex(50*numbers.get(i),-50*numbers.get(i)*(float)Math.cos(numbers.get(i)),50*numbers.get(i)*(float)Math.tan(numbers.get(i)*(float)Math.sin(numbers.get(i))));
				shape.vertex(50*numbers.get(i)*(float)Math.tan(numbers.get(i)*(float)Math.sin(numbers.get(i))),-50*numbers.get(i),50*numbers.get(i)*(float)Math.cos(numbers.get(i)));
				shape.vertex(50*numbers.get(i)*(float)Math.cos(numbers.get(i)),-50*numbers.get(i)*(float)Math.cos(numbers.get(i))*(float)Math.tan(numbers.get(i)),50*numbers.get(i));
			}
			 
		}

	}
}
