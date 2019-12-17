package parser.xml.application.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/results")
public class FormServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        // read form fields
        String angajat = request.getParameter("Angajat");
        String echipa = request.getParameter("Echipa");
        System.out.println(angajat);

        // get response writer
//        PrintWriter writer = response.getWriter();

        // build HTML code
//        String htmlRespone = "<html>";
//        htmlRespone += "<h2>Your username is: " + username + "<br/>";
//        htmlRespone += "Your password is: " + password + "</h2>";
//        htmlRespone += "</html>";
//
//         return response
//        writer.println(htmlRespone);

    }
}
