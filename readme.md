- Il client si connette al server e gli invia
	1. Il nome di un file (ricevuto da riga di comando) esistente sulla macchina client
	2. Il file stesso
- Esempio di esecuzione del client
	java fileClient <serverIP> 10000 <nomeFile>
- Il server controlla se il file esiste, e se non esiste accetta il trasferimento e salva il file nella directory in cui è in esecuzione
- Architettura multithread: il server ha un processo principale che accetta le richieste di connessione, quando riceve una richiesta crea un thread che gestisce il trasferimento del file
- In ascolto sulla porta 10000
- Esempio di esecuzione del server
	java fileServer 10000
	
    ```
	String path = "C:\Users\m_ces\Documents\Video Scuola\5 AIA 2122\Appunti\Sistemi e Reti\40\MyThread.java";
	File f = new File(path);
	DataOutputStream fout = new DataOutputStream(new FileOutputStream(path));
	DataInputStream fin = new DataInputStream(new FileInputStream(path));
	```