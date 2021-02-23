import java.lang.System;
import java.net.*;
import java.io.*;
import java.math.*;

class bitc{
	public static void main(String as[]){
	 try{
	InetAddress addr= InetAddress.getByName("Local Host");
	System.out.println(addr);
	Socket s= new Socket(addr, 47);
	DataOutputStream out= new DataOutputStream(s.getOutputStream());
	BufferedInputStream in= new BufferedInputStream(s.getInputStream());
	BufferedInputStream inn= new BufferedInputStream(s.getInputStream());
 	BufferedReader b= new BufferedReader(new InputStreamReader(System.in));
	int flag= 0;
	System.out.println("Connected");
	System.out.println("Enter the number of frame to be requested to server:");
	int c= Integer.parseInt(b.readLine());
	out.write(c);
	out.flush();
	int i,j=0;
	while(j<c){
		i= in.read();
		System.out.println("Recieved frame number: "+i);
		System.out.println("Sending acknowledgement for frame number: "+i);
		out.write(i);
		out.flush();
		j++;
	}
	out.flush();
	in.close();
	inn.close();
	out.close();
	System.out.println("Quitting...");
	Thread.sleep(1000);
	}
	catch(Exception e){
	}
	}
}