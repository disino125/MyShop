package cn.disino125.servlet.cart;

import cn.disino125.entity.SHOP_USER;
import cn.disino125.entity.Shop_Cart;
import cn.disino125.service.CartDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/orderSelect")
public class orderSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int isLogin = (Integer) session.getAttribute("isLogin");
        SHOP_USER user = (SHOP_USER) session.getAttribute("user");
        int total = 0;
        if(user!=null&&isLogin==1) {
            String cids = req.getParameter("cids");
            String[] cid = cids.split(",");
            ArrayList<Shop_Cart> orderCarts = new ArrayList<>();
            for (int i = 0; i <cid.length ; i++) {
                Shop_Cart orderCart = CartDao.selectById(Integer.parseInt(cid[i]));
                orderCarts.add(orderCart);
                total+=orderCart.getCART_P_QUANTITY()*orderCart.getCART_P_PRICE();
            }
            req.setAttribute("ocs",orderCarts);
            req.setAttribute("total",total);
            req.getRequestDispatcher("order.jsp").forward(req,resp);
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
