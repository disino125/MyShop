package cn.disino125.servlet.category;
import cn.disino125.service.CatDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/manager/admin_doDeleteCate")
public class cateDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int catId = Integer.parseInt(req.getParameter("id"));
        int parentId = Integer.parseInt(req.getParameter("parentId"));

        if(parentId==0){
            CatDao.deleteAllByParentId(catId);
            CatDao.deleteById(catId);
            resp.sendRedirect("admin_cateSelect");
        }else {
            int count = CatDao.deleteById(catId);
            if(count>0){
                resp.sendRedirect("admin_cateSelect");
            }else {
                PrintWriter out = resp.getWriter();
                out.write("<script>");
                out.write("alter('Kategorie löschen scheitert!');");
                out.write("location.href='/manager/admin_cateSelect';");
                out.write("</script>");
            }
        }
    }
}
