import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(8099);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            System.out.println("New connection accepted");
            final String hello = in.readLine();

            out.println("Hi. Write your name?");
            final String name = in.readLine();

            out.println("What is your surname?");
            final String surname = in.readLine();

            out.println("Are you child? (yes/no)");
            final String yes_no= in.readLine();

            switch (yes_no) {
                case "yes" :
                    out.println(String.format("Welcome to the kids area, %s %s! Let's play!", name, surname));
                    break;
                case "no" :
                    out.println(String.format("Welcome to the adult zone, %s %s! Have a good rest, or a good working day!", name, surname));
                    break;
                default:
            }
        }
    }
}