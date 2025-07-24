import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 1234;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                // Read menu
                for (int i = 0; i < 7; i++) {
                    System.out.println(in.readLine());
                }

                String choice = scanner.nextLine();
                out.println(choice);

                if (choice.equals("1")) {
                    System.out.println(in.readLine());
                    out.println(scanner.nextLine());
                    System.out.println(in.readLine());
                    out.println(scanner.nextLine());
                    System.out.println(in.readLine());
                    out.println(scanner.nextLine());
                    System.out.println(in.readLine());
                    out.println(scanner.nextLine());
                    System.out.println(in.readLine());
                } else if (choice.equals("2") || choice.equals("3") || choice.equals("4")) {
                    System.out.println(in.readLine());
                } else if (choice.equals("5")) {
                    System.out.println(in.readLine());
                    break;
                } else {
                    System.out.println(in.readLine());
                }
            }
        }
    }
}
