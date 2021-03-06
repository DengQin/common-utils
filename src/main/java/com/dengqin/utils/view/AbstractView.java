package com.dengqin.utils.view;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.util.Map;

/**
 * 抽象视图
 */
public abstract class AbstractView extends ModelAndView {

	protected static Log logger2 = LogFactory.getLog(AbstractView.class);

	private AbstractUrlBasedView view = new AbstractUrlBasedView() {

		@Override
		protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			String body = AbstractView.this.getBody(request);
			if (body == null) {
				return;
			}
			response.setContentType(AbstractView.this.getContentType());
			response.setContentLength(body.getBytes().length);
			Writer out = response.getWriter();
			out.write(body);
			out.flush();
		}
	};

	public AbstractView() {
		super.setView(view);
	}

	public abstract String getContentType();

	public abstract String getBody(HttpServletRequest request);

}
