package cn.disino125.servlet.category;

import cn.disino125.entity.Item_Category;
import cn.disino125.service.CatDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manager/admin_toAddCate")
public class toAddCate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Item_Category> cateList = CatDao.selectAll();
        req.setAttribute("cateList",cateList);
        req.getRequestDispatcher("admin_addCate.jsp").forward(req,resp);
    }
}
