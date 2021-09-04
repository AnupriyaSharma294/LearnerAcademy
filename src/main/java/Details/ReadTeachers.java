package Details;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import util.HibernateUtil;

/**
 * Servlet implementation class ReadTeachers
 */
public class ReadTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadTeachers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		org.hibernate.SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		List<Info2> infos = session.createQuery("from Info2").list();
        out.print("<h1> Teacher Details :- </h1>");
		out.print("<style> table,td,th {" + "border:2px solid black;" + "padding: 10px; " + "}</style>");
		out.print("<table >");
		out.print("<tr>");
		out.print("<th> Teacher Id</th>");
		out.print("<th> Teacher Name</th>");
		out.print("<th> Teacher PhoneNumber</th>");
		out.print("<th> Teacher Address</th>");
		out.print("<th> Assigned Class</th>");
		out.print("<th> Joining Date</th>");
		out.print("</tr>");

		for (Info2 info : infos) {
			out.print("<tr>");
			out.print("<td>" + info.getTeacherId() + "</td>");
			out.print("<td>" + info.getTeacherName() + "</td>");
			out.print("<td>" + info.getTeacherPhone() + "</td>");
			out.print("<td>" + info.getTeacherAddress() + "</td>");
			out.print("<td>" + info.getClassName() + "</td>");
			out.print("<td>" + info.getJoiningDate() + "</td>");
			out.print("</tr>");
		}

		out.println("</table>");
		out.println("</br></br>");
		out.println("<center><a href=\"DeleteTeacher.html\">Delete Details of Teacher</a><br><br></center>");
		out.println("<center><a href=\"Teacher.html\">Add Details of Teacher</a></center><br>");
		out.println("<center><a href=\"DashBoard.html\">DashBoard</a><br><br></center>");
		out.println("</body> </html>");	
		session.close();
	}

}
