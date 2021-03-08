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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectProductDetail")
public class selectProductDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Item_Category> fList = CatDao.selectCate("father");
        ArrayList<Item_Category> sList = CatDao.selectCate("sons");
        req.setAttribute("fatherList",fList);
        req.setAttribute("sonList",sList);
        String id = req.getParameter("id");
        Shop_Product product = null;
        if(id!=null){
            product = ProDao.selectById(Integer.parseInt(id));
            req.setAttribute("p",product);
        }
        if(product!=null){
            ArrayList<Shop_Product> recommendList =
                    ProDao.selectAllSameSId(product.getPRODUCT_SID(), product.getPRODUCT_ID());
            req.setAttribute("rl",recommendList);
        }

        HttpSession session = req.getSession();
        ArrayList<Integer> ids = (ArrayList<Integer>) session.getAttribute("ids");

        if(ids!=null){
            if(!ids.contains(Integer.parseInt(id))){
                if(ids.size()<5){
                    ids.add(Integer.parseInt(id));
                }else {
                    ids.remove(0);
                    ids.add(Integer.parseInt(id));
                }
            }
            ArrayList<Shop_Product> allRecently = ProDao.selectAllRecently(ids);
            session.setAttribute("recently",allRecently);
        }else {
            ids = new ArrayList<>();
            session.setAttribute("ids",ids);
        }


        req.getRequestDispatcher("productDetail.jsp").forward(req,resp);
    }
}
