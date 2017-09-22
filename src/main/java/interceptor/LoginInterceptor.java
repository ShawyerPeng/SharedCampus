package interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * 预处理回调方法，实现处理器的预处理（如登录检查）。
     * 第三个参数为响应的处理器，即 controller。
     * 返回 true，表示继续流程，调用下一个拦截器或者处理器。
     * 返回 false，表示流程中断，通过 response 产生响应。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{
        Object obj = request.getSession().getAttribute("admin");
        System.out.println("==========="+request.getSession().getAttribute("admin"));
        if(obj == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        return true;
    }

    /**
     * 当前请求进行处理之后，也就是 Controller 方法调用之后执行，
     * 但是它会在 DispatcherServlet 进行视图返回渲染之前被调用。
     * 此时我们可以通过 modelAndView 对模型数据进行处理或对视图进行处理。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        Object obj = request.getSession().getAttribute("admin");
        modelAndView.addObject("admin", request.getSession().getAttribute("admin"));
    }

    /**
     * 方法将在整个请求结束之后，也就是在 DispatcherServlet 渲染了对应的视图之后执行。
     * 这个方法的主要作用是用于进行资源清理工作的。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }
}
