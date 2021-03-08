package cn.disino125.servlet.home;

import cn.disino125.entity.Item_Category;
import cn.disino125.entity.Shop_Product;
import cn.disino125.service.CatDao;
import cn.disino125.service.ProDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectProductList")
public class selectProductList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Item_Category> fList = CatDao.selectCate("father");
        ArrayList<Item_Category> sList = CatDao.selectCate("sons");
        req.setAttribute("fatherList",fList);
        req.setAttribute("sonList",sList);

        String fid = req.getParameter("fid");
        String sid = req.getParameter("sid");
        int id = 0;
        ArrayList<Shop_Product> products = null;
        if(fid!=null){
            id = Integer.parseInt(fid);
            products = ProDao.selectByFId(id);
        }
        if(sid!=null){
            id = Integer.parseInt(sid);
            products = ProDao.selectBySId(id);
        }

        Item_Category category = CatDao.selectById(id);
        req.setAttribute("cate",category);
        req.setAttribute("pList",products);
        req.getRequestDispatcher("productList.jsp").forward(req,resp);
    }
}
