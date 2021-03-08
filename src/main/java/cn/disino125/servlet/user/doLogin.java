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

@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code1 = req.getParameter("codeValidate");
        String code2 = (String)req.getSession().getAttribute("code");
        PrintWriter out = resp.getWriter();

        if(!code2.equals(code1)){
            out.write("<script>");
            out.write("alert('ValidiertCode falsch');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
            out.close();
        }
        HttpSession session = req.getSession();

        int count = UserDao.selectByIdAndPsw(username, password);
        if(count>0){
            SHOP_USER shop_user = UserDao.selectById(username);
            session.setAttribute("user",shop_user);
            session.setAttribute("isLogin",1);
            if(shop_user.getUSER_STATUS()==2){
                session.setAttribute("isAdmin",1);
                resp.sendRedirect("indexSelect");
            }else {
                resp.sendRedirect("indexSelect");
            }
        }else {
            out.write("<script>");
            out.write("alert('Login Error');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
            out.close();
        }
    }
}
