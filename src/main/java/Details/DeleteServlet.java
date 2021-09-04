package Details;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String studentName=request.getParameter("studentName");
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		String HQL="Delete From Info Where studentName=:studentName";
		Query query=session.createQuery(HQL);
		query.setParameter("studentName", studentName);
		org.hibernate.Transaction h = session.beginTransaction();
		int executeUpdate =query.executeUpdate();
		session.getTransaction().commit();
		 PrintWriter out=response.getWriter();
		 out.println("<html><body>");
		 out.println("<center> <span style='color:green'><h2>Details Deleted Sucessfully</h2></span></center><br><br>");
		 out.println("<center><a href=\"Class.html\">Add details of Student</a></center><br>");
		 out.println("<center><a href=\"View.html\">View Details of Student</a></center><br>");
		 out.println("<center><a href=\"Delete.html\">Delete More Details</a></center><br>");
		 out.println("</body> </html>");	
		}
		
		
       catch(Exception e) {
	e.printStackTrace();
}
	
	}

}