package chenillard;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;

public class ColorFrame
{
	public static void startChenillard(int id, int PortSrc, int PortClient) throws IOException,InterruptedException
	{
		JFrame frame = new JFrame("Chenillard" + id);
		frame.setSize(300,300);

		
		ServeurUDP serveurUDP = new ServeurUDP();
		serveurUDP.open(PortSrc);
		ClientUDP clientUDP = new ClientUDP();
		clientUDP.open();
		
		//
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setVisible(true);
		Thread.sleep(15000);

		if (id != 1)
		{
			serveurUDP.receive();
		}
		
		//
		frame.getContentPane().setBackground(Color.RED);
		frame.setVisible(true);
		Thread.sleep(2000);
		
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setVisible(true);
		Thread.sleep(2000);
		
		clientUDP.send(PortClient);
		
		serveurUDP.close();
		clientUDP.close();
		frame.dispose();
	}
}
