import java.io.*;
import java.net.*;

public class Client {

    String nomeServer = "localhost" ; //?
    int porta = 6789;
    Socket socket;

    BufferedReader inputDaTastiera;             //Per scrivere tutto ciò che invieremo
    DataOutputStream outVersoServer;            //Flusso per i dati da inviare al server
    BufferedReader inDalServer;                 //Flusso per i dati da ricevere

    int numeroSceltoDaClient;
    int numeroRicevutoDaServer;


    //Metodo nel quale viene creata una socket dandole come argomenti il nome
    //del server e la porta sulla quale effettuare la connesione, inoltre verranno
    //inizializzati i "mezzi di trasporto" per i dati precedentemente dichiarati
    public Socket connetti() {

        try {
            inputDaTastiera = new BufferedReader(new InputStreamReader(System.in));
            socket = new Socket(nomeServer, porta);
            outVersoServer = new DataOutputStream(socket.getOutputStream());
            inDalServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        catch (UnknownHostException e){
            System.err.println("Connessione scaduta");
        }

        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(" Errore");
            System.exit(1);
        }

        return socket;
    }



    //Metodo che permette dui sfruttare i flussi di dati a nostra disposizione per
    //poter comunicare con il server, sia in ricezione che mittenza
    public void comunica(){

        try{


            socket.close();

        }

        catch(Exception e){
            System.out.println(e.getMessage()+ "Errore");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.connetti();
        client.comunica();
    }
}
