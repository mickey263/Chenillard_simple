package chenillard;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Client basique UDP
 * 
 */
public class ClientUDP
{
				
	/**
	 * Le client cree une socket, envoie un message au serveur
	 * et attend la reponse 
	 * 
	 */
	
	DatagramSocket socket;
	
	public void open() throws IOException
	{
		//
		System.out.println("Demarrage du client ...");
		socket = new DatagramSocket(null);
	}
	
	public void send(int Port) throws IOException
	{
		// Creation et envoi du message
		InetSocketAddress adrDest = new InetSocketAddress("127.0.0.1", Port);
		byte[] bufE = new String("question du client").getBytes();
		DatagramPacket dpE = new DatagramPacket(bufE, bufE.length, adrDest);
		socket.send(dpE);
		System.out.println("Message envoyé");
		
		// Attente de la reponse 
		byte[] bufR = new byte[2048];
		DatagramPacket dpR = new DatagramPacket(bufR, bufR.length);
		socket.receive(dpR);
		String reponse = new String(bufR, dpR.getOffset(), dpR.getLength());
		System.out.println("Reponse recue = "+reponse);
	}
	
	public void close() throws IOException
	{	
		// Fermeture de la socket
		socket.close();
		System.out.println("Arret du client .");
	}
}
