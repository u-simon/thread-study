package com.simon.thread;

import com.google.common.collect.Lists;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author simon
 * @Date 2019-06-18 21:20
 */
public class execrise {

	public static void main(String[] args) {
		try {
			while (true) {
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(OOMTest.class);
				enhancer.setUseCache(false);
				enhancer.setCallback(new MethodInterceptor() {
					@Override
					public Object intercept(Object o, Method method, Object[] objects,
							MethodProxy methodProxy) throws Throwable {
						return methodProxy.invokeSuper(o, objects);
					}
				});
			}
		} catch (Throwable e) {

		}
	}

	static class OOMTest {

	}



	/**
	 * 内存够用不会回收
	 */
	private static void softRefMemoryEnough() {
		Object o = new Object();
		SoftReference<Object> softReference = new SoftReference<>(o);
		System.out.println(o);
		System.out.println(softReference);
		o = null;
		System.gc();
		System.out.println(o);
		System.out.println(softReference);
	}

	/**
	 * Jvm配置 故意产生大对象 配置小内存让他不够用导致oom 看软引用的回收情况 -Xms5m -Xmx5m -XX:+PrintGCDetails
	 */
	private static void softRefMemoryNotEnough() {
		Object o = new Object();
		SoftReference<Object> softReference = new SoftReference<>(o);
		System.out.println(o);
		System.out.println(softReference);
		o = null;
		try {
			byte[] data = new byte[30 * 1024 * 1024];
		} catch (Exception e) {

		} finally {
			System.out.println(o);
			System.out.println(softReference);
		}
	}
}
