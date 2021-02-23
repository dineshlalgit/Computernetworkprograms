
import java.io.*;
import java.net.*;
import java.nio.file.*;
public class HttpServer {
    public static void main(String[] args) throws IOException {
       final String BASEDIR = "C:/Users/DINESH-LAL/Desktop/httpserver";
        File path = new File(BASEDIR, "home.html");
        System.out.println("File Location is "+path.getAbsoluteFile());
        ServerSocket ss =new ServerSocket(8070);
        System.out.println("\n waiting to be connected");
        Socket s =ss.accept();
        System.out.println("\n Connected Successfully");

        OutputStream out = s.getOutputStream();

        try {
            byte[] content= Files.readAllBytes(path.toPath());
            if (Files.exists(path.toPath())) {
                // file exists
                System.out.println("Location:-"+path.toPath());
                out.write(("HTTP/1.1 \r\n" + "200 ok").getBytes());
                out.write(("ContentType: " + "text/html" + "\r\n").getBytes());
                out.write("\r\n".getBytes());
                out.write(content);
                out.write("\r\n\r\n".getBytes());
                out.flush();
            }
            s.close();
            System.out.println("\n Disconnected\n");
        }
        catch (Exception e){

            System.out.println(ss.getLocalPort());
            System.out.println("File not Found"+e);
            path = new File(BASEDIR, "error.html");
            byte[] contenterror= Files.readAllBytes(path.toPath());
            contenterror= Files.readAllBytes(path.toPath());
            out.write(("HTTP/1.1 \r\n" + "404 ok").getBytes());
            out.write(("ContentType: " + "text/html" + "\r\n").getBytes());
            out.write("\r\n".getBytes());
            out.write(contenterror);
            out.write("\r\n\r\n".getBytes());
            out.flush();
            s.close();
        }

    }
}
