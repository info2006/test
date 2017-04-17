package DAG.EventBasedEngine;

public class TSObject extends thrdObject {
	ObjctsHandler handler;
	private int id;
	/* 0=full 1=empty 2=no more datastars and procesable 3=no more datastars and not procesable */
	short statTSBuffer=0;
	
	public TSObject(int id,ObjctsHandler hndlr) {
		handler=hndlr;
		this.id=id;
	}
	@Override
	public void run() throws InterruptedException {
		Thread.sleep(1000);
		generate_stat();
		
		
		
	}
	void generate_stat()
	{
		/*
		TS no more data stars |-> TS buffer is processable
							  |-> TS buffer is not processable
							  
		TS buffer is full     |-> TS no more data stars
							  |-> TS no more data stars
		
		*/
		short statTSBuffer=0;

		
		double proba=Math.random();
		if(proba<0.33)
		{
			System.out.println("TS: TS Buffer is Full");
			statTSBuffer=0;
			ObjctsHandler.addEvent(id, 12);
			
		}
		/*else if(proba>0.25&&proba<0.50) 
		{
			System.out.println("TS: TS Buffer is empty");
			statTSBuffer=1;
			ObjctsHandler.addEvent(id, 5);
		}*/
		else if(proba>0.33&&proba<0.66) 
		{
			System.out.println("TS: no more datastars and processable");
			statTSBuffer=2;
			ObjctsHandler.addEvent(id, 5);
		}
		else if(proba>0.66) 
		{
			System.out.println("TS: no more datastars and not processable");
			statTSBuffer=3;
			ObjctsHandler.addEvent(id, 5);
		}
	}

}
