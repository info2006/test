package structs;

import java.io.Serializable;

public class Pair<T,U> implements Serializable,Comparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private T t;
	U u;
	
	/*
	 * Constructors	
	 */
	public Pair() {
		super();
	}

	public Pair(T t, U u) {
		super();
		this.setT(t);
		this.u = u;
	}
	/*
	 * Setters and Getters
	 */
	
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public U getU() {
		return u;
	}
	public void setU(U u) {
		this.u = u;
	}

	@Override
	public String toString() {
		return "Pair [t=" + getT() + ", u=" + u + "]";
	}

	@Override
	public int compareTo(Object arg0) {
		
		return ((Comparable) t).compareTo(((Pair) arg0).t);
	}
	
	
}
