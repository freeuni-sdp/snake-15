import java.util.Random;

public class MyRandom extends Random {

	@Override
	public int nextInt(int num){
		return new Random().nextInt(num);
	}
}
