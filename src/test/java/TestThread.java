import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class TestThread {
	public int commodity = 100;
	
	public void runMyThread(){
//		ExecutorService e = Executors.newCachedThreadPool();
		ExecutorService e = Executors.newFixedThreadPool(10);
		MyThread mt = new MyThread(0, this);
		for (int i=0;i<10;i++) {
			e.execute(mt);//new MyThread(i, this));
		}
		e.shutdown();
	}
	
	public void minus(){
		System.out.println(--this.commodity);
	}

	public static void main(String[] args) {
		TestThread tt = new TestThread();
		tt.runMyThread();
	}

}

class MyThread implements Runnable{
	private int i;
	TestThread tt;
	private static MonitorObject m = new MonitorObject();
	private boolean wasSignalled = false;
	ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	ReentrantLock reentrantLock = new ReentrantLock(true);
	
	public MyThread(int i,TestThread tt){
		this.i = i;
		this.tt = tt;
	}
	
	public void doWait(){
		synchronized (m) {
//			while(!wasSignalled){
				try {
					m.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//			}
//			wasSignalled = false;
		}
	}
	
	public void doNotify(){
		synchronized (m) {
			m.notify();
//			wasSignalled = true;
		}
	}
	
	@Override
	public void run() {
		
		while(true){
//			synchronized (this.m) {
//			lock.writeLock().lock();
			reentrantLock.lock();
			try{
				if(this.tt.commodity > 0){
//					doNotify();
					this.tt.commodity--;
//					System.out.println("线程"+this.i+"消耗，剩余"+this.tt.commodity);
					System.out.println(Thread.currentThread().getName()+"消耗，剩余"+this.tt.commodity);
//					doWait();
				}else{
					break;
				}
			}finally{
//				lock.writeLock().unlock();
				reentrantLock.unlock();
			}
//			}
		}
	}
}

class MonitorObject{}
