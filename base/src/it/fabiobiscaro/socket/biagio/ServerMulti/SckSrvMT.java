/***
* @author: birg81@gmail.com
* 
* @descrption SckSrvMultiThreads
* Questo programma istanzia un server in versione multi-thread.
* Rispetto l'esempio precedente, la programmazione multi-thread permette di poter prevedere l'arrivo anche di più connessioni simultanee, o la creazione di più server simultanei.
* Essendo il Java un linguaggio che modella tutto come un oggetto, anche la programmazione dei thread prevede l'uso di una particolare classe: Thread.
* Secondo quello che è il ciclo di vita di un processo in Java, ha un ruolo importante il metodo void run(), tale metodo viene richiamato a sua volta dal metodo start() che quindi avvia il processo. In termini pratici, tutte le istruzioni contenute nel metodo run() determinano il comportamento del processo.
* Quindi in sintesi: in Java basta sovrascrivere (tecnica del Override) il metodo run() contenuto nella classe Thread (che altrimenti sarebbe un metodo vuoto) in modo da caratterizzare il comportamento dei thread in Java; Riscritto questo metodo tutti gli altri metodi contenuti in Thread serviranno solo alla gestione dell'esecuzione del processo creato.
* Nella costruzione dei thread esistono in java essenzialmente due tecniche:
* - extend Thread usando inheritance (ereditarietà) così facendo però, ci si preclude la possibilità di creare una classe che possa ereditare da altre classi (avendo Java un meccanismo ad ereditarietà singola); inoltre contenendo la classe Thread molti metodi, molti dei quali non utilizzati affatto dal programmatore, si finirebbe per creare un oggetto eccessivamente corposo rispetto le reali richieste delle specifiche del programma.
* - implements Runnable: questo approccio fa uso di un'interfaccia Runnable, la quale ha come unico metodo void run()
* Questo secondo metodo risolve i difetti sopra elencati del primo.
* Questo secondo metodo richiede però l'utilizzo di un oggetto Thread al cui interno come parametro viene passatto un oggetto che implementa l'interfaccia Runnable.
*
* Il server così creato rispetto il precedente esempio sposta il carico di codice dal metodo main a diversi metodi, concentrandoli ovviamente nel metodo run().
*
* Questo esempio prevede solo la classe server, la classe che modella il client non esiste in quanto si può tranquillamente adoperare la classe client del metodo precedente
***/

package it.fabiobiscaro.socket.biagio.ServerMulti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SckSrvMT implements Runnable {
	private final ServerSocket ss; // creazione server dichiarato final in quando una volta creato non viene
									// modificato
	private Socket s; // oggetto socket serve accettare le diverse connessioni
	private Scanner in; // serve per ricevere messaggi

	public SckSrvMT(int PORT) throws IOException { // costruttore: inizializza il servere al valore indicato nella porta
		ss = new ServerSocket(PORT);
	}

	@Override
	public void run() {
		System.out.printf("Server Ready on port: %d..\n", ss.getLocalPort());
		String CMD = "";
		boolean tobecontinue = true; // thread non prevede un metodo per fermare run, è pratica comune utilizzare un
										// booleano che arresti il ciclo
		for (; tobecontinue;) {
			try {
				s = ss.accept();
				in = new Scanner(s.getInputStream());
				CMD = in.nextLine();
				System.out.printf( // ho optato x utilizzae printf in luogo a print o println ma è una scelta
									// personale
						"Connect accept from %s:%s >>[\'%s\']\n", s.getInetAddress(), s.getPort(), CMD);
				s.close();
			} catch (IOException e) {
				System.err.println("Error on connect..");
			} finally {
				tobecontinue = !CMD.equals("END"); // se ricevo la stringa END arresta il server
			}
		}
		System.out.println("Remote Command! Server Closed..");
	}

	@Override
	protected void finalize() throws IOException {
		in.close();

		if (!s.isClosed())
			s.close();

		if (!ss.isClosed())
			ss.close();
	}

	public static void main(String[] args) throws IOException {

		/***
		 * @description Creo un oggetto thread nel cui costruttore passo il metodo che
		 *              ha fatto uso dell'interafaccia Runnable L'oggetto
		 *              SckSrvMultiThreads crea il server, e ne caratterizza il
		 *              comportamento attraverso override di run()
		 * @param PORT
		 *            {int} Porta sulla quale il server si mette in ascolto. Parametro
		 *            indicato via CLI, altrimenti è usato il valore di defaul 1234
		 ***/
		new Thread(new SckSrvMT((args.length > 0) ? Integer.parseInt(args[0]) : 1234)).start();

	}
}
