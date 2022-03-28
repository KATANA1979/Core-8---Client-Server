import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientMain {
    private static String host = "localhost";
    private static int port = 8089;

    public static void main(String[] args) {

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            out.println("Client");
            System.out.println(in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
