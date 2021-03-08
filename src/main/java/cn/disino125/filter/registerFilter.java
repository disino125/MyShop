package cn.disino125.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/doRegister")
public class registerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String validation = req.getParameter("codeValidate");
        String code = (String)req.getSession().getAttribute("code");
        PrintWriter out = resp.getWriter();
        if(username.equals("")){
            out.print("<script>");
            out.print("alert('Username nicht null');");
            out.print("location.href='register.jsp';");
            out.print("</script>");
            return;
        }

        if(!code.equals(validation)){
            out.print("<script>");
            out.print("alert('ValiCode falsch');");
            out.print("location.href='register.jsp';");
            out.print("</script>");
            return;
        }

        filterChain.doFilter(req,resp);

    }

    @Override
    public void destroy() {

    }
}
