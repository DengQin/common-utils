package com.dengqin.utils.base;

/**
 * Created by dq on 2017/9/25.
 */
public class LongUtil {

	/**
	 * 把字符串转换为long
	 *
	 * @param str
	 * @return
	 */
	public static long parseLong(String str) {
		if (str == null || str.length() == 0) {
			return 0L;
		}
		try {
			return Long.parseLong(str);
		} catch (Exception e) {
			return 0L;
		}
	}
}
