//package com.example.servicezuul.application;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Component
//public class AccessFilter extends ZuulFilter {
//    // pre：路由之前
//    // routing：路由之时
//    // post： 路由之后
//    // error：发送错误调用
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() throws ZuulException {
//        RequestContext requestContext = RequestContext.getCurrentContext();
//        HttpServletRequest request = requestContext.getRequest();
//
//        String name = request.getParameter("name");
//        if(StringUtils.isBlank(name) || !"test".equals(name)){
//            // zuul过滤该请求
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(401);
//            requestContext.setResponseBody("name is invalid");
//        } else {
//        }
//        return null;
//    }
//}
//
