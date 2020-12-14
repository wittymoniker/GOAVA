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
	Interpreter interpreter = new Interpreter();
	public void init() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		print("Enter how many numbers you wish to include: ");
		int n = reader.nextInt(); // Scans the next token of the input as an int.
		//once finished
		
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
		size(2046,1024);
		
	}
	public void setup() {
		init();
	}
	public Vector<Integer> note = new Vector<Integer>(numbers.size());
	public Vector<SinOsc> SinOscs = new Vector<SinOsc>(numbers.size());
	
	boolean done;
	public void draw(){
		Random rand= new Random();
		int duration = (int) (3000.0f+ 3000.0f* rand.nextFloat());
		/*
		

		// This variable stores the point in time when the next note should be triggered
		int trigger = millis(); 
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		print("Enter how many seconds this clip should be: ");
		int n = reader.nextInt(); // Scans the next token of the input as an int.*/
		
		while(!done) {
			//frame.setLocation(1024, 512);
			
			for(int b = 0; b<numbers.size();b++) {
				//Interpreter.objects.get(i).draw(numbers);
				
				interpreter.instruments.get(b).playMusic(numbers);
				
				SinOscs.add(new SinOsc(this));
				SinOscs.get(b).play();
				for(int i = 0; i<numbers.size();i++) {
					note.add(0);
				}
			}
			done=true;
		}
		
		
		
		background(0);
			for(int i = 0; i<numbers.size();i++) {
				if(interpreter.instruments.get(i).sequence != null) {

					// This variable stores the point in time when the next note should be triggered
					int trigger = millis(); 
					int j =rand.nextInt(4);
					pushMatrix();
					interpreter.objects.get(i).shape = createShape();
					translate(512,768);
					if(j==1) {
						translate(rand.nextFloat()*interpreter.instruments.get(i).sequence.get(note.get(i).intValue() )/100,-note.get(i).intValue()*24*rand.nextFloat());
						rotate((float)-1.0/(numbers.get(i)));
					}
					if(j==2){
						translate(note.get(i).intValue()*24*rand.nextFloat(),-rand.nextFloat()*interpreter.instruments.get(i).sequence.get(note.get(i).intValue())/100);
						rotate((float)-1.0/(numbers.get(i)));
					}
					if(j==3) {
						translate(rand.nextFloat()*interpreter.instruments.get(i).sequence.get(note.get(i).intValue())/100,-note.get(i).intValue()*24*rand.nextFloat());
						rotate((float)-1.0/(numbers.get(i)));
					}
					if(j==0){
						translate(note.get(i).intValue()*24*rand.nextFloat(),-rand.nextFloat()*interpreter.instruments.get(i).sequence.get(note.get(i).intValue() )/100);
						rotate((float)1.0/(numbers.get(i)));
					}
					interpreter.objects.get(i).draw(numbers);
					interpreter.objects.get(i).shape.endShape(CLOSE);
					 shape(interpreter.objects.get(i).shape);
					 popMatrix();
					//Interpreter.instruments.get(i).playMusic(numbers);
					
					//print((interpreter.instruments.get(i)).sequence.get(note.get(i).intValue()));
				 if ((millis() > trigger) && (note.get(i).intValue() <interpreter.instruments.get(i).sequence.size())) {

				    // midiToFreq transforms the MIDI value into a frequency in Hz which we use to
				    // control the triangle oscillator with an amplitute of 0.5
					

				    // Create the new trigger according to predefined duration
					float noteFreq= interpreter.instruments.get(i).sequence.get(note.get(i).intValue() );
				    trigger = millis() + duration;
				    SinOscs.get(i).amp((float)1/numbers.size());
				    print(interpreter.instruments.get(i).sequence.get(note.get(i).intValue() ));
				    SinOscs.get(i).freq(noteFreq);
				    SinOscs.get(i).play(noteFreq,(float)1/numbers.size());
				    
				    // Advance by one note in the midiSequence;
				    note.set(i,note.get(i).intValue()+1); 

				    // Loop the sequence, notice the jitter
		    		 if (note.get(i).intValue() ==(interpreter.instruments.get(i).sequence.size())) {
		    			for(int z = 0; z<numbers.size();z++) {
		 					note.set(z,0);
		 				}
		    			 interpreter.instruments.get(i).playMusic(numbers);
		    		 }
			    }
			}
		}
	}
}

/*if(interpreter.instruments.get(i).mode == 0) {//draw all numbers complex
						  
						 for(int b = 0; b<numbers.size();b++) {
							 interpreter.objects.get(i).shape.vertex(250*numbers.get(b),0-interpreter.instruments.get(b).sequence.get(note.get(b).intValue() )/20);
							 interpreter.objects.get(i).shape.vertex(0+interpreter.instruments.get(b).sequence.get(note.get(b).intValue() )/20,250*numbers.get(b));
							 interpreter.objects.get(i).shape.vertex(250*numbers.get(b),0-interpreter.instruments.get(b).sequence.get(note.get(b).intValue() )/20);
						 }
						 
						  
					}
					if(interpreter.instruments.get(i).mode == 1) {//draw number shape ceil verts
						for(int b = 0; b<(int)Math.ceil((double)interpreter.objects.get(i).numberAssigned);b++) {
							interpreter.objects.get(i).shape.vertex((float)Math.asin(((b+1.0f)/interpreter.objects.get(i).numberAssigned)*300),(float)Math.acos(((b+1.0f)/interpreter.objects.get(i).numberAssigned)*300));
							 
						 }
					}
					if(interpreter.instruments.get(i).mode == 2) {//draw number shape floor verts
						for(int b = 0; b<(int)Math.floor((double)interpreter.objects.get(i).numberAssigned);b++) {
							interpreter.objects.get(i).shape.vertex((float)Math.asin(((b+1.0f)/interpreter.objects.get(i).numberAssigned)*300),(float)Math.acos(((b+1.0f)/interpreter.objects.get(i).numberAssigned)*300));
							 
						 }
					}
					if(interpreter.instruments.get(i).mode == 3) {//draw all numbers randomize
						for(int b = 0; b<numbers.size();b++) {
							
							interpreter.objects.get(i).shape.vertex(rand.nextInt(150)*numbers.get(b),rand.nextInt(150)*numbers.get(b));
							interpreter.objects.get(i).shape.vertex(0,rand.nextInt(150)*numbers.get(b));
							interpreter.objects.get(i).shape.vertex(rand.nextInt(150)*numbers.get(b),0);
						 }
						 
					}
					*/
		
		