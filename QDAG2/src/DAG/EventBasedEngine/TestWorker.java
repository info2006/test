package DAG.EventBasedEngine;

import structs.Pair;

public class TestWorker {
 
	public static void main(String[] args) throws InterruptedException {
		ObjctsHandler hundler= new ObjctsHandler();
		hundler.start();
		hundler.addEvent(-1, 0);
		Thread.sleep(100);
		hundler.addEvent(-1, 1);
		Thread.sleep(100);
		hundler.addEvent(-1, 2);
		Thread.sleep(100);
		/*
		 * 
		SQObject SQ1=new SQObject("SQ1");
		SQObject SQ2=new SQObject("SQ2");
		
		taskThread thrd=new taskThread(SQ1);
		thrd.start();
		System.out.println("test1");
		thrd.setAuthorized(true);
		Thread.sleep(1000);
		System.out.println("test2");
		thrd.object=SQ2;
		Thread.sleep(1000);
		thrd.shudown();
		*/

	}
	/*
	 *  0) Start worker 1) Receive a query q and a plan p
		2) Start super step i 3) In Bfr is Null(first SQ)
		4) TS buffer is full 5) No more data stars
		6) Out Bfr is full  7) No more hyper edges (partial results) (In Bfr is empty)
		8) bfr is not processable  
		9) Write bfr is full 10) NetBfr is full 
		11) Start Data syncro
	 */
	
}
