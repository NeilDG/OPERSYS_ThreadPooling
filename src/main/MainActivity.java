/**
 * 
 */
package main;

import custom_actions.AddThreadAction;
import thread_pool.ThreadPoolManager;

/**
 * Main activity of the thread pooling demo.
 * @author NeilDG
 *
 */
public class MainActivity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		//initialize thread pool
		ThreadPoolManager.initialize(5);
		ThreadPoolManager.getInstance().startPoolExecutor();
		
		createActions();
		
		try {
			Thread.sleep(15000);
			//re-execute again
			createActions();
			
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	private static void createActions() {
		for(int i = 0; i < 30; i++) {
			AddThreadAction threadAction = new AddThreadAction(1, 1);
			ThreadPoolManager.getInstance().addThreadAction(threadAction);
		}
	}

}
