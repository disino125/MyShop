package cn.disino125.servlet.product;

import cn.disino125.entity.Shop_Product;
import cn.disino125.service.ProDao;
import com.jspsmart.upload.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manager/admin_doProductUpdate")
public class doProductUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SmartUpload su = new SmartUpload();
        su.initialize(this.getServletConfig(),req,resp);
        try {
            su.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        Files fs = su.getFiles();
        File f = fs.getFile(0);
        String fName = f.getFileName();
        try {
            su.save("D:\\MyShop\\src\\main\\webapp\\img\\products");
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        Request request = su.getRequest();
        String pid = request.getParameter("pid");
        String proName = request.getParameter("proName");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String stock = request.getParameter("stock");
        String parentId = request.getParameter("parentId");
        String cp = request.getParameter("cp");

        Shop_Product product = new Shop_Product(
                Integer.parseInt(pid),
                proName,
                description,
                Integer.parseInt(price),
                Integer.parseInt(stock),
                Integer.parseInt(parentId.split("-")[0]),
                Integer.parseInt(parentId.split("-")[1]),
                fName);

        int count = ProDao.update(product);

        if(count>0){
            resp.sendRedirect("admin_productSelect?cp="+cp);
        }else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alter('Update Error?????????');");
            out.write("location.href='/manager/admin_productUpdate.jsp';");
            out.write("</script>");
        }
    }
}
