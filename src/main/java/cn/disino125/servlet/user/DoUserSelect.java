package cn.disino125.servlet.user;

import cn.disino125.dao.BaseDao;
import cn.disino125.entity.SHOP_USER;
import cn.disino125.service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manager/admin_DoUserSelect")
public class DoUserSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currentPage = 1;
        int rows = 5;
        String cp = req.getParameter("cp");
        String keyword = req.getParameter("keywords");
        if(cp!=null){
            currentPage = Integer.parseInt(cp);
        }

        int[] counts = UserDao.CountForSelect(rows,keyword);

        ArrayList<SHOP_USER> list = UserDao.selectAll(currentPage, rows,keyword);

        req.setAttribute("totalUsers",counts[0]);
        req.setAttribute("totalPages",counts[1]);
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("userList",list);
        if(keyword!=null){
            req.setAttribute("searchParam","&keywords="+keyword);
        }
        req.getRequestDispatcher("/manager/admin_user.jsp").forward(req,resp);
    }
}
