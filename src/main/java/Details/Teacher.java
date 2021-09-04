package Details;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Servlet implementation class Teacher
 */
public class Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		PrintWriter out = response.getWriter();
    		response.setContentType("text/html");
    	    String teacherName=request.getParameter("teacherName");
    	    String teacherPhone=request.getParameter("teacherPhone");
    	    String teacherAddress=request.getParameter("teacherAddress");
    	    String className=request.getParameter("className");
    	    String JoiningDate=request.getParameter("JoiningDate");
    	    
    		if(teacherName=="" && teacherPhone=="" && teacherAddress=="" && className=="" && JoiningDate=="") {
    	    out.println("<html><body>");
    	    out.println("<center> <span style='color:red'>Please fill all Details</span></center></br></br>");
    		out.println("<center><a href=\"Teacher.html\">Try Again</a></center></br></br>");
    		out.println("</html></body>");
    		}
    		else {		
    		Info2 i=new Info2();
    		i.setTeacherName(teacherName);
    		i.setTeacherPhone(teacherPhone);
    		i.setTeacherAddress(teacherAddress);
    		i.setClassName(className);
    		i.setJoiningDate(JoiningDate);
    		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
    		Session session = sf.openSession();
    		org.hibernate.Transaction tx = session.beginTransaction();
    		session.save(i);
            tx.commit();
            out.println("<html><body>");
    		out.println("<center> <span style='color:green'><h2>Details Saved Sucessfully</h2></span></center><br><br>");
    		out.println("<center><a href=\"Teacher.html\">Add Details of Teacher</a></center><br><br>");
    		out.println("<center><a href=\"View.html\">View Details of Teacher</a></center><br><br>");
    		out.println("<center><a href=\"DeleteTeacher.html\">Delete Details Teacher</a><br><br></center>");
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