package com.dengqin.utils.page;

import java.util.Map;

public interface Dialect {

	public String buildQueryPageSQL(String sql, Map<String, Object> paramMap, int start, int pageSize);
}
