package net.hb.day27;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DataTransferServer {
public static void main(String[] args) throws Exception{
		
		ServerSocket server = new ServerSocket(8888);
		

//		InputStream in = new FileInputStream("C:\\Mtest\\images\\aaa.gif"); // send file name
		
		
		System.out.println(" ready --------------------");
		//open file-----------------------------------------------
//		System.out.println("select file name");
//		FileDialog fd = new FileDialog(new Frame(), "Open file", FileDialog.LOAD);
//		fd.setVisible(true);
//		String dir = fd.getDirectory();
//		System.out.println("dir : "+ dir);
//		String fileName = fd.getFile();
//		System.out.println("FileName : " + fileName);
//		
//		if(dir == null || fileName == null){
//			return;
//		}
//		
//		File selectedfilePath = new File(dir+fileName);
//		System.out.println("file path : " + selectedfilePath);
//		BufferedInputStream in = new BufferedInputStream(new FileInputStream(selectedfilePath)); // send file name
		//----------------------------------------------
		Socket clientSocket = server.accept();
		
		OutputStream out = clientSocket.getOutputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		System.out.println(clientSocket);
		
		while(true){
			int data = in.read();
			
			if(data == -1){
				break;
			}// end if
			out.write(data);
		}// end while
		
		out.flush();
		out.close();
		in.close();
		clientSocket.close();
		server.close();
	}// end main
}// end clas
