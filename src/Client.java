import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        String message1 = "Hello Server";
        int port = 8099;
        Scanner scanner = new Scanner(System.in);

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            out.println(message1);
            System.out.println(message1);

            String resp1 = in.readLine();
            System.out.println(resp1);
            String message2 = scanner.nextLine();
            out.println(message2);

            String resp2 = in.readLine();
            System.out.println(resp2);
            String message3 = scanner.nextLine();
            out.println(message3);

            String resp3 = in.readLine();
            System.out.println(resp3);
            String message4 = scanner.nextLine();
            out.println(message4);

            String resp4 = in.readLine();
            System.out.println(resp4);
        }
    }
}