package jqchen.dentalforum.http.cos.common_utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import jqchen.dentalforum.http.cos.exception.AbstractCosException;
import jqchen.dentalforum.http.cos.exception.UnknownException;


public class CommonPathUtils {

	private static final String PATH_DELIMITER = "/";

	public static String encodeRemotePath(String urlPath) throws AbstractCosException {
		StringBuilder pathBuilder = new StringBuilder();
		String[] pathSegmentsArr = urlPath.split(PATH_DELIMITER);

		for (String pathSegment : pathSegmentsArr) {
			if (!pathSegment.isEmpty()) {
				try {
					pathBuilder.append(PATH_DELIMITER).append(URLEncoder.encode(pathSegment, "UTF-8").replace("+", "%20"));
				} catch (UnsupportedEncodingException e) {
					String errMsg = "Unsupported ecnode exception:" + e.toString();
					throw new UnknownException(errMsg);
				}
			}
		}
		if (urlPath.endsWith(PATH_DELIMITER)) {
			pathBuilder.append(PATH_DELIMITER);
		}
		return pathBuilder.toString();
	}
}
