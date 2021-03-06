import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    private static int port = 8089;

    public static void main(String[] args) {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                System.out.println("New connection accepted");
                final String name = in.readLine();
                out.println(String.format("Hi %s, your port is %d", name, socket.getPort()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
