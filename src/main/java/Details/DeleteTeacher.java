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
 * Servlet implementation class DeleteTeacher
 */
public class DeleteTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTeacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String teacherName=request.getParameter("teacherName");
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		String HQL="Delete From Info2 Where teacherName=:teacherName";
		Query query=session.createQuery(HQL);
		query.setParameter("teacherName", teacherName);
		org.hibernate.Transaction h = session.beginTransaction();
		int executeUpdate =query.executeUpdate();
		session.getTransaction().commit();
		 PrintWriter out=response.getWriter();
		 out.println("<html><body>");
		 out.println("<center> <span style='color:green'><h2>Details Deleted Sucessfully</h2></span></center><br><br>");
		 out.println("<center><a href=\"Teacher.html\">Add details of Teacher</a></center><br>");
		 out.println("<center><a href=\"View.html\">View Details of Teacher</a></center><br>");
		 out.println("<center><a href=\"DeleteTeacher.html\">Delete More Details</a></center><br>");
		 out.println("</body> </html>");	
		}
		
		
       catch(Exception e) {
	e.printStackTrace();
}

		
	}

}
