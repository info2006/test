package DAG.EventBasedEngine;

import java.io.IOException;



public class taskThread extends Thread implements DagThread  {
	boolean shutdown=false;
	thrdObject object;
	boolean authorized=false;

	public taskThread(thrdObject thrd)
	{
		object=thrd;
	}
	@Override
	public void shudown() {
		shutdown=true;
		
	}
public void run() {
		
		while(!shutdown)
		{
			if(authorized)
			{
				System.out.println("test");
				try {
					object.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
			}
			}
		
	}
public void setAuthorized(Boolean auth)
{
	authorized=auth;
}
}
