import java.io.*;
import java.net.Socket;

/**
 * Ѕыл выбран блокирующий способ взаиодействи€, поскольку в данном
 * случае нет смысла продолжени€ работы программы без получени€ конкретных данных
 * (Ќеобходимое число дл€ вычислени€ - серверу и результат вычислений дл€ клиента).
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 10801);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String msg;
            while (true) {
                System.out.println("Enter the number, write 'quit' to quit");
                msg = terminalReader.readLine();
                if (msg.equals("quit")) {
                    break;
                }
                out.println(msg);
                if (msg.equals("quit")) {
                    break;
                }
                String response = in.readLine();
                System.out.println("Server: " + response);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
