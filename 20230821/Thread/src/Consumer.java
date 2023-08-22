public class Consumer implements Runnable {
    private SyncStack theStack;
    private int num;
    private static int counter = 1;
    
    public Consumer (SyncStack s) {
	theStack = s;
	num = counter++;
    }

    public void run() {
	char c;
	for (int i = 0; i < 200; i++) {
		try {
			c = theStack.pop();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	    System.out.println("Consumer"+num+": " +c);
	    try {
		Thread.sleep((int)(Math.random() * 300));
	    } catch (InterruptedException e) {
	    }
	} // for
    } // run
}
