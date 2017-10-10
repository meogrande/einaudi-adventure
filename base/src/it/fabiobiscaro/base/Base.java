package it.fabiobiscaro.base;

import java.util.Scanner;

public class Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ciao");
		int a=7;
		System.out.println("ciao " + a);
		int b = 6;
		System.out.println("ciao" + (a + b));
		for (int i=0; i<10; i++) {
			System.out.println(i);
		}
		
		Scanner input = new Scanner (System.in);
		System.out.print("Inserisci il primo numero:\n");
		a = input.nextInt();
		System.out.println("Il numero inserito e':" + a+ " \n a capo");
	}

}
