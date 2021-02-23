
import java.io.*;
import java.net.*;

public class clientecho 
{
    public static void main(String[] args) 
{
        int port;
        try
{
            BufferedReader buff =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter port number");
            port=Integer.parseInt(buff.readLine());
            Socket s=new Socket("127.0.0.1",port);
            System.out.println("Server is ready to receive message:");
            if (s.isConnected()==true)
                System.out.println("Server is connected");
            InputStream in=s.getInputStream();
            OutputStream ou=s.getOutputStream();
            PrintWriter pw=new PrintWriter(ou);
            BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
           
            String str1,str2;
            System.out.println("Enter a message:");
            str1=b.readLine();
            pw.println(str1);
            pw.flush();
            str2=b.readLine();
            System.out.println("Message sent by server:"+str2);
        }
        catch (Exception e){
            System.out.println("error"+e.getMessage());
        }
    }
}
