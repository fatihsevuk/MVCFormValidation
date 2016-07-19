package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Kullanici;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		
		
		
		if(action==null){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else if(action.equals("login")){
			
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("validationMessage", "");
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);

			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String action=request.getParameter("action");
		
		if(action==null){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else if(action.equals("dologin")){
			
			String email=request.getParameter("email");
			
			String password=request.getParameter("password");
			
			request.setAttribute("email",email);
			request.setAttribute("password",password);
			
			
			
			Kullanici kullanici=new Kullanici(email, password);
			
			if(kullanici.validate()){
				
				request.getRequestDispatcher("/loginSuccess.jsp").forward(request, response);
			
			}else{
				
				request.setAttribute("validationMessage", kullanici.getMessage());
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		
		
		
		}
	}

}
