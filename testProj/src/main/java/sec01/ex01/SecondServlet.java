package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SecondServlet extends HttpServlet{

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		super.doDelete(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		super.doGet(req, resp);
	}

	@Override
	public void destroy() {
		// TODO 자동 생성된 메소드 스텁
		super.destroy();
	}

	@Override
	public String getInitParameter(String name) {
		// TODO 자동 생성된 메소드 스텁
		return super.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		// TODO 자동 생성된 메소드 스텁
		return super.getInitParameterNames();
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO 자동 생성된 메소드 스텁
		return super.getServletConfig();
	}

	@Override
	public ServletContext getServletContext() {
		// TODO 자동 생성된 메소드 스텁
		return super.getServletContext();
	}

	@Override
	public String getServletInfo() {
		// TODO 자동 생성된 메소드 스텁
		return super.getServletInfo();
	}

	@Override
	public String getServletName() {
		// TODO 자동 생성된 메소드 스텁
		return super.getServletName();
	}

	@Override
	public void init() throws ServletException {
		// TODO 자동 생성된 메소드 스텁
		super.init();
	}

	@Override
	public void log(String message) {
		// TODO 자동 생성된 메소드 스텁
		super.log(message);
	}

	@Override
	public void log(String message, Throwable t) {
		// TODO 자동 생성된 메소드 스텁
		super.log(message, t);
	}

	@Override
	public int hashCode() {
		// TODO 자동 생성된 메소드 스텁
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO 자동 생성된 메소드 스텁
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO 자동 생성된 메소드 스텁
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO 자동 생성된 메소드 스텁
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO 자동 생성된 메소드 스텁
		super.finalize();
	}

	
	
	
	
	
}
