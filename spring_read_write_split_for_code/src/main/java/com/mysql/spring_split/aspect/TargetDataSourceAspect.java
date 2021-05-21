package com.mysql.spring_split.aspect;

import com.mysql.spring_split.common.TargetDataSource;
import com.mysql.spring_split.common.datasource.DynamicDataSourceHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TargetDataSourceAspect {
	
	/**
     * aop切面，所有施加@targetDataSource注解的方法都会通过该方法
	 * @param proceedingJoinPoint proceedingJoinPoint
	 * @param targetDataSource @targetDataSource注解中传入的参数
     */
	@Around(value = "@annotation(targetDataSource)")
	public Object around(ProceedingJoinPoint proceedingJoinPoint, TargetDataSource targetDataSource) {
		try {
			// 切换数据源
			DynamicDataSourceHolder.setDataSource(targetDataSource.value());
			// 执行被注解的方法
			Object result = proceedingJoinPoint.proceed();

			return result;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		} finally {
			// 及时的清理ThreadLocal，避免内存泄漏
			DynamicDataSourceHolder.clearDataSource();
		}
	}
}
