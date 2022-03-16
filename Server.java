import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    ServerSocket server = null;                 //Dichiarazione dell oggetto server
    Socket client = null;                       //Dichiarazione del client
    BufferedReader inDalClient;                 //Flusso per i dati ricevuti dal server
    DataOutputStream outVersoClient;            //Flusso per i dati da inviare al client

    int numeroRicevuto;
    int numeroModificato;



    //Metodo nel quale il server viene creato su una determinata porta, in questo caso
    //6789 e si mette in ascolto su quest'ultima; nel momento che un client si trova
    //in questa sede, il server si mette in contatto con lui, e una volta che la connessione
    //viene effettuata con successo, il server "chiude i battenti" tramite il suo metodo .close()
    public Socket attendi() {

        try {
            System.out.println("Server: Il server è partito");
            server = new ServerSocket(6789);
            client = server.accept();
            server.close();

            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());


        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("Server: Qualcosa è andato storto");
            System.exit(1);

        }

        return client;
    }


        public void comunica(){

            try{


                client.close();


        }
            catch(Exception e){

                System.out.println(e.getMessage());
            }

            }

    public static void main(String[] args) {

        Server server = new Server();
        server.attendi();
        server.comunica();

    }
    }


