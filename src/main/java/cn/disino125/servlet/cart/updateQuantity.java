package cn.disino125.servlet.cart;

import cn.disino125.service.CartDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateQuantity")
public class updateQuantity extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        String quantity = req.getParameter("count");
        CartDao.UpdateCartQuantity(Integer.parseInt(quantity),Integer.parseInt(cid));
    }
}
