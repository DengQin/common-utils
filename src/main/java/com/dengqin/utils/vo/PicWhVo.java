package com.dengqin.utils.vo;

/**
 * 图片的高和宽
 */
public class PicWhVo {

	/**
	 * 图片宽度
	 */
	private int width;

	/**
	 * 图片高度
	 */
	private int height;

	public PicWhVo() {
		super();
	}

	public PicWhVo(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "PicWhVo [width=" + width + ", height=" + height + "]";
	}

}
