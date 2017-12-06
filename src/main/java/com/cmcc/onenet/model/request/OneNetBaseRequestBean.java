package com.cmcc.onenet.model.request;

import com.cmcc.onenet.constants.Constants;
import org.springframework.security.access.method.P;

import java.util.Map;

import static com.cmcc.onenet.constants.Constants.Method.GET;
import static com.cmcc.onenet.constants.Constants.Method.POST;

/**
 * @Author: wannengjia@gamil.com
 * @Description:
 * @Date: Create in 2017/12/7 0:29
 */
public class OneNetBaseRequestBean<T> {

	private String apiKey;

	private String contentType;

	private String url;

	private Map<String, Object> urlParam;

	private T content;

	private String method = POST.toString();

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public Map<String, Object> getUrlParam() {
		return urlParam;
	}

	public void setUrlParam(Map<String, Object> urlParam) {
		this.urlParam = urlParam;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
