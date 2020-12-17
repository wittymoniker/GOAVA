import processing.core.PApplet;
import java.util.Scanner;
import java.util.Vector;
import processing.sound.*;

import java.util.Random;
import java.io.Reader; 




public class UI_Main extends PApplet{
	Vector<Float> numbers=new Vector<Float>();
	public static void main(String[] args) {
		PApplet.main("UI_Main");
		Thread.currentThread().setPriority((int)(Thread.MAX_PRIORITY*0.8));
	}
	float time =1.0f;
	Interpreter interpreter = new Interpreter();
	public void init() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter how many numbers you wish to include: ");
		int n = reader.nextInt(); // Scans the next token of the input as an int.
		//once finished
		System.out.println("Enter time in seconds for a step(your numbers can now be decimals): ");
		time = reader.nextFloat();
		
		for(int i=0; i<n; i++) {
			System.out.println("Enter a number for up to "+(i+1)+"/"+n+": ");
			Float x  = reader.nextFloat(); // Scans the next token of the input as an int.
			//once finished
			numbers.add(x);
		}
		for(int i=0; i<n; i++) {
			System.out.println(numbers.get(i));
		}
		
		interpreter.interpret(numbers);
		for(int i = 0; i<numbers.size();i++) {
			//Interpreter.objects.get(i).draw(numbers);
			interpreter.instruments.get(i).playMusic(numbers);
		    //Pulses[i].amp((float)1/(float)numbers.size());
		    //Pulses[i].freq((float) Interpreter.instruments.get(i).sequence[0]);
		}
		reader.close();
	}
	public void settings(){
		size(2046, 1024, P3D);
	}
	public void setup() {
		init();
	}
	public Vector<Integer> note = new Vector<Integer>(numbers.size());
	public Vector<Vector<Pulse>> Oscs = new Vector<Vector<Pulse>>();
	
	boolean done=false;
	Random rand= new Random();
	int trigger = 0;
	public void draw(){
		float duration = (int) (1000*time);
		
		/*
		

		// This variable stores the point in time when the next note should be triggered
		int trigger = millis(); 
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter how many seconds this clip should be: ");
		int n = reader.nextInt(); // Scans the next token of the input as an int.*/
		
		while(!done) {
			//frame.setLocation(1024, 128);
			ambientLight(140,140,140);
			for(int b = 0; b<numbers.size();b++) {
				//Interpreter.objects.get(i).draw(numbers);
				interpreter.instruments.get(b).playMusic(numbers);
				Oscs.add(new Vector<Pulse>());
				//((Vector<Pulse>)Oscs.get(b)).setSize(8);
				((Vector<Pulse>)Oscs.get(b)).add(new Pulse(this));
				((Vector<Pulse>)Oscs.get(b)).add(new Pulse(this));
				((Vector<Pulse>)Oscs.get(b)).add(new Pulse(this));
				((Vector<Pulse>)Oscs.get(b)).add(new Pulse(this));
				((Vector<Pulse>)Oscs.get(b)).add(new Pulse(this));
				((Vector<Pulse>)Oscs.get(b)).add(new Pulse(this));
				//((Vector<Pulse>)Oscs.get(b)).add(new Pulse(this));
				//((Vector<Pulse>)Oscs.get(b)).add(new Pulse(this));
				note.add((int)1);
				//System.out.println(note.get(b).intValue());
				((Vector<Pulse>)Oscs.get(b)).get(0).width(1.0f/(1.0f+numbers.get(b)));
				((Vector<Pulse>)Oscs.get(b)).get(1).width(2.0f/(2.0f+numbers.get(b)*2));
				((Vector<Pulse>)Oscs.get(b)).get(2).width(3.0f/(3.0f+numbers.get(b)*3));
				((Vector<Pulse>)Oscs.get(b)).get(3).width(4.0f/(4.0f+numbers.get(b)*4));
				((Vector<Pulse>)Oscs.get(b)).get(4).width(5.0f/(5.0f+numbers.get(b)*5));
				((Vector<Pulse>)Oscs.get(b)).get(5).width(6.0f/(6.0f+numbers.get(b)*6));
				//((Vector<Pulse>)Oscs.get(b)).get(6).width(7.0f/(7.0f+numbers.get(b)*7));
				//((Vector<Pulse>)Oscs.get(b)).get(7).width(8.0f/(8.0f+numbers.get(b)*8));
				((Vector<Pulse>)Oscs.get(b)).get(0).play(110,(float)1.0f/(float)(numbers.size()*4));
				((Vector<Pulse>)Oscs.get(b)).get(1).play(110/(numbers.get(b)),(float)1.0f/(float)(numbers.size()*6));
			    ((Vector<Pulse>)Oscs.get(b)).get(2).play(110/(1.0f+abs(pow(numbers.get(b),2.0f))),(float)1.0f/(float)(numbers.size()*10));
			    ((Vector<Pulse>)Oscs.get(b)).get(3).play(110/(1.0f+abs(pow(numbers.get(b),3.0f))),(float)1.0f/(float)(numbers.size()*10));
			    ((Vector<Pulse>)Oscs.get(b)).get(4).play(110/(1.0f+abs(pow(numbers.get(b),4.0f))),(float)1.0f/(float)(numbers.size()*13));
			    ((Vector<Pulse>)Oscs.get(b)).get(5).play(110*(1.0f+abs(pow(numbers.get(b),0.5f))),(float)1.0f/(float)(numbers.size()*10));
			    //((Vector<Pulse>)Oscs.get(b)).get(6).play(110*(1.0f+abs(pow(numbers.get(b),.333f))),(float)1.0f/(float)(numbers.size()*12));
			    //((Vector<Pulse>)Oscs.get(b)).get(7).play(110*(1.0f+abs(pow(numbers.get(b),0.25f))),(float)1.0f/(float)(numbers.size()*13));
			    //interpreter.objects.get(b).shape = createShape();
			}
			done=true;
		}
		
		background(0);
		
			for(int c = 0; c<numbers.size();c++) {
				pushMatrix();
				Vector<Float>used = new Vector<Float>(0);
				used = new Vector<Float>(numbers.size());
				int i = rand.nextInt(numbers.size());
				if(used.contains((float)i)) {
					for (int j=numbers.size()-1;j>-1;j--) {
						i = j;
						if(!used.contains((float)i)) {
							j=numbers.size();
						}
					}
				}
				if(used.contains((float)i)) {
					c=numbers.size();
				}
				used.add((float)i);
				
				if(interpreter.instruments.get(i).sequence.size() != 0) {
					int j =rand.nextInt(8);
					
					
					translate(128,768);
					if(j==1) {
						translate(2046-6*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/100,-1024+note.get(i).intValue()*24*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/6000,-interpreter.instruments.get(i).numberAssigned-256*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/1000);
						rotateX((float)(numbers.get(i)*millis()*0.001f*time));
						rotateY((float)(numbers.get(i)*millis()*0.001f*time));
						rotateZ((float)(numbers.get(i)*millis()*0.001f*time));
					}
					if(j==2){
						translate(2046-note.get(i).intValue()*24*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/6000,-1024+6*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1)/100,-interpreter.instruments.get(i).numberAssigned-256*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/1000);
						rotateX((float)-(numbers.get(i)*millis()*0.001f*time));
						rotateY((float)(numbers.get(i)*millis()*0.001f*time));
						rotateZ((float)-(numbers.get(i)*millis()*0.001f*time));
					}
					if(j==3) {
						translate(2046-6*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1)/100,-1024+note.get(i).intValue()*24*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/6000,-interpreter.instruments.get(i).numberAssigned-256*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/1000);
						rotateX((float)(numbers.get(i)*millis()*0.001f*time));
						rotateY((float)-(numbers.get(i)*millis()*0.001f*time));
						rotateZ((float)(numbers.get(i)*millis()*0.001f*time));
					}
					if(j==0){
						translate(2046-note.get(i).intValue()*24*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/6000,-1024+6*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/100,-interpreter.instruments.get(i).numberAssigned-256*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/1000);
						rotateX((float)-(numbers.get(i)*millis()*0.001f*time));
						rotateY((float)-(numbers.get(i)*millis()*0.001f*time));
						rotateZ((float)-(numbers.get(i)*millis()*0.001f*time));
					}
					if(j==4) {
						translate(6*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/100,-note.get(i).intValue()*24*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/6000,-interpreter.instruments.get(i).numberAssigned-256*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/1000);
						rotateX((float)(numbers.get(i)*millis()*0.001f*time));
						rotateY((float)(numbers.get(i)*millis()*0.001f*time));
						rotateZ((float)-(numbers.get(i)*millis()*0.001f*time));
					}
					if(j==5){
						translate(note.get(i).intValue()*24*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/6000,-6*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1)/100,-interpreter.instruments.get(i).numberAssigned-256*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/1000);
						rotateX((float)-(numbers.get(i)*millis()*0.001f*time));
						rotateY((float)(numbers.get(i)*millis()*0.001f*time));
						rotateZ((float)-(numbers.get(i)*millis()*0.001f*time));
					}
					if(j==6) {
						translate(6*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1)/100,-note.get(i).intValue()*24*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/6000,-interpreter.instruments.get(i).numberAssigned-256*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/1000);
						rotateX((float)-(numbers.get(i)*millis()*0.001f*time));
						rotateY((float)-(numbers.get(i)*millis()*0.001f*time));
						rotateZ((float)(numbers.get(i)*millis()*0.001f*time));
					}
					if(j==7){
						translate(note.get(i).intValue()*24*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/6000,-6*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/100,-interpreter.instruments.get(i).numberAssigned-256*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/1000);
						rotateX((float)(numbers.get(i)*millis()*0.001f*time));
						rotateY((float)-(numbers.get(i)*millis()*0.001f*time));
						rotateZ((float)-(numbers.get(i)*millis()*0.001f*time));
					}

					 if ((millis() > interpreter.instruments.get(i).trigger) && (note.get(i).intValue() <=interpreter.instruments.get(i).sequence.size())) {
						 
	
					    // Create the new trigger according to predefined duration
						float noteFreq= interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 );
						interpreter.instruments.get(i).trigger = (float) millis() + (1000.0f*time);

					    //System.out.println(interpreter.instruments.get(i).sequence.get(note.get(i).intValue() ));
						//((Vector<Pulse>)Oscs.get(i)).get(0).stop();
						((Vector<Pulse>)Oscs.get(i)).get(0).set(noteFreq,(float)1.0f/(float)(numbers.size()*2),0,0);
						((Vector<Pulse>)Oscs.get(i)).get(1).set(noteFreq/(numbers.get(i)),(float)1.0f/(float)(numbers.size()*6),0,0);
					    ((Vector<Pulse>)Oscs.get(i)).get(2).set(noteFreq/(1.0f+abs(pow(numbers.get(i),2.0f))),(float)1.0f/(float)(numbers.size()*8),0,0);
					    ((Vector<Pulse>)Oscs.get(i)).get(3).set(noteFreq/(1.0f+abs(pow(numbers.get(i),2.0f))),(float)1.0f/(float)(numbers.size()*11),0,0);
					    ((Vector<Pulse>)Oscs.get(i)).get(4).set(noteFreq/(1.0f+abs(pow(numbers.get(i),4.0f))),(float)1.0f/(float)(numbers.size()*11.5),0,0);
					    ((Vector<Pulse>)Oscs.get(i)).get(5).set(noteFreq/(1.0f+abs(pow(numbers.get(i),5.0f))),(float)1.0f/(float)(numbers.size()*11.75f),0,0);
					    //((Vector<Pulse>)Oscs.get(i)).get(6).set(noteFreq/(1.0f+abs(pow(numbers.get(i),6.0f))),(float)1.0f/(float)(numbers.size()*11.75),0,0);
					    //((Vector<Pulse>)Oscs.get(i)).get(7).set(noteFreq/(1.0f+abs(pow(numbers.get(i),7.0f))),(float)1.0f/(float)(numbers.size()*11.8725),0,0);
					   
					   
					    
					    // Advance by one note in the midiSequence;
					    note.set(i,(int)note.get(i).intValue()+1); 
			    		 /*if (note.get(i).intValue() ==(interpreter.instruments.get(i).sequence.size())) {
			 				note.set(i,0);
			    			 interpreter.instruments.get(i).playMusic(numbers);
			    			 interpreter.objects.get(i).mode = rand.nextInt(8);
			    			 duration = (int) (10000.0f+ 10000.0f* rand.nextFloat());
			    		 }*/
					    if (note.get(i).intValue() >(interpreter.instruments.get(i).sequence.size())) {
					    	for(int b = 0; b<numbers.size();b++) {
						    	note.set(b,1);
						    	interpreter.instruments.get(b).interval = interpreter.instruments.get(b).interval-1;
						    	if(interpreter.instruments.get(b).interval <=0) {
						    		interpreter.instruments.get(b).playMusic(numbers);
						    	}
				    			interpreter.objects.get(b).mode = rand.nextInt(8);
				    			interpreter.objects.get(b).assignOffset();
					    	}
		    		 }
					    
			    }
			interpreter.objects.get(i).shape = createShape();
			interpreter.objects.get(i).draw(numbers);
			interpreter.objects.get(i).shape.endShape(CLOSE);
			shape(interpreter.objects.get(i).shape);
			
			popMatrix();
			}
				
		}
			
	}
}


		
		