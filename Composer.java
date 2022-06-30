import java.util.Vector;

public class Composer {
	public Float getNote(float num, Integer step,Vector<Float> numbers) {
		float sum=0.0f;
		//return frequency index
		for(int i=0;i<numbers.size();i++) {
			sum += (float)(1.0f+Math.sin(1.0f+3.14159f*((float)(numbers.get(i)*step))))/(2.0f*(float)numbers.size());
		}
		if(sum==0) {
			sum =1;
		}
		return (float)sum;
	}
}
