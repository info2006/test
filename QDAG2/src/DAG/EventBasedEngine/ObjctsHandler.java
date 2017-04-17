package DAG.EventBasedEngine;

import java.util.ArrayList;

import structs.Pair;

public class ObjctsHandler extends Thread implements DagThread {
	boolean shutdown=false;
	int previousCMD=-1;
	static int newCMD=-1;
	static int thread;
	/*
	 * Object, finished (True, Flase)
	 */
	ArrayList<Pair<SQObject,Boolean>> SQs=new ArrayList<Pair<SQObject,Boolean>>();
	ArrayList<Pair<TSObject,Boolean>> TSs=new ArrayList<Pair<TSObject,Boolean>>();

	ObjectExecutor currentObject;
	
	@Override
	public void shudown() {
		shutdown=true;
	}
public void run() {
		ObjectExecutor obEx=new ObjectExecutor();
		while(!shutdown)
		{
			if(previousCMD!=newCMD)
			{
				switch (newCMD)
				{
				case 0:  
					System.out.println("HNDLR: inistaite System");
			    break;
				case 1:  
					for(int i=0;i<4;i++)
					{
						SQObject obj=new SQObject(SQs.size(), this);
						SQs.add(new Pair(obj,false));
					}
					for(int i=0;i<4;i++)
					{
						TSObject obj=new TSObject(TSs.size(), this);
						TSs.add(new Pair(obj,false));
					}
					System.out.println("HNDLR: Setup processing objects");
					
			    break;
				case 2:  
					try {
						this.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
					System.out.println("HNDLR: Start super Step");
					obEx.object=SQs.get(0).getT();
					obEx.setAuthorized(true);
					obEx.start();
					
			    break;
				case 3:  
					System.out.println("HNDLR: Start associated TS "+thread);
					obEx.setAuthorized(false);
					obEx.object=TSs.get(thread).getT();
					obEx.setAuthorized(true);
			    break;
				case 4:  
					System.out.println("HNDLR: TS buffer is full- "+thread);
			    break;
				case 5:  
					System.out.println("HNDLR: No more data stars- "+thread);
					obEx.setAuthorized(false);
					obEx.object=SQs.get(thread).getT();
					obEx.setAuthorized(true);
			    break;
				case 6:  
					System.out.println("HNDLR: Out Bfr is full- "+thread);
			    break;
				case 7:  
					System.out.println("HNDLR: No more hyper edges (partial results) (In Bfr is empty)- "+thread);
			    break;
				case 8:  
					System.out.println("HNDLR: bfr is not processable- "+thread);
			    break;
				case 9:  
					System.out.println("HNDLR: Write bfr is full- "+thread);
			    break;
				case 10:  
					System.out.println("HNDLR: NetBfr is full- "+thread);
			    break;
				case 11:  
					System.out.println("HNDLR: Start Data syncro- "+thread);
			    break;
				case 12:  
					System.out.println("HNDLR: TS Buffer is Full- "+thread);
					obEx.setAuthorized(false);
					obEx.object=SQs.get(thread).getT();
					obEx.setAuthorized(true);
			    break;
				}
				previousCMD=newCMD;
			}
			
		}
		}
public static void addEvent(Integer thrd,Integer cmd)
{
	//System.out.println("Cmd: "+thrd+"-"+cmd);
	newCMD=cmd;
	thread=thrd;
	
}

	}

