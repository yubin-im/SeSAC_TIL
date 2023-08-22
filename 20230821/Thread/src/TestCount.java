public class TestCount {

	
	public static void main(String[] args) throws InterruptedException {
        Count monitor = new Count();
        Runnable target = new Target(monitor);
        Thread cpu1 = new Thread(target);
        Thread cpu2 = new Thread(target);
        cpu1.start();   cpu2.start();
        cpu1.join();    cpu2.join();
        System.out.println(monitor.i);
	}

}

class Target implements Runnable 
{   Count monitor;
	public Target(Count monitor) {
		this.monitor = monitor;
	}
	public void run() {
	  for(int i = 0; i < 10000000; i ++)
	     monitor.inc();
	  
	  
	}
}
class Count
{ int i;
  synchronized void inc()
	  { i++; } 
  }





