package com.dengqin.utils.base;

import java.util.Map;

/**
 * Created by dq on 2017/9/25.
 */
public class MapUtil {
	public static boolean isEmpty(Map<?, ?> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(Map<?, ?> map) {
		if (map == null || map.isEmpty()) {
			return false;
		}
		return true;
	}
}
