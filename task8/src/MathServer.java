package src;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MathServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4234);
            System.out.println("Server initialised ...");
            Socket socket = server.accept();
            System.out.println("Established connection ... listening");
            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            OutputStream os = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            while (true) {
                String message = dis.readUTF();
                if (message.trim().equalsIgnoreCase("end")) {
                    System.out.println("Server is closing down ...");
                    dis.close();
                    break;
                }
                String[] parts = message.split(" ");
                for (String item : parts) {
                    System.out.print(item + " : ");
                }
                String operand = parts[1];
                int val1 = Integer.valueOf(parts[0]);
                int val2 = Integer.valueOf(parts[2]);
                int ans = 0;
                switch (operand) {
                    case "+":
                        System.out.println("Adding " + val1 + " + " + val2);
                        ans = val1 + val2;
                        break;
                    case "-":
                        System.out.println("Substracting " + val2 + " from " + val1);
                        ans = val1 - val2;
                        break;
                    case "/":
                        System.out.println("Divsion of " + val1 + " by " + val2);
                        ans = val1 / val2;
                        break;
                    case "*":
                        System.out.println("Mulitplication of " + val1 + " " + val2);
                        ans = val1 * val2;
                        break;
                    default:
                        System.out.println("Operation invalid");
                        break;
                }
                dos.writeUTF(Integer.toString(ans));
                dos.flush();
            }
            dis.close();
            dos.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
