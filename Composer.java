import java.util.Vector;

import javafx.util.converter.NumberStringConverter;

public class Composer {
	public Float getNote(float num, Integer step,Vector<Float> numbers) {
		float sum=0.0f;
		//return frequency index
		for(int i=0;i<numbers.size();i++) {
			if (numbers.get(i)!=num) {
				sum += 1.0f+Math.cos(0.5f*3.14159f*((float)(numbers.get(i)*step)))*((float)(((float)(Math.abs((num/(num+numbers.get(i)))))*(float)(1/numbers.size()))));
			}
		}
		if(sum==0) {
			sum =step/num;
		}
		return (Float)sum;
	}
}
