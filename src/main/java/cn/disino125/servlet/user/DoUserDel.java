package cn.disino125.servlet.user;

import cn.disino125.service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager/admin_DoUserDel")
public class DoUserDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String cp = req.getParameter("cp");

        int count = UserDao.deleteById(id);

        if(count>0){
            resp.sendRedirect("admin_DoUserSelect?cp="+cp);
        }else{
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alter('User Löschen Error！！！')");
            out.write("location.href='/manager/admin_DoUserSelect?cp="+cp+"'");
            out.write("</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("id[]");


        for (int i = 0; i < ids.length; i++) {
            UserDao.deleteById(ids[i]);
        }
        resp.sendRedirect("admin_DoUserSelect");
        
    }
}
