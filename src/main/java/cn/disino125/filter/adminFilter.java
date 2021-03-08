package cn.disino125.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/manager/*")
public class adminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        int isAdmin = 0;

        if(req.getSession().getAttribute("isAdmin")!=null){
            isAdmin = (int)req.getSession().getAttribute("isAdmin");
        }
        String uri = req.getRequestURI().substring(req.getContextPath().length());
        PrintWriter out = resp.getWriter();
        if(uri.contains("admin_")){
            if(isAdmin==1){
                filterChain.doFilter(req,resp);
            }else {
                out.write("<script>");
                out.write("alert('Bitte Login');");
                out.write("location.href='adminLogin.jsp';");
                out.write("</script>");
                out.close();
                return;
            }
        }else{
            filterChain.doFilter(req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
