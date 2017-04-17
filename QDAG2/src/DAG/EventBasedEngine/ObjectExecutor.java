package DAG.EventBasedEngine;




public class ObjectExecutor extends Thread implements DagThread  {
	boolean shutdown=false;
	thrdObject object;
	boolean authorized=false;

	public ObjectExecutor(thrdObject thrd)
	{
		object=thrd;
	}
	public ObjectExecutor() {
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
				try {
					object.run();
					authorized=false;
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
