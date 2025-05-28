package sec01.ex01;

import java.awt.ItemSelectable;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.taglibs.standard.lang.jstl.test.beans.Factory;

@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String encoding="utf-8";
		File currentDirPath= new File("c:\\file_repo\\파일명");
		DiskFileItemFactory factory= new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items= upload.parseRequest(request);
			for(int i=0;i<items.size();i++) {
				FileItem fileItem= (FileItem)items.get(i);
				
				if(fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString(encoding));
				} else {
					System.out.println("매개변수이름:" +fileItem.getFieldName());
					System.out.println("파일이름" +fileItem.getName());
					System.out.println("파일크기:" +fileItem.getSize() +"bytes");
					
					if(fileItem.getSize()>0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx==-1) {
							idx=fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx + 1);
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
					}		
				}
			}
		} catch (FileUploadException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
