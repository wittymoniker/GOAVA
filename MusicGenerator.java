
import java.util.Random;
import java.util.Vector;

public class MusicGenerator {
	int mode = 0;
	float interval;
	public float numberAssigned;
	public float trigger = 0;
	public Vector<Float> sequence = new Vector<Float>(0);

	public void playMusic(Vector<Float> numbers) {
		Random rand = new Random();
		Composer comp = new Composer();
		interval = rand.nextInt(numbers.size())+1;
		/*if (rand.nextInt(2) == 1) {
			interval = 1.0f - ((1.0f / (((Math.abs(((((((numberAssigned))))))))) + 1.0f)));
		}*/
		if (mode == 0) {// play arpeg numbers multiplying each other
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				sequence.add(i, (comp.getNote(numberAssigned,i,numbers) * (110.0f)));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}

		}

		if (mode == 1) {// play note exp low frequency number
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c =((110.0f) / numberAssigned);
				sequence.add(i,  (float) Math.pow(numberAssigned,comp.getNote(numberAssigned,i,numbers)));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 2) {// play note multiplicative scale number
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c = numbers.get(((int) ((rand.nextInt(numbers.size())))))
						* ((float) 440.0f * comp.getNote(numberAssigned,i,numbers));
				sequence.add(i, (float) c);
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 3) {// play note randoms number
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c = comp.getNote(numberAssigned,i,numbers) * (110.0f);
				sequence.add(i, (float) c);
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 4) {// play note exp low frequency number(more likely)
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c = comp.getNote(numberAssigned,i,numbers) * ((110.0f) / numberAssigned);
				sequence.add(i, (float) Math.pow(c, numberAssigned));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 5) {// play arpeg numbers
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				sequence.add(i, comp.getNote(numberAssigned,i,numbers) * (110.0f));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}

		}
		if (mode == 6) {// play note exp low frequency number
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c = (numbers.get((int) ((rand.nextInt(numbers.size())))))
						*comp.getNote(numberAssigned,i,numbers) * (6.125f * numberAssigned);
				sequence.add(i, (float) Math.pow(c, comp.getNote(numberAssigned,i,numbers)));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 7) {// play note exp low frequency number multiplied 3 nums
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c = (numbers.get((int) ((rand.nextInt(numbers.size()))))
						* numbers.get((int) ((rand.nextInt(numbers.size()))))
						* comp.getNote(numberAssigned,i,numbers))
						* (27.5000f / numberAssigned);
				sequence.add(i, (float) Math.pow(c, numberAssigned));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 8) {// play arpeg numbers multiplying each other 3 nums
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				sequence.add(i, numbers.get((int) ((rand.nextInt(numbers.size()))))
						+ (numbers.get((int) ((rand.nextInt(numbers.size()))))
								* numbers.get((int) ((rand.nextInt(numbers.size()))))
								* comp.getNote(numberAssigned,i,numbers)) * (110.0f));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}

		}
		if (mode == 9) {// play arpeg numbers multiplying each other
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				sequence.add(i, comp.getNote(numberAssigned,i,numbers)
						*  (110.0f));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}

		}

		if (mode == 10) {// play note exp low frequency number
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c = comp.getNote(numberAssigned,i,numbers)
						* (330.0f / numberAssigned);
				sequence.add(i, (float) Math.pow(c, numberAssigned));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 11) {// play note multiplicative scale number
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c =comp.getNote(numberAssigned,i,numbers)
						* ((float) 660.0f / numberAssigned);
				sequence.add(i, (float) c);
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 12) {// play note randoms number
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c =comp.getNote(numberAssigned,i,numbers) * (880.0f);
				sequence.add(i, (float) c);
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 13) {// play note exp low frequency number(more likely)
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c = comp.getNote(numberAssigned,i,numbers)
						* (6.1250f / numberAssigned);
				sequence.add(i, (float) Math.pow(c, numbers.get(rand.nextInt(numbers.size()))));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 14) {// play arpeg numbers
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				sequence.add(i, comp.getNote(numberAssigned,i,numbers) * (110.0f));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}

		}
		if (mode == 15) {// play note exp low frequency number
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c = comp.getNote(numberAssigned,i,numbers) * ((6.125f/(8.0f*(float)numbers.size())));
				sequence.add(i, (float) Math.pow(numberAssigned, comp.getNote(numberAssigned,i,numbers)));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 16) {// play note exp low frequency number multiplied 3 nums
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c = (numbers.get((int) ((rand.nextInt(numbers.size()))))
						* comp.getNote(numberAssigned,i,numbers)) * ((6.125f/(8.0f*(float)numbers.size())));
				sequence.add(i, (float) Math.pow(comp.getNote(numberAssigned,i,numbers), c));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}
		}
		if (mode == 17) {// play arpeg numbers multiplying each other 3 nums
			float f = (float) numbers.size() * interval;
			sequence = new Vector<Float>((int) f);
			for (int i = 0; i < f; i++) {
				float c = (numbers.get((int) ((rand.nextInt(numbers.size()))))*numbers.get((int) ((rand.nextInt(numbers.size()))))
						* comp.getNote(numberAssigned,i,numbers)) * ((6.125f/(8.0f*(float)numbers.size())));
				sequence.add(i, (float) Math.pow(comp.getNote(numberAssigned,i,numbers), c));
				if (sequence.get(i) == null) {
					System.out.println("\n" + sequence.get(i));
				}
			}

		}
		// System.out.println(sequence.size()+","+mode+"\n");
		mode = rand.nextInt(18);
	}
}