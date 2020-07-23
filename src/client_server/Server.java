package client_server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1201);
            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            String msgIn = "", msgOut = "";

            while (!msgIn.equals("end")) {
                msgIn = dataInputStream.readUTF();
                System.out.println(msgIn);

                msgOut = bf.readLine();
                dataOutputStream.writeUTF(msgOut);

                dataOutputStream.flush();
            }

            socket.close();
        } catch (Exception e) {

        }
    }
}
