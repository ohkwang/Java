package kr.sity.SpringBootInterceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CertificationInterceptor implements HandlerInterceptor {

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("first exe");
		
		Enumeration params = request.getParameterNames();
		while(params.hasMoreElements()) {
		  String name = (String) params.nextElement();
		  System.out.print(name + " : " + request.getParameter(name) + "     "); 
		}
		
		System.out.println("request: "+request.getQueryString());
		System.out.println("response: "+response.getContentType());
		
        return true;
//		return false;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("second exe");
        System.out.println("request: "+request.getQueryString());
		System.out.println("response: "+response.toString());
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO Auto-generated method stub
    	System.out.println("third exe");
    	System.out.println("request: "+request.getQueryString());
		System.out.println("response: "+response.toString());
    }
}
