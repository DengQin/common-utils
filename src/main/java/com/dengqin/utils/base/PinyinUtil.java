package com.dengqin.utils.base;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 汉语的一些转换
 * 
 * Created by dq on 2017/9/25.
 */
public class PinyinUtil {
	private static Logger log = LoggerFactory.getLogger(PinyinUtil.class);

	private static final HanyuPinyinOutputFormat defaultFormat;

	static {
		defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	}

	/**
	 * 获取汉字串拼音，英文字符不变
	 *
	 * @param c
	 * @return
	 */
	public static String getPinyin(Character c) {
		String[] strs;
		try {
			strs = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			throw new RuntimeException(e.getMessage());
		}
		if (strs == null) {
			return null;
		}
		return strs[0];
	}

	/**
	 * 将汉语转换成对应的拼音，可以用指定的分割符分割
	 * 
	 * @param content
	 *            汉语内容
	 * @param split
	 *            指定的分割符（每个汉字分割）
	 * @return
	 */
	public static String getPinyin(String content, String split) {
		// TODO 没有做缓存.
		StringBuilder sb = new StringBuilder();
		for (char c : content.toCharArray()) {
			String pinyin = getPinyin(c);
			if (sb.length() > 0) {
				sb.append(split);
			}
			if (pinyin != null) {
				sb.append(pinyin);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(getPinyin("你好", ""));
	}
}
