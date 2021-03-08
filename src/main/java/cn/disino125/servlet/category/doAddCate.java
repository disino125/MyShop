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

@WebServlet("/manager/admin_doAddCate")
public class doAddCate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String parent = req.getParameter("parent");
        int pId = Integer.parseInt(parent);

        String cateName = req.getParameter("cateName");
        Item_Category newCate = new Item_Category(0, cateName, pId);

        int count = CatDao.insert(newCate);

        if(count>0){
            resp.sendRedirect("admin_cateSelect");
        }else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alter('Kategorie hinfügen nicht geklappt！！！');");
            out.write("location.href='/manager/admin_addCate.jsp';");
            out.write("</script>");
        }



    }
}
