import java.net.*;
import java.io.*;

public class serverecho {
    public static void main(String[] args){
        int port;
        try{
            BufferedReader buff =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please Enter the client port number:");
            port=Integer.parseInt(buff.readLine());
            ServerSocket ss=new ServerSocket(port);
            System.out.println("Server is ready to receive message");
            System.out.println("waiting");
            Socket s=ss.accept();
            if (s.isConnected()==true)
                System.out.println("Client socket connection succesfully");
            InputStream in=s.getInputStream();
            OutputStream ou=s.getOutputStream();
            PrintWriter pw=new PrintWriter(ou);
            BufferedReader b=new BufferedReader(new InputStreamReader(in));
            String str=b.readLine();
            System.out.println("message received from client:"+str);
            System.out.println("this is forward to client");
         pw.flush();
        }
        catch(Exception e){
            System.out.println("error"+e.getMessage());
        }
    }
}
