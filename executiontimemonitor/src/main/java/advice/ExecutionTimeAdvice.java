package advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by atryfo03 on 11/27/17.
 */

@Aspect
public class ExecutionTimeAdvice {

    @Around("@annotation(annotation.ExecutionTime)")
    public Object executionTime(ProceedingJoinPoint point){
        Object retProceed = null;
        long start = System.currentTimeMillis();
        try {
            retProceed = point.proceed();
            long total = System.currentTimeMillis() -start;
            System.out.println(point.getSignature()+" took "+total+" ms to finish");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return  retProceed;
    }

    @After("@annotation(annotation.ExecutionTime)")
    public void afterExectime(){
        System.out.println("Finished AFTER!!!");
    }
}
