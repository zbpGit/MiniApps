package com.chatRobot.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;


public class SaveAndDeleteFileUtil {

	public static String savaFile(MultipartFile file, String path, HttpServletRequest request){

		String oldFileName=file.getOriginalFilename();

		String fileType= oldFileName.substring(oldFileName.lastIndexOf('.'),oldFileName.length());

		String newFileName = UUID.randomUUID().toString() + fileType;

		String firstPath=request.getServletContext().getRealPath(path);
		File targetFile=new File(firstPath, newFileName);
		if(!targetFile.exists()){
			targetFile.mkdirs();
		}
		try {

			file.transferTo(targetFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return newFileName;
	}
	

	public static void deleteFile(String fileName, String path, HttpServletRequest request){
		String firstPath=request.getServletContext().getRealPath(path);
		File file = new File(firstPath, fileName);
		if (file.isFile() && file.exists()){
        	file.delete();
        }
	}
	

	public static boolean fileIsExit(String fileName, String path, HttpServletRequest request){
		String firstPath=request.getServletContext().getRealPath(path);
		File file = new File(firstPath, fileName);
		if (file.isFile() && file.exists()){
        	return true;
        }
		return false;
	}
}
