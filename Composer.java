import java.util.Vector;

public class Composer {
	public Float getNote(float num, Integer step,Vector<Float> numbers) {
		float sum=0.0f;
		//return frequency index
		for(int i=0;i<numbers.size();i++) {
			if(numbers.get(i)!=0) {
				sum += (float)(1.0f+Math.cos(1.0f+(3.14159f/2.0f)*((float)(numbers.get(i)*step))))/(numbers.size());

			}else {
			sum += (float)(1.0f+Math.cos(1.0f+step+(3.14159f/2.0f)*((float)(numbers.get(i)*step))))/(numbers.size());
			}
		}
		sum = Math.abs(sum);
		
		return (float)sum;
	}
}
