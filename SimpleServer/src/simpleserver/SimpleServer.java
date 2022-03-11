/**
 *
 *  Mohammed El-Nabawy soliman ghaze
 */

package simpleserver;

import java.util.*;  
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    

    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        ServerSocket serverSocket = new ServerSocket(5050);
        System.out.println("Server started at port 5050");
        Socket socket = serverSocket.accept();
        System.out.println("Server got a client");

        OutputStream socketOutputStream = socket.getOutputStream();
        DataOutputStream socketDOS = new DataOutputStream(socketOutputStream);
        System.out.print("The Server MSG");  
        String serverMsg = sc.nextLine(); 

        
        socketDOS.writeUTF(serverMsg);
        System.out.println(serverMsg);


        InputStream socketInputStream = socket.getInputStream();
        DataInputStream socketDIS = new DataInputStream(socketInputStream);

        String clientResponse = socketDIS.readUTF();
        System.out.println(clientResponse);

        // Close the sesions
        socketDOS.close();
        socketDIS.close();
        socketOutputStream.close();
        socketInputStream.close();
        socket.close();
        serverSocket.close();

    }
}