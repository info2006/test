package structs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* 
 * id,{hyperedge}
 * */
public class EdgesBuffer extends HashMap<Integer,HashMap<Integer,ArrayList<hEdge>>>{ //id sg, id star, 
	Integer limit=0;
	float partProcess=0.7f;
	float MaxAllocation=1.0f;
	int size=0;
	public EdgesBuffer(int limit)
	{
		this.limit=limit;
	}
	public boolean IsFull()
	{
		if(this.size()>=limit) return true;
		else return false;
	}
	public boolean canAdd()
	{
		if(size<(limit*MaxAllocation)) return true;
		else return false;
	}
	public boolean isProcessable()
	{
		float part=((float) this.size())/((float)limit);
		if(part>=partProcess) return true;
		else return false;
	}
	public ArrayList<hEdge> poll() {
		if(this.size()>0)
		{
			Map.Entry<Integer,HashMap<Integer,ArrayList<hEdge>>> entry=this.entrySet().iterator().next();
			Integer sg= entry.getKey();
			HashMap<Integer,ArrayList<hEdge>> value=entry.getValue();
			Map.Entry<Integer,ArrayList<hEdge>> entry2=value.entrySet().iterator().next();
			Integer str= entry2.getKey();
			ArrayList<hEdge> edges=entry2.getValue();
			value.remove(str);
			if(value.isEmpty()) this.remove(sg);
			size--;
			return edges;
			 
		}
		else return null;
	}
	public void add(int sg, int ds,hEdge he) {
		if(this.containsKey(sg))
		{
			if(this.get(sg).containsKey(ds))
				this.get(sg).get(ds).add(he);
			else
			{
				ArrayList<hEdge> edges=new ArrayList<hEdge>();
				edges.add(he);
				this.get(sg).put(ds, edges);
			}
				
		}
		else 
		{
			HashMap<Integer,ArrayList<hEdge>> sgstrs=new HashMap<Integer,ArrayList<hEdge>>();
			ArrayList<hEdge> edges=new ArrayList<hEdge>();
			edges.add(he);
			sgstrs.put(ds, edges);
			this.put(sg, sgstrs);
		}
		size++;
		
	}
}
