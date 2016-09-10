package chenillard;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Serveur basique UDP
 */
public class ServeurUDP
{

	DatagramSocket socket;
	
	public void open(int Port) throws IOException
	{
		//
		System.out.println("Demarrage du serveur ...");
		
		// Le serveur se declare aupres de la couche transport
		System.out.println(Port);
		
		//Creation de la socket
		socket = new DatagramSocket(null);
		socket.bind(new InetSocketAddress(Port));
	}
	
	public void receive() throws IOException
	{
		// Attente du premier message
		byte[] bufR = new byte[2048];
		DatagramPacket dpR = new DatagramPacket(bufR, bufR.length);
		socket.receive(dpR);
		String message = new String(bufR, dpR.getOffset(), dpR.getLength());
		System.out.println("Message recu = "+message);
		
		// Emission d'un message en retour
		byte[] bufE = new String("ok").getBytes();
		DatagramPacket dpE = new DatagramPacket(bufE, bufE.length, 
				dpR.getAddress(),dpR.getPort());
		socket.send(dpE);
		System.out.println("Message envoye = ok");
	}
	
	public void close() throws IOException
	{
		// Fermeture de la socket
		socket.close();
		System.out.println("Arret du serveur .");
	}
		
}
