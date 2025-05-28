package sec01.ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	private void doHandle(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		request.setCharacterEncoding(("utf-8"));
		response.setContentType("text/html;charset=utf-8");
		
		String file_repo = "C:\\file_repo";
		String fileName = request.getParameter("fileName");
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\"");
		System.out.println("fileName"+ fileName);
		
		OutputStream out=response.getOutputStream();
		String downFile=file_repo+"\\"+fileName;
		
		File file= new File(downFile);
		
		FileInputStream in = new FileInputStream(file);
		byte[] buffer= new byte[1024*8];
		
		while(true) {
		int count= in.read(buffer);
		if(count==-1)
			break;
		out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

}
