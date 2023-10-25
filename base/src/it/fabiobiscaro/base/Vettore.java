package it.fabiobiscaro.base;

public class Vettore {
	private int x,y;
	
	public Vettore() {
		
	}
	
	public Vettore(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vettore lista[] = new Vettore[5];
		int elementi = 0;
		
		lista[0] = new Vettore(1,2);
		
		System.out.println("Numero elementi " + lista.length);
		System.out.println("Elemento 1: " + lista[1]);
		System.out.println("Elemento 0: " + lista[0]);
		//lista[0].
	}

}
