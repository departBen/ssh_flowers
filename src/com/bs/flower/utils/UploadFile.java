package com.bs.flower.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class UploadFile {
	public static void upload(File file,String path){
		InputStream is;
		try {
			is = new FileInputStream(file);
			OutputStream os=new FileOutputStream(path);
			  byte buffer[]=new byte[1024];
			  int count=0;
			  while((count=is.read(buffer))>0)
			  {
				  os.write(buffer, 0, count);
			  }
			  os.close();
			  is.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
