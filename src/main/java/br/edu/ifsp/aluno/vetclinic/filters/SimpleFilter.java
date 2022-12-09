package br.edu.ifsp.aluno.vetclinic.filters;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SimpleFilter implements Filter {
   @Override
   public void destroy() {}

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain) 
      throws IOException, ServletException {
      
      HttpServletRequest req = (HttpServletRequest) request;

      HttpServletResponse res = (HttpServletResponse) response;

      if (req.getSession().getAttribute("veterinario_id") == null) { 
         System.out.println(req.getRequestURI());
         if (req.getRequestURI().contains("authorized")) res.sendRedirect("/");
      }

      filterchain.doFilter(request, response);
   }

   @Override
   public void init(FilterConfig filterconfig) throws ServletException {}
}