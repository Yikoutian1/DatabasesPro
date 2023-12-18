package com.hang.handler;

import com.hang.result.Result;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName CustomerExceptionHandler
 * @Description 异常处理
 * @Author QiuLiHang
 * @DATE 2023/12/18 018 18:27
 * @Version 1.0
 */


@ControllerAdvice
@Order(-100000)
// AOP技术
public class CustomerExceptionHandler {

    /**
     * 判断错误是否是已定义的已知错误，不是则由未知错误代替，同时记录在log中
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionGet(Throwable e) {
        if (e instanceof Exception) {
            Exception exception = (Exception) e;
            return Result.fail(exception.getMessage());
        }
        return Result.fail("服务器内部发生错误");
    }
}