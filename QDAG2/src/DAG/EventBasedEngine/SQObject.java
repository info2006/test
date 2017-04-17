package DAG.EventBasedEngine;

public class SQObject extends thrdObject {
	ObjctsHandler handler;
	private int id;
	Boolean fistExecution=true;
	Boolean isLast=false;
	/* 0=null 1=processable */
	short statInBuffer=0;
	/* 0=full 1=writable 2=groupper 3=sorter */
	short statOutBuffer=0;
	/* 0=full 1=empty 2=no more datastars 3=isProcessable */
	short statTSBuffer=0;
	/* True or false */
	boolean isPreviousFinished=false;
	

	public SQObject(int id,ObjctsHandler hndlr,Boolean last) {
		handler=hndlr;
		this.id=id;
		this.isLast=last;
	}
	public SQObject(int id,ObjctsHandler hndlr) {
		handler=hndlr;
		this.id=id;
	}
	@Override
	public void run() throws InterruptedException {
		Thread.sleep(1000);
		if(fistExecution&&(id==0))
		{
			fistExecution=false;
			System.out.println("SQ: In Bfr is Null(first SQ) - ");
			System.out.println("SQ: Comunicating needs to TS");
			ObjctsHandler.addEvent(id, 3);
		}
		else if(id==0) 
		{
			generateStats();
			if(statTSBuffer==0||statTSBuffer==3)
				System.out.println("SQ: Consuming TS buffer");
			// TS buffer is empty
			// IN buffer is empty
			// Out Buffer is out
			generateStats();
			
			double proba=Math.random();
			if(statTSBuffer==)
			System.out.println("SQ: Proba "+proba);
			if(proba>0&&proba<0.33)
			{
				System.out.println("SQ: TS Buffer is Empty");
				ObjctsHandler.addEvent(id, 12);
				
			}
			else if(proba>0.33&&proba<0.66)
			{
				System.out.println("SQ: No more data stars");
				ObjctsHandler.addEvent(id, 5);
			}
			else
			{
				System.out.println("SQ: OutBuffer is full");
				ObjctsHandler.addEvent(id, 6);
			}
		}
		else 
		{
			// TS buffer Empty 
			// In Buffer is Empty
			// no more data stars
			// OutBuffer full
			
		}

	}
	private void generateStats() {
		/*
		outbuffer is full|-> In Buffer is processable     |-> TS buffer is processable
														  |-> TS buffer is not processable
						 |-> In Buffer is not processable |-> TS buffer is processable
						 								  |-> TS buffer is not processable			 								  
		In buffer is empty  |-> TS no more data stars |-> outbuffer is processable
							|-> TS no more data stars |-> outbuffer is not processable
		
		TS buffer is empty |-> In Buffer is processable|-> Out Buffer is processable
													   |-> Out Buffer is not processable
						   |-> In Buffer is not processable |-> Out Buffer is processable
						   									|-> Out Buffer is not processable
		*/
	}

}
