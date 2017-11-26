package it.fabiobiscaro.datagram;

import java.io.Serializable;

public class Prova implements Serializable {
	int a;
	int b;
	public Prova() {
		// TODO Auto-generated constructor stub
	}
	
	public Prova(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
