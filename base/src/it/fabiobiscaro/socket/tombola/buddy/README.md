# Tombola
Gioco della tombola completamente automatico

### Introduzione
Ho scritto questi sorgenti per un amico, a cui serviva un'implementazione del gioco della tombola per una web app.
I sorgenti sono ben ordinati e commentati, sono stati pensati per essere studiati.

Le regole seguite sono quelle trovate a [questo indirizzo](http://www.tombolaitaliana.it/italiano/le_regole_del_gioco_della_tombola.php).

##### Funzionamento
Il funzionamento è del tutto automatico: una volta creata la partita, attende il numero di giocatori necessari per
avviarla, assegna ad ognuno una cartella casuale e procede all'estrazione. Raccoglie il montepremi (una data cifra
da ogni giocatore) e distribuisce le vincite.

Ogni turno produce output nel terminale (System.out), così si può seguire per intero la partita mentre si svolge.
Alla fine mostra i vincitori dei vari premi e l'importo vinto.

Esiste la possibilità (default attiva) di mostrare anche le cartelle in tabella (con il layout che avrebbero delle
vere cartelle di Tombola), contrassegnando con un # i numeri già estratti.

##### Estensione
Il codice è breve e ben documentato, quindi può facilmente essere esteso per creare un gioco interattivo.

Pull request sono ben accette. Questo progetto è nato come un semplice esempio (benché funzionante), quindi
ci sono ampi margini di miglioramento e potenziamento.

### Lista classi
| File | Descrizione |
|------|-------------|
| **Cartella.java** | una cartella di tombola, tiene traccia dei numeri che contiene e se sono segnati o meno |
| **Gestore.java** | gestisce le iscrizioni dei giocatori alle partite e inizia le partite quando si raggiunge il minimo per giocare. Le costanti *NUM_GIOCATORI* e *PREZZO_CARTELLA* sono modificabili. |
| **Giocatore.java** | un giocatore, indicato da un nome (testo). Contiene una cartella (assegnata ad ogni inizio partita) e un registro delle vincite e della somma totale vinta. |
| **Partita.java** | singola partita. Contiene un elenco di giocatori e un tabellone. |
| **Tabellone.java** | tabellone di gioco. Contiene i numeri da 1 a 90 da estrarre in ordine casuale. |
| **Test.java** | piccola classe con un main() per testare il funzionamento delle altre classi. Non è necessaria per il progetto, ma dà una dimostrazione dell'uso delle altre classi. |
| **Utility.java** | classe con metodi statici, generici, utilizzati dalle altre classi. |
| **Vincita.java** | elenco delle possibili vincite della tombola |


### Compilare
Digitare nel terminale *make*

### Eseguire la classe Test
Digitare nel terminale *make test*

