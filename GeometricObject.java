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
	float osX;
	float osY;
	public void assignOffset() {
		osX= rand.nextFloat()*(2048.0f);
		osY= rand.nextFloat()*(1024.0f);
	}
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
				 shape.vertex(osX-50*numbers.get(i)*(float)Math.sin(3.14159*2.0*numbers.get(i)),osY-50*numbers.get(i)*(float)Math.cos(3.14159*2.0*numbers.get(i)));
				 shape.vertex(osX-50*numbers.get(i)*(float)Math.acos(3.14159*2.0*Math.sin(3.14159*2.0*numbers.get(i))),osY-50*numbers.get(i));
				 shape.vertex(osX-50*numbers.get(i)*(float)Math.cos(3.14159*2.0*numbers.get(i)),osY-50*numbers.get(i)*(float)Math.acos(3.14159*2.0*Math.sin(numbers.get(i))));
			 }
			 
			  
		}
		if(mode == 1) {//draw number shape ceil verts
			for(int i = 0; i<(int)Math.ceil((double)numberAssigned);i++) {
				 shape.vertex(osX-(float)Math.cos(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,osY-(float)Math.sin(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned);
				 
			 }
		}
		if(mode == 2) {//draw number shape floor verts
			for(int i = 0; i<(int)Math.floor((double)numberAssigned);i++) {
				 shape.vertex(osX-(float)Math.cos(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,osY-(float)Math.sin(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned);
				 
			 }
		}
		if(mode == 3) {//draw all numbers randomize
			for(int i = 0; i<numbers.size();i++) {
				
				 shape.vertex(osX-(float)Math.cos(3.14159*2.0*numbers.get(i))*numbers.get(i)*50,osY-(float)Math.acos(3.14159*2.0*Math.sin(3.14159*2.0*numbers.get(i)))*numbers.get(i)*50);
				 shape.vertex(osX-0,osY-(float)Math.acos(3.14159*2.0*Math.sin(numbers.get(i)))*numbers.get(i)*50);
				 shape.vertex(osX-(float)Math.sin(3.14159*2.0*numbers.get(i))*numbers.get(i)*(float)Math.cos(3.14159*2.0*numbers.get(i))*50,osY-0);
			 }
			 
		}
		if(mode == 4) {//draw all numbers complex
			  
			 for(int i = 0; i<numbers.size();i++) {
				 shape.vertex(osX-50*numbers.get(i)*(float)Math.sin(3.14159*2.0*numbers.get(i)),osY-50*numbers.get(i)*(float)Math.cos(3.14159*2.0*numbers.get(i)),50*numbers.get(i)*(float)Math.acos(3.14159*2.0*Math.sin(3.14159*2.0*numbers.get(i))));
				 shape.vertex(osX-50*numbers.get(i)*(float)Math.acos(3.14159*2.0*Math.sin(3.14159*2.0*numbers.get(i))),osY-50*numbers.get(i)*(float)Math.sin(3.14159*2.0*numbers.get(i)),50*numbers.get(i)*(float)Math.cos(3.14159*2.0*numbers.get(i)));
				 shape.vertex(osX-50*numbers.get(i)*(float)Math.cos(3.14159*2.0*numbers.get(i)),osY-50*numbers.get(i)*(float)Math.acos(3.14159*2.0*Math.sin(3.14159*2.0*numbers.get(i))),50*numbers.get(i)*(float)Math.sin(3.14159*2.0*numbers.get(i)));
			 }
			 
			  
		}
		if(mode == 5) {//draw number shape ceil verts
			for(int i = 0; i<(int)Math.ceil((double)numberAssigned);i++) {
				 shape.vertex(osX-(float)Math.cos(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,osY-(float)Math.sin(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,(float)Math.atan(((i+1.0f)/numberAssigned))*numberAssigned*50);
				 
			 }
		}
		if(mode == 6) {//draw number shape floor verts
			for(int i = 0; i<(int)Math.floor((double)numberAssigned);i++) {
				 shape.vertex(osX-(float)Math.cos(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,osY-(float)Math.sin(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,(float)Math.atan(((i+1.0f)/numberAssigned))*numberAssigned*50);
				 
			 }
		}
		if(mode == 7) {//draw all numbers randomize
			for(int i = 0; i<numbers.size();i++) {
				shape.vertex(osX-50*numbers.get(i),osY-50*numbers.get(i)*(float)Math.cos(3.14159*2.0*numbers.get(i)),50*numbers.get(i)*(float)Math.acos(3.14159*2.0*Math.sin(3.14159*2.0*numbers.get(i))));
				shape.vertex(osX-50*numbers.get(i)*(float)Math.acos(3.14159*2.0*Math.sin(3.14159*2.0*numbers.get(i))),osY-50*numbers.get(i),50*numbers.get(i)*(float)Math.cos(numbers.get(i)));
				shape.vertex(osX-50*numbers.get(i)*(float)Math.cos(3.14159*2.0*numbers.get(i)),osY-50*numbers.get(i)*(float)Math.acos(3.14159*2.0*Math.sin(3.14159*2.0*numbers.get(i))),50*numbers.get(i));
			}
			 
		}
		if(mode == 8) {//draw number shape ceil verts
			for(int i = 0; i<numbers.size();i++) {
				 shape.vertex(osX-(float)Math.cos(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,osY-(float)Math.sin(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned);
				 
			 }
		}
		if(mode == 9) {//draw number shape floor verts
			for(int i = 0;  i<numbers.size();i++) {
				 shape.vertex(osX-(float)Math.cos(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,osY-(float)Math.sin(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned);
				 
			 }
		}
		if(mode == 10) {//draw number shape ceil verts
			for(int i = 0;  i<numbers.size();i++) {
				 shape.vertex(osX-(float)Math.cos(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,osY-(float)Math.sin(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,(float)Math.atan(((i+1.0f)/numberAssigned))*numberAssigned*50);
				 
			 }
		}
		if(mode == 11) {//draw number shape floor verts
			for(int i = 0;  i<numbers.size();i++) {
				 shape.vertex(osX-(float)Math.cos(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,osY-(float)Math.sin(3.14159*2.0*((i)/numberAssigned))*100*numberAssigned,(float)Math.atan(((i+1.0f)/numberAssigned))*numberAssigned*50);
				 
			 }
		}

	}
}
