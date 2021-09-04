package Details;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import Details.Info;
import util.HibernateUtil;

/**
 * Servlet implementation class ReadInfo
 */

public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadServlet() {
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
		List<Info> infos = session.createQuery("from Info").list();
        out.print("<h1> Student Details :- </h1>");
		out.print("<style> table,td,th {" + "border:2px solid black;" + "padding: 10px; " + "}</style>");
		out.print("<table >");
		out.print("<tr>");
		out.print("<th> Student Id</th>");
		out.print("<th> Student Name</th>");
		out.print("<th> Student PhoneNumber</th>");
		out.print("<th> Student Address</th>");
		out.print("<th> CourseName</th>");
		out.print("<th> Joinind Date</th>");
		out.print("</tr>");

		for (Info info : infos) {
			out.print("<tr>");
			out.print("<td>" + info.getStudentId() + "</td>");
			out.print("<td>" + info.getStudentName() + "</td>");
			out.print("<td>" + info.getstPhone() + "</td>");
			out.print("<td>" + info.getstAddress() + "</td>");
			out.print("<td>" + info.getCourseName() + "</td>");
			out.print("<td>" + info.getJoiningDate() + "</td>");
			out.print("</tr>");
		}

		out.println("</table>");
		out.println("</br></br>");
		out.println("<center><a href=\"Delete.html\">Delete Details of Student</a><br><br></center>");
		out.println("<center><a href=\"Class.html\">Add details of Student</a></center><br>");
		out.println("<center><a href=\"DashBoard.html\">DashBoard</a><br><br></center>");
		out.println("</body> </html>");
		session.close();
	}
    
	}

