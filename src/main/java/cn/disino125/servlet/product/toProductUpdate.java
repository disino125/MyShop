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
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/manager/toProductUpdate")
public class toProductUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        String cp = req.getParameter("cp");
        if(pid!=null){
            Shop_Product product = ProDao.selectById(Integer.parseInt(pid));
            req.setAttribute("p",product);
            ArrayList<Item_Category> fList = CatDao.selectCate("father");
            ArrayList<Item_Category> sList = CatDao.selectCate("son");
            req.setAttribute("fatherList",fList);
            req.setAttribute("sonList",sList);
            req.setAttribute("cp",cp);
            req.getRequestDispatcher("admin_productUpdate.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alert('Product Update Error');");
            out.write("location.href='admin_product.jsp';");
            out.write("</script>");
            out.close();
        }
    }
}
