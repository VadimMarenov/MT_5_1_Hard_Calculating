import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(10801);
                 Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {
                String line;
                while ((line = in.readLine()) != null) {

                    int number = Integer.parseInt(line);
                    if (number < 0) {
                        out.println("Something wrong, try again");
                    }
                    long result = Calculator.calculatingFibonacciByPosition(number);
                    out.println(number + " element of Fibonacci series is: " + result);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
