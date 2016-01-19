package it.fabiobiscaro.prodotti;

public class ProdottoTest {
	public static void main(String[] args) {
		Prodotto p = new Prodotto("123","qwe",12);
		System.out.println(p);
		Prodotto p1 = new Prodotto("123","qwe",12);
		System.out.println(p.equals(p1));
		try {
			Prodotto p2 = (Prodotto) p1.clone();
			System.out.println(p2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Alimentare
		Alimentare a = new Alimentare("qwe", "banane", 100.0f, new Data(26,1,2016));
		System.out.println(a);
		a.applicaSconto();
		System.out.println(a);
		
	}
}
