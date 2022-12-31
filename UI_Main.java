
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.sound.*;



public class UI_Main extends PApplet {
	Vector<Float> numbers = new Vector<Float>();

	public static void main(String[] args) {
		PApplet.main("UI_Main");
		Thread.currentThread().setPriority((int) (Thread.MAX_PRIORITY * 1));
	}

	float time = 1.0f;
	Interpreter interpreter = new Interpreter();
	String Input[] = null;
	JFrame paneInit;
	public void init() {
		// Scanner reader = new Scanner(System.in); // Reading from System.in
		// System.out.println("Enter how many numbers you wish to include: ");
		// int n = reader.nextInt(); // Scans the next token of the input as an int.
		// once finished
		// System.out.println("Enter time in seconds for a step(your numbers can now be
		// decimals): ");
		// time = reader.nextFloat();
		if (paneInit == null) {
			paneInit = new JFrame();
	    }
		paneInit.setVisible(true);
		paneInit.setLocation(100, 100);
		paneInit.setAlwaysOnTop(true);
		String sn = (String) JOptionPane.showInputDialog(paneInit, "Pick how many numbers you want to use:\n",
				"Customized Dialog", JOptionPane.PLAIN_MESSAGE, null, Input, "6");
		int n = (int) Float.parseFloat(sn);
		String stempo = (String) JOptionPane.showInputDialog(paneInit,
				"Pick the tempo you want to use \n (time in seconds per step):\n", "Customized Dialog",
				JOptionPane.PLAIN_MESSAGE, null, Input, "1.0");
		time = Float.parseFloat(stempo);
		for (int i = 0; i < n; i++) {
			// System.out.println("Enter a number for up to "+(i+1)+"/"+n+": ");
			String num = (String) JOptionPane.showInputDialog(paneInit,
					("Enter a number for up to " + (i + 1) + "/" + n + ":"), "Customized Dialog",
					JOptionPane.PLAIN_MESSAGE, null, Input, "0.0");
			// Float x = reader.nextFloat(); // Scans the next token of the input as an int.
			// once finished
			numbers.add(Float.parseFloat(num));
		}
		paneInit.dispose();
		for (int i = 0; i < n; i++) {
			System.out.println(numbers.get(i));
		}

		interpreter.interpret(numbers);
		for (int i = 0; i < numbers.size(); i++) {
			// Interpreter.objects.get(i).draw(numbers);
			interpreter.instruments.get(i).playMusic(numbers);
			// SinOscs[i].amp((float)1/(float)numbers.size());
			// SinOscs[i].freq((float) Interpreter.instruments.get(i).sequence[0]);
		}
		// reader.close();
	}

	public void settings() {
		size(2046, 1024, P3D);
	}

	public void setup() {
		init();
	}


	
	
	

