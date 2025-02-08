package com.dandaevit.edu.utils.jsp_utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JSPUtils {
	private final static String JSP_FORMAT = "/WEB-INF/views/%s.jsp";

	public String getPath(String jsp) {
		return JSP_FORMAT.formatted(jsp);
	}
}
