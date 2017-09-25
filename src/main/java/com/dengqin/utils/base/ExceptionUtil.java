package com.dengqin.utils.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照指定的方式输出异常信息
 *
 * Created by dq on 2017/9/25.
 */
public class ExceptionUtil {

	private static Logger log = LoggerFactory.getLogger(ExceptionUtil.class);

	/**
	 * 输出指定包，指定行数的异常信息，包括堆栈
	 * 
	 * @param e
	 *            异常
	 * @param packageName
	 *            包名
	 * @param showLineNum
	 *            需要展示的行数
	 * @return
	 */
	public static String showExceptionMsg(Exception e, String packageName, int showLineNum) {
		StackTraceElement[] arr = e.getStackTrace();
		if (arr == null) {
			log.error(e.getMessage());
			return "getStackTrace为空";
		}
		List<String> list = new ArrayList<String>();
		for (StackTraceElement stackTraceElement : arr) {
			if (stackTraceElement == null) {
				continue;
			}
			if (list.size() >= showLineNum) {
				break;
			}
			String s = StringUtil.trim(stackTraceElement.toString());
			if (s.contains(packageName)) {
				list.add(s);
			}
		}
		String stackMsg = "";
		for (String s : list) {
			stackMsg += "\n\t" + s;
		}
		return e.getMessage() + stackMsg;
	}

	public static String showExceptionMsg(Exception e, String packageName) {
		return showExceptionMsg(e, packageName, 3);
	}

	public static void main(String[] args) {
		showExceptionMsg(new Exception(""),"com.duowan");
	}
}
