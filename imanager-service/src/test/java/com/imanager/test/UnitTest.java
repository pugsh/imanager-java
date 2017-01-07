package com.imanager.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnitTest {

	public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(8080);

        System.out.println("Server has started on 127.0.0.1:80.\r\nWaiting for a connection...");

        Socket client = server.accept();

        System.out.println("A client connected.");
    }
}
