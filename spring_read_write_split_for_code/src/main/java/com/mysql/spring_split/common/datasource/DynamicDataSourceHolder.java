package com.mysql.spring_split.common.datasource;

/**
 * 动态切换数据源
 */
public class DynamicDataSourceHolder {
	// 使用ThreadLocal把数据源与当前线程绑定
	public static final ThreadLocal<String> holder = new ThreadLocal<>();

	public static void setDataSource(String name) {
		holder.set(name);
	}

	public static String getDataSource() {
		return holder.get();
	}

	/**
	 * 清理对应的key-value，避免内存泄露
	 */
	public static void clearDataSource() {
		holder.remove();
	}
}
