package com.video.codec.exception;

import cn.hutool.core.io.IORuntimeException;
import com.video.codec.domain.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zhangbo
 * @date 2020/6/29 14:14
 * @description 全局异常处理
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Response<?> handleException(Exception e) {
        log.error("系统内部异常，异常信息", e);
        return Response.failed();
    }

    @ExceptionHandler(value = IORuntimeException.class)
    public Response<?> handleIOException(Exception e) {
        log.error("IO异常，异常信息", e);
        return Response.failed(e);
    }
}
