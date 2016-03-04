package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Не-Spring MVC сервлет
 */
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Properties properties = System.getProperties();
        Enumeration<?> e = properties.propertyNames();
        while (e.hasMoreElements()) {
            String key = e.nextElement().toString();
            String value = properties.getProperty(key);
            out.println(key + " = " + value);
        }
    }
}
