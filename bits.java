import java.lang.System;
import java.net.*;
import java.io.*;

class bits{
	public static void main(String as[]){
	try{
	BufferedInputStream in;
	ServerSocket ss= new ServerSocket(47);
	System.out.println("Waiting for Connection....");
	Socket s= ss.accept();
	System.out.println("Recieved request to send frames");
	in= new BufferedInputStream(s.getInputStream());
	DataOutputStream out= new DataOutputStream(s.getOutputStream());
	int p = in.read();
	System.out.println("Sending....");
	for(int i=1;i<=p;i++){
		System.out.println("Sending frame number"+i);
		out.write(i);
		out.flush();
		System.out.println("Waiting for acknowledgement...");
		Thread.sleep(1000);
		int a = in.read();
		System.out.println("recieved acknowledgement for frame number: "+i+"as "+a);
	}
	out.flush();
	in.close();
	out.close();
	s.close();
	ss.close();
	System.out.println("Quitting....");
	}
	catch(Exception e){
	}
	}
}