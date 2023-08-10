package d230810;

import java.util.Deque;

public class OrderOutRun implements Runnable{
	private Deque<Order> orderQ;

	public OrderOutRun(Deque<Order> orderQ) {
		this.orderQ = orderQ;
	}
	
	@Override
	public void run() {
		while (true) {
			if(orderQ.peekFirst() != null) {
				Order order=orderQ.pollFirst();
				order.outOrder();
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}				
	}
}