	public boolean done = false;
	Random rand = new Random();
	int trigger = 0;
	public Reverb reverb;
	public Vector<Integer> note;
	public Vector<Vector<SinOsc>> Oscs;
	public Delay delay;
	public void draw() {
		float duration = (int) (1000 * time);

		/*
		 * 
		 * 
		 * // This variable stores the point in time when the next note should be
		 * triggered int trigger = millis(); Scanner reader = new Scanner(System.in); //
		 * Reading from System.in
		 * System.out.println("Enter how many seconds this clip should be: "); int n =
		 * reader.nextInt(); // Scans the next token of the input as an int.
		 */

		while (!done) {
			// frame.setLocation(1024, 128);
			
			reverb= new Reverb(this);
			note= new Vector<Integer>(numbers.size());
			Oscs= new Vector<Vector<SinOsc>>();
			delay= new Delay(this);
			ambientLight(140, 140, 140);
			
			for (int b = 0; b < numbers.size(); b++) {
				
				
				// Interpreter.objects.get(i).draw(numbers);
				interpreter.instruments.get(b).playMusic(numbers);
				
				Oscs.add(new Vector<SinOsc>(4));
				
				// ((Vector<SinOsc>)Oscs.get(b)).setSize(8);
				Oscs.get(b).add(new SinOsc(this));
				Oscs.get(b).add(new SinOsc(this));
				Oscs.get(b).add(new SinOsc(this));
				Oscs.get(b).add(new SinOsc(this));
				// ((Vector<SinOsc>)Oscs.get(b)).add(new SinOsc(this));
				// ((Vector<SinOsc>)Oscs.get(b)).add(new SinOsc(this));
				// ((Vector<SinOsc>)Oscs.get(b)).add(new SinOsc(this));
				// ((Vector<SinOsc>)Oscs.get(b)).add(new SinOsc(this));
				// ((Vector<SinOsc>)Oscs.get(b)).add(new SinOsc(this));
				note.add((int) 1);
				// System.out.println(note.get(b).intValue());
				/*
				 * ((Vector<SinOsc>)Oscs.get(b)).get(0).width(1.0f/(1.0f+numbers.get(b)));
				 * ((Vector<SinOsc>)Oscs.get(b)).get(1).width(2.0f/(2.0f+numbers.get(b)*2));
				 * ((Vector<SinOsc>)Oscs.get(b)).get(2).width(3.0f/(3.0f+numbers.get(b)*3));
				 * ((Vector<SinOsc>)Oscs.get(b)).get(3).width(4.0f/(4.0f+numbers.get(b)*4));
				 * ((Vector<SinOsc>)Oscs.get(b)).get(4).width(5.0f/(5.0f+numbers.get(b)*5));
				 * ((Vector<SinOsc>)Oscs.get(b)).get(5).width(6.0f/(6.0f+numbers.get(b)*6));
				 */
				// ((Vector<SinOsc>)Oscs.get(b)).get(6).width(7.0f/(7.0f+numbers.get(b)*7));
				// ((Vector<SinOsc>)Oscs.get(b)).get(7).width(8.0f/(8.0f+numbers.get(b)*8));
				delay.process(Oscs.get(b).get(0));
				delay.process(Oscs.get(b).get(1));
				delay.process(Oscs.get(b).get(2));
				delay.process(Oscs.get(b).get(3));
				reverb.process(Oscs.get(b).get(0));
				reverb.process(Oscs.get(b).get(1));
				reverb.process(Oscs.get(b).get(2));
				reverb.process(Oscs.get(b).get(3));
				
				// ((Vector<SinOsc>)Oscs.get(b)).get(3).play(110/(1.0f+abs(pow(numbers.get(b),3.0f))),(float)1.0f/(float)(numbers.size()*10));
				// ((Vector<SinOsc>)Oscs.get(b)).get(4).play(110/(1.0f+abs(pow(numbers.get(b),4.0f))),(float)1.0f/(float)(numbers.size()*13));
				// ((Vector<SinOsc>)Oscs.get(b)).get(5).play(110*(1.0f+abs(pow(numbers.get(b),0.5f))),(float)1.0f/(float)(numbers.size()*10));
				// ((Vector<SinOsc>)Oscs.get(b)).get(6).play(110*(1.0f+abs(pow(numbers.get(b),.333f))),(float)1.0f/(float)(numbers.size()*12));
				// ((Vector<SinOsc>)Oscs.get(b)).get(7).play(110*(1.0f+abs(pow(numbers.get(b),0.25f))),(float)1.0f/(float)(numbers.size()*13));
				// interpreter.objects.get(b).shape = createShape();
			}
			reverb.damp(1.0f/(numbers.size()+1.0f));
			reverb.room(1.0f/(numbers.size()+1.0f));
			reverb.wet(0.16666f/(numbers.size()+1.0f));
			delay.time(time-time*.1975807343f/(numbers.size()+1.0f));
			delay.feedback(0.16666f/(numbers.size()+1.0f));
			done = true;
		}
		
		if(rand.nextFloat()>=(1.0f/((float)numbers.size()))) {
		background(0);
		}
		pushMatrix();
		for (int c = 0; c < numbers.size(); c++) {
			
			Vector<Float> used = new Vector<Float>(0);
			used = new Vector<Float>(numbers.size());
			int i = rand.nextInt(numbers.size());
			if (used.contains((float) i)) {
				for (int j = numbers.size() - 1; j > -1; j--) {
					i = j;
					if (!used.contains((float) i)) {
						j = numbers.size();
					}
				}
			}
			if (used.contains((float) i)) {
				c = numbers.size();
			}
			used.add((float) i);

			if (interpreter.instruments.get(i).sequence.size() != 0) {
				int j = rand.nextInt(8);

				//translate(128, 768);
				if ((millis() > interpreter.instruments.get(i).trigger) && j == 1) {
					translate(- interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 128,
							 + note.get(i).intValue() 
									* interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64,
							-interpreter.instruments.get(i).numberAssigned - 
									 interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64);
					rotateX((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateY((float) (Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateZ((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
				}
				if ((millis() > interpreter.instruments.get(i).trigger) && j == 2) {
					translate(
							- note.get(i).intValue() 
									* interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64,
							+  interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 128,
							-interpreter.instruments.get(i).numberAssigned -
									 interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 128);
					rotateX((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateY((float) (Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateZ((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
				}
				if ((millis() > interpreter.instruments.get(i).trigger) && j == 3) {
					translate( - interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 128,
							 + note.get(i).intValue() 
									* interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64,
							-interpreter.instruments.get(i).numberAssigned - 
									 interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64);
					rotateX((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateY((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateZ((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
				}
				if ((millis() > interpreter.instruments.get(i).trigger) && j == 0) {
					translate(
							 - note.get(i).intValue() 
									* interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 6000,
							 + interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 128,
							-interpreter.instruments.get(i).numberAssigned+
									 interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 128);
					rotateX((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateY((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateZ((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
				}
				if ((millis() > interpreter.instruments.get(i).trigger) && j == 4) {
					translate( interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 128,
							-note.get(i).intValue() 
									* interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64,
							-interpreter.instruments.get(i).numberAssigned -
								 interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64);
					rotateX((float) (Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateY((float) (Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateZ((float) (Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
				}
				if ((millis() > interpreter.instruments.get(i).trigger) && j == 5) {
					translate(
							note.get(i).intValue() 
									* interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64,
							interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 128,
							-interpreter.instruments.get(i).numberAssigned-
									interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64);
					rotateX((float) (Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateY((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateZ((float) (Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
				}
				if ((millis() > interpreter.instruments.get(i).trigger) && j == 6) {
					translate( interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 128,
							-note.get(i).intValue() 
									* interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64,
							-interpreter.instruments.get(i).numberAssigned -
									 interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64);
					rotateX((float) (Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateY((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateZ((float) (Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
				}
				if ((millis() > interpreter.instruments.get(i).trigger) && j == 7) {
					translate(
							note.get(i).intValue() 
									* interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64,
							- interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 128,
							-interpreter.instruments.get(i).numberAssigned -
									 interpreter.instruments.get(i).sequence.get(note.get(i).intValue() - 1) / 64);
					rotateX((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateY((float) (Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
					rotateZ((float) -(Math.pow(numbers.get(i),1.0f/numbers.get(i))*millis() * 0.1f * time));
				}
				
				if ((millis() > interpreter.instruments.get(i).trigger)
						&& (note.get(i).intValue() <= interpreter.instruments.get(i).sequence.size())) {

					// Create the new trigger according to predefined duration
					if(note.get(i).intValue() >= interpreter.instruments.get(i).sequence.size()) {
						note.set(i,1);
						
					}
					float noteFreq =(Math.abs((float)interpreter.instruments.get(i).sequence.get(note.get(i).intValue())));
					
					if (Math.abs(noteFreq)>=(134280798.0f/4096.0f) ||Math.abs(noteFreq)<=6.0f){
						noteFreq=Math.abs((float)Math.pow(134280798.0f,Math.abs(16.0f/(16.0f*Math.abs(numbers.get(i))+16.0f))));
					}
					System.out.println(noteFreq);
					interpreter.instruments.get(i).trigger = (float) millis() + (1000.0f * time);
					// System.out.println(interpreter.instruments.get(i).sequence.get(note.get(i).intValue()
					// ));
					// ((Vector<SinOsc>)Oscs.get(i)).get(0).stop();
					/*Oscs.get(i).get(0).stop();
					Oscs.get(i).get(1).stop();
					Oscs.get(i).get(2).stop();
					Oscs.get(i).get(3).stop();*/
					
					Oscs.get(i).get(0).set((float)((noteFreq)), ((float) 0.16666f / (float) (numbers.size()*15.0f)),0,0);
					Oscs.get(i).get(1).set((float)((noteFreq/numbers.get(i))), ((float) 0.16666f / (float) (numbers.size()*20.0f)),0,0);
					Oscs.get(i).get(2).set((float)((noteFreq)/numbers.get(i))/numbers.get(i),((float) 0.16666f / (float) (numbers.size()*25.0f)),0,0);
					Oscs.get(i).get(3).set((float)(((noteFreq)/numbers.get(i))/numbers.get(i))/numbers.get(i),((float) 0.16666f / (float) (numbers.size()*30.0f)),0,0);
					// ((Vector<SinOsc>)Oscs.get(i)).get(3).set(noteFreq/(abs(pow(numbers.get(i),2.0f))),(float)1.0f/(float)(numbers.size()*11),0,0);
					// ((Vector<SinOsc>)Oscs.get(i)).get(4).set(noteFreq/(abs(pow(numbers.get(i),4.0f))),(float)1.0f/(float)(numbers.size()*11.5),0,0);
					// ((Vector<SinOsc>)Oscs.get(i)).get(5).set(noteFreq/(1.0f+abs(pow(numbers.get(i),5.0f))),(float)1.0f/(float)(numbers.size()*11.75f),0,0);
					// ((Vector<SinOsc>)Oscs.get(i)).get(6).set(noteFreq/(1.0f+abs(pow(numbers.get(i),6.0f))),(float)1.0f/(float)(numbers.size()*11.75),0,0);
					// ((Vector<SinOsc>)Oscs.get(i)).get(7).set(noteFreq/(1.0f+abs(pow(numbers.get(i),7.0f))),(float)1.0f/(float)(numbers.size()*11.8725),0,0);
					/*Oscs.get(i).get(0).play();
					Oscs.get(i).get(1).play();
					Oscs.get(i).get(2).play();
					Oscs.get(i).get(3).play();*/
					
					
					
					// Advance by one note in the midiSequence;
					
					/*
					 * if (note.get(i).intValue()
					 * ==(interpreter.instruments.get(i).sequence.size())) { note.set(i,0);
					 * interpreter.instruments.get(i).playMusic(numbers);
					 * interpreter.objects.get(i).mode = rand.nextInt(8); duration = (int)
					 * (10000.0f+ 10000.0f* rand.nextFloat()); }
					 */
					note.set(i, note.get(i)+1);
					if (note.get(i).intValue() > (interpreter.instruments.get(i).sequence.size())) {
						for (int b = 0; b < numbers.size(); b++) {
							note.set(b, 1);
							interpreter.objects.get(b).mode = rand.nextInt(12);
							interpreter.objects.get(b).mode2 = Math.round(rand.nextFloat() * 33);
							interpreter.objects.get(b).assignOffset();
							interpreter.instruments.get(b).interval = interpreter.instruments.get(b).interval - 1;
							if (interpreter.instruments.get(b).interval <= 0) {
								interpreter.instruments.get(b).playMusic(numbers);
							}
							interpreter.objects.get(b).mode = rand.nextInt(12);
							interpreter.objects.get(b).mode2 = Math.round(rand.nextFloat() * 33);
							interpreter.objects.get(b).assignOffset();
						}
					}

				}
				interpreter.objects.get(i).shape = createShape();
				interpreter.objects.get(i).draw(numbers);
				interpreter.objects.get(i).shape.endShape(CLOSE);
				shape(interpreter.objects.get(i).shape);

				
			}

		}
		
			popMatrix();
	}
}
