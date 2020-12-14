import processing.core.PApplet;
import java.util.Scanner;
import java.util.Vector;
import processing.sound.*;
import java.util.Random;
import java.io.Reader; 





public class UI_Main extends PApplet{
	Vector<Double> numbers=new Vector<Double>();
	public static void main(String[] args) {
		PApplet.main("UI_Main");
	}
	Interpreter interpreter = new Interpreter();
	public void init() {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter how many numbers you wish to include: ");
		int n = reader.nextInt(); // Scans the next token of the input as an int.
		//once finished
		
		for(int i=0; i<n; i++) {
			System.out.println("Enter a number for up to "+(i+1)+"/"+n+": ");
			double x  = reader.nextDouble(); // Scans the next token of the input as an int.
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
		    //triOscs[i].amp((float)1/(float)numbers.size());
		    //triOscs[i].freq((float) Interpreter.instruments.get(i).sequence[0]);
		}
		reader.close();
	}
	public void settings(){
		size(2046,1024);
	}
	public void setup() {
		init();
		
		
	}
	int note=0;
	public void draw(){
		Random rand= new Random();
		int duration = (int) (3500 * rand.nextDouble());

		// This variable stores the point in time when the next note should be triggered
		int trigger = millis(); 
		/*
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter how many seconds this clip should be: ");
		int n = reader.nextInt(); // Scans the next token of the input as an int.*/
		boolean done=false;
		
		while(!done) {
			background(0);
			for(int i = 0; i<numbers.size();i++) {
				interpreter.objects.get(i).draw(numbers);
				//Interpreter.instruments.get(i).playMusic(numbers);
				TriOsc[]triOscs= new TriOsc[numbers.size()];
				for(int b = 0; b<numbers.size();b++) {
					//Interpreter.objects.get(i).draw(numbers);
					interpreter.instruments.get(b).playMusic(numbers);
					
					triOscs[b]= new TriOsc(this);
				}
				if(interpreter.instruments.get(i).sequence != null) {
					if ((millis() > trigger) && (note<interpreter.instruments.get(i).sequence.length)) {

					    // midiToFreq transforms the MIDI value into a frequency in Hz which we use to
					    // control the triangle oscillator with an amplitute of 0.5
						

					    // Create the new trigger according to predefined duration
					    trigger = millis() + duration;
					    triOscs[i].amp((float)1/numbers.size());
					    System.out.println(interpreter.instruments.get(i).sequence[note]);
					    triOscs[i].freq((float) interpreter.instruments.get(i).sequence[note]);
					    triOscs[i].play((float) interpreter.instruments.get(i).sequence[note],(float)1/numbers.size());
					    
					    // Advance by one note in the midiSequence;
					    note++; 

					    // Loop the sequence, notice the jitter
					    if (note == interpreter.instruments.get(i).sequence.length) {
					      note = 0;
					    }
					  }
				}
				
			}
		}
		/*System.out.println("Do you like this media presentation? (y/n): ");
		String text = reader.nextLine(); // Scans the next token of the input as an int.
		if(text == "y") {
			done=true;
		}else {
			done=false;
		}		*/
		
		//reader.close();
		
		
	}
	
	
	
}