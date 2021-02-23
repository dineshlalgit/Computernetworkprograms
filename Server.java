import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Server {

    public static void main( String[] args ) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8087)) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    handleClient(client);
                }
            }
        }
    }

    private static void handleClient(Socket client) throws IOException {
	System.out.println("Connection established");
        final String BASEDIR = "C:/Users/DINESH-LAL/Desktop/httpserver";
        File filePath = new File(BASEDIR, "home.html");


        if (Files.exists(filePath.toPath())) {
            // file exists

            sendResponse(client, "200 OK", "text/html", Files.readAllBytes(filePath.toPath()));
            System.out.println("File Found");
        } else {
            // 404
            filePath = new File(BASEDIR, "error.html");
            sendResponse(client, "404 OK", "text/html", Files.readAllBytes(filePath.toPath()));
        }

    }

    private static void sendResponse(Socket client, String status, String contentType, byte[] content) throws IOException {
        OutputStream clientOutput = client.getOutputStream();
        clientOutput.write(("HTTP/1.1 \r\n" + status).getBytes());
        clientOutput.write(("ContentType: " + contentType + "\r\n").getBytes());
        clientOutput.write("\r\n".getBytes());
        clientOutput.write(content);
        clientOutput.write("\r\n\r\n".getBytes());
        clientOutput.flush();
        client.close();
    }



}
