package com.png.sample;

public class TestThread {

	public static void main(String[] args) {


		startMainThread();
		
		Thread t = new Thread() {
			
			public void run() {
			
				
				try {
					System.out.println("inside run before sleep");
					sleep(5000);
					System.out.println(getName());
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
			
		};
		
		t.start();
		
		try {
			endMainThread();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




private static void startMainThread() {
	
	System.out.println("inside startMainThread");
	System.out.println(Thread.currentThread().getName());	
	
}

private static void endMainThread() throws InterruptedException {
	
	Thread.currentThread().sleep(7000);
	System.out.println("inside endMainThread");
	System.out.println(Thread.currentThread().getName());	
	
}

}
