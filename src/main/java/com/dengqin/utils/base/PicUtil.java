package com.dengqin.utils.base;

import com.dengqin.utils.exception.VisualException;
import com.dengqin.utils.vo.PicWhVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.IOUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by dq on 2017/9/26.
 */
public class PicUtil {

	private static final Logger log = LoggerFactory.getLogger(PicUtil.class);

	/**
	 * 获取图片尺寸（宽和高）
	 */
	public static PicWhVo getPicWhBo(File file) {
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			BufferedImage src = javax.imageio.ImageIO.read(is);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			return new PicWhVo(width, height);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new VisualException("获取图片尺寸失败," + e.getMessage());
		} finally {
			IOUtils.closeQuietly(is);
		}
	}
}
