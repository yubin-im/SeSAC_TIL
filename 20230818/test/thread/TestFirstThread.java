package test.thread;
// 20230818 실습
// 스레드
public class TestFirstThread {
    public static void main(String[] args) throws InterruptedException {
        class Target implements Runnable {
            @Override
            public void run() {
                System.out.println("Sub Thread::" + Thread.currentThread());
            }
        }

        Runnable target = new Target();
        Thread cpu = new Thread(target);
        cpu.start();

        Thread.yield();
        // Thread.sleep(50);
        cpu.join();

        System.out.println("Main Thread::" + Thread.currentThread());


//        new Thread() {
//            public void run(){
//                System.out.println("Sub Thread::" + Thread.currentThread());
//            }
//        }.start();
//        System.out.println("Main Thread::" + Thread.currentThread());

    }
}
