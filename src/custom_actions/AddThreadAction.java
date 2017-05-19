/**
 * 
 */
package custom_actions;

import java.util.Random;

import thread_pool.ThreadAction;
import utils.Debug;

/**
 * Simple thread action that performs addition of two numbers multiple times.
 * @author NeilDG
 *
 */
public class AddThreadAction implements ThreadAction {
	private final static String TAG = "AddThreadAction";
	private final static int NUM_TIMES = 1000000;
	
	private long num1;
	private long num2;
	
	public AddThreadAction(long x, long y) {
		this.num1 = x;
		this.num2 = y;
	}
	
	public void execute() {
		int sum = 0;
		for(int i = 0; i < NUM_TIMES; i++) {
			sum += (this.num1 + this.num2);
		}
		
		//for debugging purposes
		try {
			Random random = new Random();
			int randomSleep = 10 + random.nextInt(3000);
			Thread.sleep(randomSleep);
			
			Debug.log(TAG, "Finished thread action after " +randomSleep+ " seconds.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
