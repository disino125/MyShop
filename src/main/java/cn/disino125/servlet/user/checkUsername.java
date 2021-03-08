package cn.disino125.servlet.user;

import cn.disino125.service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/checkUsername")
public class checkUsername extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        int count = UserDao.checkById(username);

        PrintWriter out = resp.getWriter();
        if(count>0){
            out.print("true");
        }else{
            out.print("false");
        }
        out.close();
    }
}
