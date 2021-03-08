package cn.disino125.servlet.category;

import cn.disino125.entity.Item_Category;
import cn.disino125.service.CatDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/manager/admin_toCateUpdate")
public class toCateUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        ArrayList<Item_Category> cateList = CatDao.selectAll();
        req.setAttribute("cateList",cateList);

        int catId = Integer.parseInt(req.getParameter("id"));
        Item_Category cate = CatDao.selectById(catId);
        req.setAttribute("cate",cate);
        req.getRequestDispatcher("admin_cateUpdate.jsp").forward(req,resp);

    }
}
