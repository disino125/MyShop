package cn.disino125.servlet.product;

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

@WebServlet("/manager/admin_productSelect")
public class productSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rows = 5;
        int currentPage = 1;
        String cp = req.getParameter("cp");
        if(cp!=null){
            currentPage = Integer.parseInt(cp);
        }

        String keywords = req.getParameter("keywords");
        int[] counts = ProDao.CountForSelect(rows, keywords);
        req.setAttribute("totalCount",counts[0]);
        req.setAttribute("totalPages",counts[1]);
        req.setAttribute("currentPage",currentPage);
        ArrayList<Shop_Product> products = ProDao.selectAll(currentPage,rows,keywords);
        req.setAttribute("pList",products);
        if(keywords!=null){
            req.setAttribute("searchParam","&keywords="+keywords);
        }
        req.getRequestDispatcher("admin_product.jsp").forward(req,resp);
    }
}
