package chenillard;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;

public class ColorFrame
{
	static JFrame frame;
	static ServeurUDP serveurUDP;
	static ClientUDP clientUDP;
	
	public static void startChenillard(int PortSrc, int PortClient,int firstProc) throws IOException,InterruptedException
	{
		frame = new JFrame("Chenillard");

		serveurUDP = new ServeurUDP();
		serveurUDP.open(PortSrc);
		clientUDP = new ClientUDP();
		clientUDP.open();

		if (firstProc == 1) {clientUDP.send(PortClient);}
		
		while (0==0) {
			frame.setSize(300,300);
			
			//
			frame.getContentPane().setBackground(Color.GREEN);
			frame.setVisible(true);
			Thread.sleep(15000);
	
			serveurUDP.receive();
			
			//
			frame.getContentPane().setBackground(Color.RED);
			frame.setVisible(true);
			Thread.sleep(2000);
			
			frame.getContentPane().setBackground(Color.GREEN);
			frame.setVisible(true);
			Thread.sleep(2000);
			
			clientUDP.send(PortClient);
		}

		//serveurUDP.close();
		//clientUDP.close();
		//frame.dispose();
	}
}
