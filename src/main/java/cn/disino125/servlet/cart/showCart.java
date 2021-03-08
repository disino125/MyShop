package cn.disino125.servlet.cart;

import cn.disino125.entity.Item_Category;
import cn.disino125.entity.SHOP_USER;
import cn.disino125.entity.Shop_Cart;
import cn.disino125.entity.Shop_Product;
import cn.disino125.service.CartDao;
import cn.disino125.service.CatDao;
import cn.disino125.service.ProDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/showCart")
public class showCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        int isLogin = (Integer) session.getAttribute("isLogin");
        SHOP_USER user = (SHOP_USER) session.getAttribute("user");

        if(user!=null&&isLogin==1){
            String uid = user.getUSER_ID();
            ArrayList<Shop_Cart> carts = CartDao.selectAllCartsByUID(uid);
            req.setAttribute("carts",carts);
            req.getRequestDispatcher("cart.jsp").forward(req,resp);
        }else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alter('please login!');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
            out.close();
        }
    }
}
