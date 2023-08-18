package test.thread;
// 20230818 실습
// 스레드
public class TestSyncThread {
    public static void main(String[] args) throws InterruptedException {
        Counter monitor = new Counter();
        Runnable target = new Target(monitor);
        Thread cpu1 = new Thread(target);
        Thread cpu2 = new Thread(target);
        Thread cpu3 = new Thread(target);

        cpu1.start();
        cpu2.start();
        cpu3.start();

        cpu1.join();
        cpu2.join();
        cpu3.join();

        System.out.println(monitor);

    }
}

class Counter{
    private int count;

    public synchronized void inc(){
        count++;
    }

    @Override
    public String toString() {
        return "monitor= " + count;
    }
}

class Target implements Runnable{
    private Counter monitor;

    Target(Counter monitor){
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100000000; i++) {
            monitor.inc();
        }
        System.out.println(Thread.currentThread() + ":: " + monitor);
    }


}