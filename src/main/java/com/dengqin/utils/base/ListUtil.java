package com.dengqin.utils.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * List集合相关判断
 * 
 * Created by dq on 2017/9/25.
 */
public class ListUtil {

	public static boolean isEmpty(Collection<?> c) {
		if (c == null || c.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(Collection<?> c) {
		if (c == null || c.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * 指定内容是否在集合中
	 * 
	 * @param o
	 * @param c
	 * @return true：在集合中；false：不在集合中
	 */
	public static boolean isInList(Object o, List<?> c) {
		if (o == null || c == null || c.isEmpty()) {
			return false;
		}
		for (Object t : c) {
			if (o.equals(t)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 忽略大小写，判断指定字符串是否在集合里面
	 * 
	 * @param o
	 *            指定的字符串
	 * @param c
	 *            集合
	 * @return true：在集合中；false：不在集合中
	 */
	public static boolean strIgnoreCaseInList(String o, List<String> c) {
		if (o == null || c == null || c.isEmpty()) {
			return false;
		}
		for (String s : c) {
			if (o.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("he");
		list.add("ss");

		System.out.println(isInList("he", list));

	}
}
