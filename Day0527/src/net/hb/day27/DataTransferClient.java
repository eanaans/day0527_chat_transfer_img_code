package net.hb.day27;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class DataTransferClient{

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("203.236.209.122", 8888);

		System.out.println(socket);

//		InputStream in = socket.getInputStream();

		// save file name
//		FileDialog fd = new FileDialog(new Frame(),"save file", FileDialog.SAVE);
//		fd.setVisible(true);
//		String dir = fd.getDirectory();
//		System.out.println("fd.getDirectory(): " + dir); // after selecting file, show this line
//		String file = fd.getFile();
//		if (dir == null || file == null){
//			return;
//		}
//		File saveFilePath = new File(dir + file);
//		
	//open file-----------------------------------------------
	System.out.println("select file name");
	FileDialog fd = new FileDialog(new Frame(), "Open file", FileDialog.LOAD);
	fd.setVisible(true);
	String dir = fd.getDirectory();
	System.out.println("dir : "+ dir);
	String fileName = fd.getFile();
	System.out.println("FileName : " + fileName);
	
	if(dir == null || fileName == null){
		return;
	}
	
	File selectedfilePath = new File(dir+fileName);
	System.out.println("file path : " + selectedfilePath);
	BufferedInputStream in = new BufferedInputStream(new FileInputStream(selectedfilePath)); // send file name
	//----------------------------------------------
		// save path
		BufferedOutputStream out =  new BufferedOutputStream(new FileOutputStream("C:\\Mtest\\xyz.gif")); // save
//		OutputStream out = new FileOutputStream(saveFilePath); // save
																																						// name
		while (true) {
			int data = in.read();

			if (data == -1) {
				break;
			}// end if
			out.write(data);
		}// end while

		in.close();
		out.close();
		socket.close();
	}// end main
}// end class
