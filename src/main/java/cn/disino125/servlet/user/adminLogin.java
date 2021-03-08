package cn.disino125.servlet.user;

import cn.disino125.entity.SHOP_USER;
import cn.disino125.service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager/adminLogin")
public class adminLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");


        PrintWriter out = resp.getWriter();

        int count = UserDao.selectByIdAndPsw(username, password);
        HttpSession session = req.getSession();
        if(count>0){
            SHOP_USER shop_user = UserDao.selectById(username);
            session.setAttribute("user",shop_user);
            session.setAttribute("isLogin",1);
            if(shop_user.getUSER_STATUS()==2){
                session.setAttribute("isAdmin",1);
                resp.sendRedirect("admin_index.jsp");
            }else {
                resp.sendRedirect("/MyShop/index.jsp");
            }
        }else {
            out.write("<script>");
            out.write("alert('Login Error');");
            out.write("location.href='/MyShop/index.jsp';");
            out.write("</script>");
            out.close();
        }
    }
}
