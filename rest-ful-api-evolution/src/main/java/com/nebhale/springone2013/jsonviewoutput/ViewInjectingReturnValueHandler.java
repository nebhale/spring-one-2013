
package com.nebhale.springone2013.jsonviewoutput;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ViewInjectingReturnValueHandler implements HandlerMethodReturnValueHandler {

    private final HandlerMethodReturnValueHandler delegate;

    public ViewInjectingReturnValueHandler(HandlerMethodReturnValueHandler delegate) {
        this.delegate = delegate;
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return delegate.supportsReturnType(returnType);
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest)
        throws Exception {

        Class<?> viewClass = getDeclaredViewClass(returnType);
        returnValue = wrapResult(returnValue, viewClass);

        delegate.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }

    private Class<?> getDeclaredViewClass(MethodParameter returnType) {
        ResponseView annotation = returnType.getMethodAnnotation(ResponseView.class);
        return annotation != null ? annotation.value() : Object.class;
    }

    private Object wrapResult(Object instance, Class<?> jsonView) {
        return new InstanceAndView(instance, jsonView);
    }
}
