public class Main {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1", true);
        Thread t2 = new MyThread("t2", false);
        t1.start();
        t2.start();
    }
}

class MyThread extends Thread {
    private static volatile int count = 0;  // 共享变量

    // 控制交替
    private static final Object obj = new Object();  // 锁
    private static boolean global = true;  
    private boolean local;

    public MyThread(String name, boolean local) {
        this.setName(name);
        this.local = local;
    }

    @Override
    public void run() {
        while (count < 1000) {
            print();
        }
    }

    private void print() {
        synchronized (obj) {
            while (global != local) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    //
                }
            }

            // 这里还要加一次判断，因为线程可能过通过了while的条件判断但处于挂起状态
            if (count < 1000) {
                count++;
                System.out.println(this.getName() + ": " + count);
            }

            global = !global;
            obj.notifyAll();
        }
    }
}