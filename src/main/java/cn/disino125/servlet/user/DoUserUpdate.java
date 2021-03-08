package cn.disino125.servlet.user;

import cn.disino125.entity.SHOP_USER;
import cn.disino125.service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager/admin_DoUserUpdate")
public class DoUserUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String cp = req.getParameter("cp");

        String username=req.getParameter("username");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        String gender=req.getParameter("gender");
        String birthday=req.getParameter("birthday");
        String mobil=req.getParameter("mobil");
        String email=req.getParameter("email");
        String address=req.getParameter("address");
        String status = req.getParameter("userStatus");

        int us = 1;
        if(status!=null){
            us = Integer.parseInt(status);
        }

        SHOP_USER shop_user =
                new SHOP_USER(username, name, password, gender, birthday,
                        null, email, mobil, address, us);


        int count = UserDao.update(shop_user);

        if(count>0){
            resp.sendRedirect("admin_DoUserSelect?cp="+cp);
        }else{
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alter('User hinfügen Error！！！')");
            out.write("location.href='/manager/admin_addUser.jsp?id="+username+"'");
            out.write("</script>");
        }
    }
}
