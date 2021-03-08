package cn.disino125.servlet.product;

import cn.disino125.service.ProDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager/admin_doProductDel")
public class doProductDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        String cp = req.getParameter("cp");
        PrintWriter out = resp.getWriter();
        if(pid!=null){
            int count = ProDao.deleteById(Integer.parseInt(pid));
            if(count>0){
                resp.sendRedirect("admin_productSelect?cp="+cp);
            }else {
                out.write("<script>");
                out.write("alert('Product ID Error');");
                out.write("location.href='admin_product.jsp';");
                out.write("</script>");
                out.close();
            }
        }else {
            out.write("<script>");
            out.write("alert('Product Delete Error');");
            out.write("location.href='admin_product.jsp';");
            out.write("</script>");
            out.close();
        }
    }
}
