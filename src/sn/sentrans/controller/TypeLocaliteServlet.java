package sn.sentrans.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/TypeLocalite", name = "typelocalite")
public class TypeLocaliteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //resp.getWriter().println("OK page trouve");
        req.getRequestDispatcher( "/vues/typelocalite/add.jsp").forward(req, resp);
    }
}
