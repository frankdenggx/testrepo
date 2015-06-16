/**
 * CopyRight: 2005-2008 GuangZhou Thinker Tech.Co.,Ltd.All Right Reserved.
 * JDK Version: 1.6.15
 * File Version: 1.0
 * File Name: UseCase.java
 * Description: 
 * Author: yoyudenghihi
 * Date: 2009.10.26
 * History:
 * <author>				<time>				<version>				<desc>
 * yoyudenghihi			2009.10.26			1.0						create
 */
package edu.frank.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

/**
 * UseCase
 * @author yoyudenghihi
 *
 */
public @interface UseCase {
	public int id();
	public String description() default "no description";
}
