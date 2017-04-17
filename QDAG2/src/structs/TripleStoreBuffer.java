package structs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/*
 * SG, head, datastars
 */
public class TripleStoreBuffer extends HashMap<Integer,HashMap<Integer,dataStar>>{
	Integer limit=0;// nombre d'element acccepté (en theorie)
	float partProcess=0.7f; // ratio, des qu'on a atteint ce ratio on peut traiter la file d'attente
	float MaxAllocation=1.0f; // le taux de remplissage autorisé
	boolean finished=false; //etat
	int size=0;// taille acctuelle de la file d'attente
	public TripleStoreBuffer(int limit)
	{
		this.limit=limit;
	}
	public boolean IsFull()
	{
		if(size>=limit) return true;
		else return false;
	}
	public dataStar poll()
	{
		if(this.size()>0)
		{
			Map.Entry<Integer,HashMap<Integer,dataStar>> entry=this.entrySet().iterator().next();
			Integer sg= entry.getKey();
			HashMap<Integer,dataStar> value=entry.getValue();
			Map.Entry<Integer,dataStar> entry2=value.entrySet().iterator().next();
			Integer str= entry2.getKey();
			dataStar strD=entry2.getValue();
			value.remove(str);
			if(value.isEmpty()) this.remove(sg);
			size--;
			return strD;
			 
		}
		else return null;
	}
	public boolean canAdd()
	{
		if(size<(limit*MaxAllocation)) return true;
		else return false;
	}
	public boolean isProcessable()
	{
		float part=((float) size)/((float)limit);
		if(part>=partProcess) return true;
		else return false;
	}
	public void setFinished()
	{
		finished=true;
	}
	public boolean isFinished()
	{
		return finished;
	}
	public void add(int sg, int idStr, dataStar dataStar) { // sg : segment id, id dataStar, data star
		if(this.containsKey(sg))
			this.get(sg).put(idStr, dataStar);
		else 
		{
			HashMap<Integer,dataStar> sgstrs=new HashMap<Integer,dataStar>();
			sgstrs.put(idStr, dataStar);
			this.put(sg, sgstrs);
		}
		size++;
		
	}
}
