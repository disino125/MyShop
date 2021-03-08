package cn.disino125.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/doLogout")
public class doLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        session.removeAttribute("isLogin");
        if(session.getAttribute("isAdmin")!=null){
            session.removeAttribute("isAdmin");
            resp.sendRedirect("/MyShop/manager/adminLogin.jsp");
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
