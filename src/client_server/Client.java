package client_server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 1201);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            String msgIn = "", msgOut = "";

            while (!msgIn.equals("end")) {
                msgOut = bf.readLine();
                dataOutputStream.writeUTF(msgOut);

                msgIn = dataInputStream.readUTF();
                System.out.println(msgIn);

                dataOutputStream.flush();
            }

            socket.close();
        } catch (Exception e) {

        }
    }
}
