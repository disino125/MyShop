package cn.disino125.servlet.cart;

import cn.disino125.entity.SHOP_USER;
import cn.disino125.entity.Shop_Cart;
import cn.disino125.entity.Shop_Product;
import cn.disino125.service.CartDao;
import cn.disino125.service.ProDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cartAdd")
public class cartAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        String count = req.getParameter("count");
        String flag = req.getParameter("flag");

        HttpSession session = req.getSession();
        int isLogin = (Integer) session.getAttribute("isLogin");
        SHOP_USER user = (SHOP_USER) session.getAttribute("user");
        Shop_Product p = null;

        if(user!=null&&isLogin==1){
            if(pid!=null){
                p = ProDao.selectById(Integer.parseInt(pid));
                Shop_Cart userCart = CartDao.selectCartByUidUndPid(Integer.parseInt(pid),user.getUSER_ID());
                if(userCart!=null){
                    int oldCount = userCart.getCART_P_QUANTITY();
                    int newCount = oldCount+Integer.parseInt(count);
                    CartDao.UpdateCartQuantity(newCount,userCart.getCART_ID());
                }else {
                    Shop_Cart cart = new Shop_Cart(
                            0,
                            p.getPRODUCT_IMG_NAME(),
                            p.getPRODUCT_NAME(),
                            p.getPRODUCT_PRICE(),
                            Integer.parseInt(count),
                            p.getPRODUCT_STOCK(),
                            p.getPRODUCT_ID(),
                            user.getUSER_ID(),
                            1
                    );
                    CartDao.insert(cart);
                }
            }
        }else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alter('please login!');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
            out.close();
        }
        if(flag.equals("b")){
            resp.sendRedirect("showCart");
        }else {
            resp.sendRedirect("selectProductDetail?id="+pid);
        }
    }
}
