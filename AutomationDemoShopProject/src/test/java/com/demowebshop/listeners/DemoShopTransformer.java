package com.demowebshop.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class DemoShopTransformer implements IAnnotationTransformer  {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(RetryListener.class);//if testcase fails call RetryListener it will transform and re execute failed cases
	}	
}
