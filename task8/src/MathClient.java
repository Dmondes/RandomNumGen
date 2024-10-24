package src;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MathClient {
    public static void main(String[] args) {
        try {
            Console con = System.console();
            Socket clientSock = new Socket("localhost", 4234);
            System.out.println("Client ready ...");
            OutputStream os = clientSock.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            InputStream is = clientSock.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            while (true) {

                String input = con.readLine();
                if (input.trim().equalsIgnoreCase("end")) {
                    dos.writeUTF(input);
                    System.out.println("Client is closing down ...");
                    break;
                }
                dos.writeUTF(input);
                dos.flush();
                System.out.println("Writing to server");
                String result = dis.readUTF();
                System.out.println("The answer is : " + result);

            }
            dos.close();
            dis.close();
            clientSock.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}