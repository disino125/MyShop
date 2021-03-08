package cn.disino125.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkCode")
public class checkCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String code1 = req.getParameter("code");
        String code2 = (String) req.getSession().getAttribute("code");

        PrintWriter out = resp.getWriter();
        if(code1.equals(code2)){
            out.print("true");
        }else{
            out.print("false");
        }
        out.close();
    }
}
