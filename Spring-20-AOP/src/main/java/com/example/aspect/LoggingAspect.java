package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.jar.JarOutputStream;


@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.example.controller.CourseController.*(..))")
//    private void pointcut() {
//    }

//    @Before("pointcut()")
//    public void log() {
//        logger.info("Logger info -------");
//    }

//    @Before("execution(* com.example.controller.CourseController.*(..))")
//    public void beforeAdvice() {
//        logger.info("Logger info -------");
//    }

//   @Pointcut("execution(* com.example.repository.CourseRepository.findById(*))")
//    private void anyProductRepositoryFindById(){}
//
//    @Before("anyProductRepositoryFindById()")
//    private void beforeCourseRepoOperation(JoinPoint joinPoint){
//        logger.info("Before (findById) : -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }

    //Within
//    @Pointcut("within(com.example.controller..*)")
//    private void anyControllerOperation() {
//
//    }
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    private void anyServiceOperation() {
//    }
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before () -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    private void anyDeleteCourseOperation() {
//
//    }
//
//    @Before("anyDeleteCourseOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint) {
//        logger.info("Before () -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyDeleteCourseOperation() {
    }

//    @AfterReturning(pointcut = "anyDeleteCourseOperation()", returning = "result")
//    public void afterReturningControllerAdvice(JoinPoint joinPoint, Object result) {
//        logger.info("After returning -> Method: {} - result: {}", joinPoint.getSignature().toShortString(), result.toString());
//    }
//
//    @AfterReturning(pointcut = "anyDeleteCourseOperation()", returning = "result")
//    public void afterReturningControllerAdvice(JoinPoint joinPoint, List<Object> result) {
//        logger.info("After returning List(List) -> Method: {} - result: {}", joinPoint.getSignature().toShortString(), result.toString());
//    }

//    @AfterThrowing(pointcut = "anyDeleteCourseOperation()", throwing = "exception")
//    public void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception) {
//        logger.info("After Throwing -> Method: {} - Exception: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
//    }

//    @After("anyDeleteCourseOperation()")
//    public void afterControllerAdvice(JoinPoint joinPoint) {
//        logger.info("After finally -> Method: {}", joinPoint.getSignature().toShortString());
//    }

    @Pointcut("@annotation(com.example.annotation.Loggable)")
    private void anyLoggableMethodOperation() {

    }

    @Around("anyLoggableMethodOperation()")
    public Object anyLoggableMethodOperationAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        logger.info("Before () -> Method: {} - Parameters: {}", proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());

        Object results = null;
        try {
            results = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info("After -> Method: {} - Results: {}", proceedingJoinPoint.getSignature().toShortString(), results.toString());
        return results;
    }
}
