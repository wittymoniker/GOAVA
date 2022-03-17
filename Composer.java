import java.util.Vector;

import javafx.util.converter.NumberStringConverter;

public class Composer {
	public Float getNote(float num, Integer step,Vector<Float> numbers) {
		float sum=0.0f;
		//return frequency index
		for(int i=0;i<numbers.size();i++) {
			sum += 1.0f+Math.cos(3.14159f*((float)(numbers.get(i)*step)))*((float)(((float)(Math.abs((num/(num+numbers.get(i)))))*(float)(Math.abs(1.0f/(num+numbers.size()))))));
		}
		if(sum==0) {
			sum =step/num;
		}
		return (Float)sum;
	}
}
