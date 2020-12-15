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
	}
	float time =1.0f;
	Interpreter interpreter = new Interpreter();
	public void init() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		print("Enter how many numbers you wish to include: ");
		int n = reader.nextInt(); // Scans the next token of the input as an int.
		//once finished
		print("Enter time in seconds for a step(your numbers can now be decimals): ");
		time = reader.nextFloat();
		
		for(int i=0; i<n; i++) {
			print("Enter a number for up to "+(i+1)+"/"+n+": ");
			Float x  = reader.nextFloat(); // Scans the next token of the input as an int.
			//once finished
			numbers.add(x);
		}
		for(int i=0; i<n; i++) {
			print(numbers.get(i));
		}
		
		interpreter.interpret(numbers);
		for(int i = 0; i<numbers.size();i++) {
			//Interpreter.objects.get(i).draw(numbers);
			interpreter.instruments.get(i).playMusic(numbers);
		    //SinOscs[i].amp((float)1/(float)numbers.size());
		    //SinOscs[i].freq((float) Interpreter.instruments.get(i).sequence[0]);
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
	public Vector<SinOsc> SinOscs = new Vector<SinOsc>(numbers.size());
	
	boolean done=false;
	Random rand= new Random();
	int trigger = 0;
	public void draw(){
		float duration = (int) (1000*time);
		
		/*
		

		// This variable stores the point in time when the next note should be triggered
		int trigger = millis(); 
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		print("Enter how many seconds this clip should be: ");
		int n = reader.nextInt(); // Scans the next token of the input as an int.*/
		
		while(!done) {
			//frame.setLocation(1024, 512);
			ambientLight(140,140,140);
			for(int b = 0; b<numbers.size();b++) {
				//Interpreter.objects.get(i).draw(numbers);
				interpreter.instruments.get(b).playMusic(numbers);
				
				SinOscs.add(new SinOsc(this));
				//SinOscs.get(b).play();
				note.add((int)1);
				//print(note.get(b).intValue());
			}
			done=true;
		}
		
		background(0);
			for(int c = 0; c<numbers.size();c++) {
				Vector<Float>used = new Vector<Float>(0);
				used = new Vector<Float>(numbers.size());
				int i = rand.nextInt(numbers.size());
				if(used.contains((float)i)) {
					for (int j=0;j<numbers.size();j++) {
						i = j;
						if(!used.contains((float)i)) {
							j=numbers.size();
						}
					}
				}
				if(used.contains((float)i)) {
					c=numbers.size();
				}
				//print(interpreter.instruments.get(i).sequence.size());
				/*if (note.get(i).intValue() >(interpreter.instruments.get(i).sequence.size())) {
			    	for(int b = 0; b<numbers.size();b++) {
				    	 note.set(b,1);
		    			 interpreter.instruments.get(b).playMusic(numbers);
		    			 interpreter.objects.get(b).mode = rand.nextInt(8);
		    			 duration = (int) (500.0f+ 500.0f* rand.nextFloat());
			    	}
				}*/
				while(interpreter.instruments.get(i).sequence.size() <128) {
					interpreter.instruments.get(i).playMusic(numbers);
				}
				if(interpreter.instruments.get(i).sequence.size() != 0) {
					int j =rand.nextInt(4);
					pushMatrix();
					interpreter.objects.get(i).shape = createShape();
					translate(512,768);
					if(j==1) {
						translate(rand.nextFloat()*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/100,-note.get(i).intValue()*24*rand.nextFloat());
						rotateX((float)-1.0/(numbers.get(i)));
						rotateY((float)1.0/(numbers.get(i)));
					}
					if(j==2){
						translate(note.get(i).intValue()*24*rand.nextFloat(),-rand.nextFloat()*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1)/100);
						rotateX((float)1.0/(numbers.get(i)));
						rotateY((float)-1.0/(numbers.get(i)));
					}
					if(j==3) {
						translate(rand.nextFloat()*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1)/100,-note.get(i).intValue()*24*rand.nextFloat());
						rotateX((float)-1.0/(numbers.get(i)));
						rotateY((float)1.0/(numbers.get(i)));
					}
					if(j==0){
						translate(note.get(i).intValue()*24*rand.nextFloat(),-rand.nextFloat()*interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 )/100);
						rotateX((float)1.0/(numbers.get(i)));
						rotateY((float)-1.0/(numbers.get(i)));
					}
					interpreter.objects.get(i).draw(numbers);
					interpreter.objects.get(i).shape.endShape(CLOSE);
					 shape(interpreter.objects.get(i).shape);
					 popMatrix();

					 if ((millis() > interpreter.instruments.get(i).trigger) && (note.get(i).intValue() <=interpreter.instruments.get(i).sequence.size())) {
							
							//Interpreter.instruments.get(i).playMusic(numbers);
							
							//print((interpreter.instruments.get(i)).sequence.get(note.get(i).intValue()));
					    // midiToFreq transforms the MIDI value into a frequency in Hz which we use to
					    // control the triangle oscillator with an amplitute of 0.5
						
	
					    // Create the new trigger according to predefined duration
						float noteFreq= interpreter.instruments.get(i).sequence.get(note.get(i).intValue()-1 );
						interpreter.instruments.get(i).trigger = (float) millis() + ((1000.0f*time)/interpreter.instruments.get(i).interval);

					    //print(interpreter.instruments.get(i).sequence.get(note.get(i).intValue() ));
					    SinOscs.get(i).stop();
					    SinOscs.get(i).amp((float)1/numbers.size());
					    SinOscs.get(i).freq(noteFreq);
					    SinOscs.get(i).play(noteFreq,(float)1.0f/(float)numbers.size());
					    
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
				    			interpreter.instruments.get(b).playMusic(numbers);
				    			interpreter.objects.get(b).mode = rand.nextInt(9);
					    	}
		    		 }
			    }
				  
				 
			}
				 
		}
	}
}

		
		