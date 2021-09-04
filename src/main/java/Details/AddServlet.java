package Details;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	    String studentName=request.getParameter("studentName");
	    String stPhone=request.getParameter("stPhone");
	    String stAddress=request.getParameter("stAddress");
	    String courseName=request.getParameter("courseName");
	    String JoiningDate=request.getParameter("JoiningDate");
		if(studentName=="" && stPhone=="" && stAddress=="" && courseName=="" &&JoiningDate=="") {
	    out.println("<html><body>");
	    out.println("<center> <span style='color:red'>Please fill all Details</span></center></br></br>");
		out.println("<center><a href=\"Class.html\">Try Again</a></center></br></br>");
		out.println("</html></body>");
		}
		else {		
		Info i=new Info();
		i.setStudentName(studentName);
		i.setstPhone(stPhone);
		i.setstAddress(stAddress);
		i.setCourseName(courseName);
		i.setJoiningDate(JoiningDate);
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.save(i);
        tx.commit();
        out.println("<html><body>");
		out.println("<center> <span style='color:green'><h2>Details Saved Sucessfully</h2></span></center><br>");
		out.println("<center><a href=\"Class.html\">Add new details of Student</a></center><br>");
		out.println("<center><a href=\"View.html\">View Details of Student</a><br><br></center>");
		out.println("<center><a href=\"Delete.html\">Delete Details of Student</a><br><br></center>");
		out.println("<center><a href=\"DashBoard.html\">Dashboard</a><br><br></center>");
		out.println("</html></body>");
		session.close();	
		}
	}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	}


