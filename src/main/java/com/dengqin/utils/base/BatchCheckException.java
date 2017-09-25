package com.dengqin.utils.base;


import com.dengqin.utils.exception.VisualException;

class BatchCheckException extends VisualException {
	private int rowNum;

	private String message;

	private static final long serialVersionUID = 146458310084088150L;

	public BatchCheckException() {
		super();
	}

	public BatchCheckException(int rowNum, String message) {
		super(message);
		this.rowNum = rowNum;
		this.message = message;
	}

	public int getRowNum() {
		return rowNum;
	}

	@Override
	public String toString() {
		return "第" + (rowNum + 1) + "行," + message;
	}

}
