package com.hzit.hzitshop.exception;


import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class DefaultExceptionHandler {
    private Logger logger = org.slf4j.LoggerFactory.getLogger(DefaultExceptionHandler.class);
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request,
                                                        UnauthorizedException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        logger.error(e.getMessage());
        mv.setViewName("403");
        return mv;
    }
}