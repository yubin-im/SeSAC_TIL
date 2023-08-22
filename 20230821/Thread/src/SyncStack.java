import java.util.Vector;

public class SyncStack {

    private Vector buffer = new Vector(400, 200);

    public synchronized char pop(){
    	while (buffer.size() <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
    	
    	char c;
		synchronized(this){
    		c = (char) buffer.remove(buffer.size()-1);
    	}
    	return c;
    }

    public void push(char c) {
    	buffer.addElement(c);
    	this.notify();
	}
}
