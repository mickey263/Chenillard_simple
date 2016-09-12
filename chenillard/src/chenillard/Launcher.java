package chenillard;

import java.io.IOException;

public class Launcher {

	public static void main(String[] args) throws IOException,InterruptedException
	{
		// TODO Auto-generated method stub
		int portSrv 	= Integer.valueOf(args[0]);
		int portClient 	= Integer.valueOf(args[1]);
		int firstProc  	= Integer.valueOf(args[2]);
		
		//
		ColorFrame.startChenillard(portSrv,portClient,firstProc);
	}
}
