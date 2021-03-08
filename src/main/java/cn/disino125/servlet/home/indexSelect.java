package cn.disino125.servlet.home;

import cn.disino125.entity.Item_Category;
import cn.disino125.service.CatDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/indexSelect")
public class indexSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Item_Category> fList = CatDao.selectCate("father");
        ArrayList<Item_Category> sList = CatDao.selectCate("sons");
        req.setAttribute("fatherList",fList);
        req.setAttribute("sonList",sList);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
