package cn.disino125.servlet.user;

import cn.disino125.entity.SHOP_USER;
import cn.disino125.service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/manager/admin_toUserUpdate")
public class toUserUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String cp = req.getParameter("cp");

        SHOP_USER user = UserDao.selectById(id);

        req.setAttribute("user",user);
        req.setAttribute("cp",cp);

        req.getRequestDispatcher("admin_updateUser.jsp").forward(req,resp);


    }
}
